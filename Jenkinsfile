pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Integration Tests') {
            steps {
                sh 'mvn verify'
            }
        }
        stage('Performance Tests') {
            steps {
                sh 'jmeter -n -t test.jmx -l results.jtl'
            }
            post {
                always {
                    publishPerformanceReport parsers: [[$class: 'JMeterParser', glob: 'results.jtl']]
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    sh 'docker build -t jenkins-rpg .'
                    sh 'docker run -d -p 8080:8080 jenkins-rpg'
                }
            }
        }
    }
    post {
        success {
            echo 'Déploiement réussi !'
        }
        failure {
            echo 'Le pipeline a échoué.'
        }
    }
}
