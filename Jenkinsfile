pipeline {
    agent any 
    stages {
        stage ('Build Backend') {
            steps {
                //bat 'mvn clean package -DskipTests=true'
                bat 'mvn test'
            }
        }
    }
    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'

        }

    }
}



