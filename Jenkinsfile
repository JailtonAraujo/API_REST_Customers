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
                    sh 'docker build -t jai1998/api-customer .'
                }
            }
        }

        stage('pushing docker hub'){
            steps{
                echo 'pushung docker hub...'
                script{
                    
                    withCredentials([string(credentialsId: 'dockerp', variable: 'dockerpass')]) {
                    sh 'docker login -u jai1998 -p ${dockerpass}'
                    }
                    
                    sh 'docker push jai1998/api-customer'

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
