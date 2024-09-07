pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Unit Test') {
            steps {
                sh 'mvn test'
            }
            post {
                 always {
                    junit 'target/surefire-reports/*.xml'
                 }
            }
        }
        stage('Deploy Step') {
            steps {
                sh 'scp Selenium_NG-1.0-SNAPSHOT.jar - REMOTE_HOST'
                sh 'ssh REMOTE_HOST'
                sh 'java -v Selenium_NG-1.0-SNAPSHOT.jar'
            }
            post {
                 always {
                    junit 'target/surefire-reports/*.xml'
                 }
            }
        }
        stage('UI TEST') {
            steps {
                sh 'RUN SELENIUM TEST on beta.concert.aws.a2z.com'
            }
            post {
                 always {
                    junit 'target/surefire-reports/*.xml'
                 }
            }
        }
        stage('Deploy to PROD') {
                    steps {
                        sh 'scp Selenium_NG-1.0-SNAPSHOT.jar - REMOTE_HOST'
                        sh 'ssh REMOTE_HOST'
                        sh 'java -v Selenium_NG-1.0-SNAPSHOT.jar'
                    }
                    post {
                         always {
                            junit 'target/surefire-reports/*.xml'
                         }
                    }
                }

    }
}