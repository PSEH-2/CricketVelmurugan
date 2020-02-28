pipeline {
    stages {
        stage('checkout') {
            steps {
                checkout scm
            }
        }
        stage('build') {
                    steps {
                        sh 'mvn clean -U deploy'
                    }
         }
    }
}