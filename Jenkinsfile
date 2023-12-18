pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/klimd01/magrobota'
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