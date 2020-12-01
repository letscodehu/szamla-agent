pipeline {
    agent {
      kubernetes {
        cloud 'kubernetes'
        inheritFrom 'builder'
      }
    }
    stages {
        stage('Build for branch'){
            when { expression { env.CHANGE_ID == null } }

             steps {
               container('java-8')
            {
                git branch: env.BRANCH_NAME ?: 'feature/pipeline', credentialsId: 'jenkins-github-token-letscodehu', url: 'https://github.com/letscodehu/szamla-agent'
                sh 'mvn clean install'
            }
            }
           
        }
        stage('Build for PR') {
             when {
                allOf {
                    expression { env.CHANGE_ID != null }
                    expression { env.CHANGE_TARGET != null }
                }
            }
           
            steps {
                 container('java-8')
                {
                echo "Building PR #${env.CHANGE_ID}"
                git branch: env.CHANGE_BRANCH, credentialsId: 'jenkins-github-token-letscodehu', url: 'https://github.com/letscodehu/szamla-agent'
                sh 'mvn clean install'
                }
            }
            
        }
        stage('Release to maven') {
            when {
                branch 'master'
            }
            environment {
                GPG_PASSWORD = credentials('gpg-password-to-oss-sonatype')
            }
             input {
               message "Should we release to maven?"
               parameters {
                     string(name: 'VERSION', defaultValue: '0.3.0', description: 'What version should we release?')
                }
            }
            steps {
                 container('java-8')
                {
                git branch: 'master', credentialsId: 'jenkins-github-token-letscodehu', url: 'https://github.com/letscodehu/szamla-agent'
                sh 'echo "Releasing ${VERSION}"'
                sh '''
                    gpg --import /secrets/public.key
                    gpg --import --batch --no-tty --yes /secrets/private.key
                    mvn versions:set -DnewVersion=${VERSION}
                    mvn clean package gpg:sign deploy -Prelease -Dgpg.passphrase=${GPG_PASSWORD} --settings /maven/settings.xml
                '''
                }
            }
        }
    }
}
