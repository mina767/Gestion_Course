pipeline {
    agent any

    environment {
        DOCKER_IMAGE = ' aminakh89/gestionpan:latest'
        DOCKER_USERNAME = 'aminakh89'
        DOCKER_PASSWORD = 'Mimina1234'
    }

    stages {
        stage('Build') {
            steps {
                script {
                    echo 'Initiating build process...'
                    bat 'mvn clean package'
                }
            }
        }
        stage('Unit Tests') {
            steps {
                script {
                    echo 'Executing unit tests...'
                    bat 'mvn test'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    echo 'Constructing Docker image...'
                    bat "docker build -t %DOCKER_IMAGE% ."
                }
            }
        }
        stage('Push Docker Image to DockerHub') {
            steps {
                script {
                    echo 'Authenticating with DockerHub...'
                    bat "docker login -u %DOCKER_USERNAME% -p %DOCKER_PASSWORD%"
                    echo 'Uploading Docker image to DockerHub...'
                    bat "docker push %DOCKER_IMAGE%"
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline executed successfully, all steps completed.'
        }
        failure {
            echo 'Pipeline execution failed. Please check the logs for errors.'
        }
    }

