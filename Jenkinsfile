pipeline {
    agent any
    environment {
            MAVEN_HOME = "C:\\Program Files\\maven"
            PATH = "${env.PATH};${env.MAVEN_HOME}\\bin"
        }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Lucas090122/inclass-6.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }

            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    jacoco execPattern: '**/target/jacoco.exec'
                }
            }
        }
    }
}
