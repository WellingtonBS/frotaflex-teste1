pipeline {
    agent any 
    stages {
        stage ('Build Backend') {
            steps {
                bat 'mvn clean package -DskipTests=true'
            }
        }
        stage ('Unit Tests') {
            steps {
                bat 'mvn test'
            }
        }
        stage ('Sonar Analysis') {
            environment {
                scannerHome = tool 'SONAR_SCANNER'
                }
                steps {
                   withSonarQubeEnv('SONAR_LOCAL') {
                    bat "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=NewDeployBack  -Dsonar.host.url=http://localhost:9000 -Dsonar.login=a10b00a11f39951d265ee9a8b7564660184a35ce -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/.mvn/**,**/src/test/**,**/model/**,**Application.java"
                }
            }
        }
        //stage ('Quality Gate') {
        //    steps {
        //        sleep(20)
        //        timeout(time: 1, unit: 'MINUTES') {
        //        waitForQualityGate abortPipeline: true
        //        }
        //    }
        //}
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



