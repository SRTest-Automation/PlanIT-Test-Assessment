pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    environment {
        DISPLAY = ":99"
    }

    stages {
        stage('Checkout') {
            steps { checkout scm }
        }

        stage('Build') {
            steps { sh 'mvn clean compile' }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                    archiveArtifacts artifacts: '**/target/surefire-reports/*.html', allowEmptyArchive: true
                }
            }
        }
    }

    post {
        success { echo "Pipeline completed successfully ✅" }
        failure { echo "Pipeline failed ❌" }
        always { cleanWs() }
    }
}
