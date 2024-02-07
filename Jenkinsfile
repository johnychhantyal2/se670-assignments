pipeline {
    agent any

    stages {
        stage('Preparation') {
            steps {
                git 'https://github.com/johnychhantyal2/se670-assignments.git'
                sh 'mvn clean'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn compile'
                // bat 'mvnw compile' for Windows agents
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
                // bat 'mvnw test' for Windows agents
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}
