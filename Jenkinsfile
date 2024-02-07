pipeline {
    agent any

    options {
        skipStagesAfterUnstable()
    }

    environment {
        // Define environment variables if needed
    }

    stages {
        stage('Clean Workspace') {
            steps {
                cleanWs() // Cleans the workspace on Jenkins agent
            }
        }
        stage('Checkout SCM') {
            steps {
                git 'https://github.com/johnychhantyal2/se670-assignments.git'
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
                failure {
                    // Add steps to handle build failure if needed
                }
            }
        }
    }

    post {
        always {
            // Add steps to be executed after every run, such as cleanup or notifications
        }
        success {
            // Steps to execute on success
        }
        failure {
            // Steps to execute on failure
        }
        unstable {
            // Steps to execute if the build is marked as unstable
        }
        aborted {
            // Steps to execute if the build is aborted
        }
    }
}
