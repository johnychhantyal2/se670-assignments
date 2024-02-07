pipeline {
    agent any

    stages {
        stage('Clean Workspace') {
            steps {
                cleanWs() // Cleans the workspace on Jenkins agent
            }
        }
        stage('Checkout SCM') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/johnychhantyal2/se670-assignments.git'
            }
        }
        stage('Preparation') {
            steps {
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
