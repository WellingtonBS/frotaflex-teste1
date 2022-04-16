pipeline {
    agent any 
    stages {
        stage ('Build Backend') {
            steps {
                bat 'mvn clean package -DskipTests=true'
            }
        }


        stage ('Funcional Test') {
            steps {
                dir('Funcional-test') {
                    git credentialsId: 'github_login', url: 'https://github.com/WellingtonBS/task-funcional-test'
                    bat 'mvn test'
                }
            }
        }

        stage ('Funcional Test Frota') {
                            steps {
                                dir('Funcional-test-Frota') {
                                    git credentialsId: 'github_login', url: 'https://github.com/WellingtonBS/frotaflex-teste1'
                                    bat 'mvn test'
                                }
                            }
                        }
    }
}



