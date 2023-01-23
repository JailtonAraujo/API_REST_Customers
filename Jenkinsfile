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
                    sh 'docker build -t custumerapi .'
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
