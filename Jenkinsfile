pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    checkout([
                        $class: 'GitSCM',
                        branches: [[name: 'MohamedaliKchaou-5ERPBI7-G1']],
                        userRemoteConfigs: [[url: 'https://github.com/ferjani-hejer/5ERP-BI7-G1-Projet2.git']]
                    ])
                }
            }
        }

        stage('Build') {
            steps {
                // Exécuter la construction Maven
                sh 'mvn clean install'
            }
        }

        stage('Unit Tests') {
            steps {
                // Exécuter les tests unitaires JUnit
                sh 'mvn test'
            }
        }

        stage('sonarQube') {
            steps {
                sh 'mvn sonar:sonar'
            }
        }

        stage('Deploy to Nexus') {
            steps {
                // Déployer l'artéfact sur Nexus Repository
                sh 'mvn deploy'
            }
        }
        
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    sh 'docker tag mohamedalikchaou-5bi-kaddem_app:latest kchaouu/mohamedalikchaou-5bi-kaddem_app:latest'
                    sh 'docker login -u kchaouu -p  medali123'
                    sh 'docker push kchaouu/mohamedalikchaou-5bi-kaddem_app'
                }
            }
        }

     




        stage('Docker Compose Up') {
            steps {
                script {
                    // Exécutez docker-compose up
                    sh "docker-compose up -d"
                }
            }
        }
    }

    post {
            failure {
                mail to: 'mohamedali.kchaou@esprit.tn',
                subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}console"
            }
            success {
                mail to: 'mohamedali.kchaou@esprit.tn',
                subject: "success Pipeline: ${currentBuild.fullDisplayName}",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}console"
            }
        }
}
