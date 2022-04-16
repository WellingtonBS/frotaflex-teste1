pipeline {
    agent any 
    stages {
        /*stage ('Build Backend') {
            steps {
                //bat 'mvn clean package -DskipTests=true'
                bat 'mvn test'
            }
        }*/

        stage ('Funcional Test Frota') {
                            steps {
                                //dir('Funcional-test-Frota') 
                                {
                                    git credentialsId: 'github_login', url: 'https://github.com/WellingtonBS/frotaflex-teste1'
                                    bat 'mvn test'
                }
            }
        }
    }
    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'

        }

    }
}



