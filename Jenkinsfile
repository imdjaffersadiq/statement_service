pipeline {
    tools{
        maven "mvn"
    }    
  agent {
    kubernetes {
      label "maven-skopeo-agent"
      cloud "openshift"
    }
  }

  environment {
    // Define global variables
    // Set Maven command to always include Nexus Settings
    def mvnHome = tool 'mvn'
    mvnCmd = "mvn -s ./nexus_settings.xml"

    // Images and Projects
    imageName = "statement-service-git"
    devProject = "mw-sit"

    // Tags
    devTag = "0.0-0"

    destApp ="mw-sit"
  }

  stages {
    // Checkout Source Code.
    stage('Checkout Source') {
      steps {
        git branch: 'main',  url: 'https://github.com/imdjaffersadiq/statement_service.git'
        script {
          def pom = readMavenPom file: 'pom.xml'
          def version = pom.version

          // Set the tag for the development image: version + build number
          devTag = "${version}-" + currentBuild.number
        }
      }
    }
    // Build the middleware-customerapis Application in the directory 'mws'
    stage('Build jar') {
      steps {
        script {
          echo "Building version ${devTag}"

          //TBD: Execute the Maven Build
          sh "${mvnCmd} clean package -DskipTests"

        }
      }
    }

    stage('Publish to Nexus') {
      steps {
        echo "Publish to Nexus"

        // Publish to Nexus
        sh "${mvnCmd} deploy -DskipTests=true -DaltDeploymentRepository=nexus::default::http://192.168.10.190:8081/repository/maven-releases"

      }
    }
    // Build the OpenShift Image in OpenShift and tag it.
    stage('Build and Tag OpenShift Image') {
      steps {
        echo "Building OpenShift container image ${imageName}:${devTag} in project ${devProject}."

        script {
          echo "Inside Build and Tag Openshift Image"
          //  Build Image (binary build), tag Image
          sh "oc start-build ${imageName} --from-file=http://192.168.10.190:8081/repository/maven-releases/com/alahli/middleware/connector/statement/Middleware-statement/1.0.1/Middleware-statement-1.0.1.jar --follow -n=${devProject}"
          sh "oc tag ${imageName}:latest ${imageName}:${devTag} -n=${devProject}"
        }
      }
    }
    // Deploy the built image to the Development Environment.
    stage('Deploy to Dev') {
      steps {
        script {
          echo "Deploying container image to Development Project"

          //  Deploy to development Project
          //      Set Image, Set VERSION
          //      (Re-) Create ConfigMap
          //      Make sure the application is running and ready before proceeding
          // Update the Image on the Development Deployment Config
          openshift.withCluster() {
            openshift.withProject("${devProject}") {
              // OpenShift 4
              openshift.set("image", "deployment/${imageName}", "${imageName}=image-registry.openshift-image-registry.svc:5000/${devProject}/${imageName}:${devTag}")

              echo "Container image was set"
              

              
              // Deploy the development application.

              sh "oc rollout status deployment ${imageName} -n=${devProject}"

              echo "Deployment Started"
              // Wait for application to be deployed
              sleep 5
              def deployment = openshift.selector("deployments", "${imageName}").object()

              echo "${deployment}"

            }
          }
        }
      }
    }

    // Copy Image to Nexus Container Registry

  }
}
