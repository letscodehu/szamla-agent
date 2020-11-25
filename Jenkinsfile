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
                        if (env.CHANGE_BRANCH) {
                            env.BRANCH_TO_BUILD = env.CHANGE_BRANCH
                        } else {
                            env.BRANCH_TO_BUILD = env.BRANCH_NAME
                        }
                        sh 'echo Building ${BRANCH_TO_BUILD}...'
                        git branch: env.BRANCH_TO_BUILD, credentialsId: 'jenkins-github-token-letscodehu', url: 'https://github.com/letscodehu/szamla-agent'
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
                        if (env.CHANGE_BRANCH) {
                            env.BRANCH_TO_BUILD = env.CHANGE_BRANCH
                        } else {
                            env.BRANCH_TO_BUILD = env.BRANCH_NAME
                        }
                        sh 'echo Building ${BRANCH_TO_BUILD}...'
                        git branch: env.BRANCH_TO_BUILD, credentialsId: 'jenkins-github-token-letscodehu', url: 'https://github.com/letscodehu/szamla-agent'
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
