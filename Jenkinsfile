pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git 'giturl'
                bat '.\\mvnw clean compile'
            }
        }
        stage('Test') {
            steps {
                bat '.\\mvnw test'
            }

            post {
                always {
                    junit '**/src/test/java/tests/NTU.java'
                }
            }
        }
    }
}