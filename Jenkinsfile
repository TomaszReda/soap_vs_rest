pipeline {

    agent any
    stages {
        stage('Cloning our Git') {
            steps {
                git 'https://github.com/TomaszReda/soap_vs_rest'
            }
        }
        stage('Build application') {
            steps {
                sh './gradlew clean bootJar'
            }
        }
        stage('Delete old version compose') {
             steps {
                sh 'docker-compose down'
             }
        }
        stage('Build docker') {
             steps {
                sh 'docker-compose build'
             }
        }
        stage('Deploy to staging') {
             steps {
                sh 'docker-compose up -d'
             }
        }
    }
}