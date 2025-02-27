pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Lucas090122/inclass-6.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
