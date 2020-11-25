pipeline {
    agent 'k3s'
    stages {
        stage('Run Tests') {
            parallel {
                stage('Java 8 build') {
                    agent {
                        label "java-8"
                    }
                    steps {
                        sh "mvn clean install"
                    }
                    post {
                        always {
                            junit "**/TEST-*.xml"
                        }
                    }
                }
                stage('Java 14 build') {
                    agent {
                        label "java-14"
                    }
                    steps {
                        sh "mvn clean install"
                    }
                    post {
                        always {
                            junit "**/TEST-*.xml"
                        }
                    }
                }
            }
        }
    }
}
