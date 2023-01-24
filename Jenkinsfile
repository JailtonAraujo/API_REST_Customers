pipeline{
    agent any

    tools{
        maven '3.8.7'
    }

    stages{
        stage('building project'){
            steps{
                echo 'Building maven project'
                // checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JailtonAraujo/API_REST_Customers']]])
                sh 'mvn clean install'
            }
        }

        stage('building docker image'){
            steps{
                echo 'Building docker image'
                script{
                    // sh 'docker build -t jai1998/api-customer .'
                    dockerapp = docker.build("jai1998/api-customer",'-t ./')
                }
            }
        }

        stage('pushing docker hub'){
            steps{
                echo 'pushung docker hub...'
                script{
                    // sh 'docker push jai1998/api-customer'
                    docker.withRegistry('https://registry.hub.docker.com','dockerhub')
                    dockerapp.push('latest')
                }
            }
        }

        stage('up container'){
            steps{
                echo 'uping container'
                script{
                    sh 'docker compose up -d'
                }
            }
        }
    }
}
