node('k3s') {
    container('java-8') {
        if (env.CHANGE_BRANCH) {
            env.BRANCH_TO_BUILD = env.CHANGE_BRANCH
        } else {
            env.BRANCH_TO_BUILD = env.BRANCH_NAME
        }
        sh 'echo Building ${BRANCH_TO_BUILD}...'
        git branch: env.BRANCH_TO_BUILD, credentialsId: 'jenkins-github-token-letscodehu', url: 'https://github.com/letscodehu/szamla-agent'
        sh 'mvn clean install'
    }   
    container('java-14') {
        if (env.CHANGE_BRANCH) {
            env.BRANCH_TO_BUILD = env.CHANGE_BRANCH
        } else {
            env.BRANCH_TO_BUILD = env.BRANCH_NAME
        }
        sh 'echo Building ${BRANCH_TO_BUILD}...'
        git branch: env.BRANCH_TO_BUILD, credentialsId: 'jenkins-github-token-letscodehu', url: 'https://github.com/letscodehu/szamla-agent'
        sh 'mvn clean install'
    }   
}
