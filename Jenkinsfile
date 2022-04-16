pipeline {
    agent any 
    stages {
        stage ('Build Backend') {
            steps {
                bat 'mvn clean package -DskipTests=true'
            }
        }

        stage ('Deploy Backend') {
            steps {
                deploy adapters: [tomcat9(credentialsId: 'TOMCAT', path: '', url: 'http://localhost:8095/')], contextPath: 'tasks-backend', war: 'target\\tasks-backend.war'
            } 
        }
        stage ('API Test') {
            steps {
                dir('api-test') {
                    //git credentialsId: 'github_login', url: 'https://github.com/WellingtonBS/tasks-api-test'
                    git credentialsId: 'github_login', url: 'https://github.com/WellingtonBS/api-test-new'
                    bat 'mvn test'
                }
            }
        }
        stage ('Deploy Frontend') {
            steps {
                dir('frontend') {
                    git credentialsId: 'github_login', url: 'https://github.com/WellingtonBS/tasks-frontend'
                    bat 'mvn clean package'
                    deploy adapters: [tomcat9(credentialsId: 'TOMCAT', path: '', url: 'http://localhost:8095/')], contextPath: 'tasks', war: 'target\\tasks.war'
                } 
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
    }
}



