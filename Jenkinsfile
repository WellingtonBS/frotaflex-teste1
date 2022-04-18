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
        unsuccessful {
            emailext attachLog: true, body: 'See the attached log below', subject: 'Build Frota-Teste', to: 'wellington_frh+jenkins@hotmail.com'
        }
        fixed {
            emailext attachLog: true, body: 'See the attached log below', subject: 'Build final Frota-Teste', to: 'wellington_frh+jenkins@hotmail.com'
        }
    }
}



