properties([
  parameters([
    string(name: 'IMAGE_TAG', defaultValue: '11', description: 'Image TAG', )
   ])
])

pipeline {
    environment {
        registry = "hhssaaffii/micro-map"
        registryCredential = ''
        dockerImage = ''
    }
    agent any
    stages {
        stage("git checkout") {
            steps{
                git 'https://github.com/hhammidd/micro-map.git'
            }
        }

        stage("build-test") {
            steps{
                sh "mvn clean install"
            }
        }
        stage("build Image") {
            steps{
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }

        stage("Push image") {
            steps {
                script {
                    docker.withRegistry( '' ) {
                        dockerImage.push()
                    }
                }
            }
        }

/*
        stage("Remove Unused docker image") {
            steps{
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }

        stage("Pull image from docker registry") {
            steps{
                sh "docker pull hhssaaffii/micro-map:${params.IMAGE_TAG}"
            }
        }
*/

        stage("Remove Unused docker image") {
                     steps{
                    script {
                        try {

                            sh "docker rmi $registry:${BUILD_NUMBER.toInteger()-2}"
                    }
                        } catch (Throwable e) {
                                          echo "Caught ${e.toString()}"
                                                      currentBuild.result = "SUCCESS"
                                      }
                    }

        }

        stage("Install helm and deploy") {
            steps{
                sh " helm upgrade micro-map  ~/apps/app1/app-jenkins/helm/micro-map/ --set tag=${params.IMAGE_TAG}"
            }
        }

    }
}