pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/johnychhantyal2/se670-assignments.git'
                sh 'mvn clean compile'
                // bat '.\\mvnw clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean test'
                // bat '.\\mvnw test'
            }

            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}