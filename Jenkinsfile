pipeline{
    agent any

    tools{
        maven '3.8.7'
    }

    stages{
        stage('building project'){
            steps{
                echo 'Building maven project'
                sh 'mvn clean package'
            }
        }
    }
}
