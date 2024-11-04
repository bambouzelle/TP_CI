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
                sh 'jmeter -n -t /path/to/performance_test.jmx -l /path/to/results.jtl'
            }
            post {
                always {
                    publishPerformanceReport parsers: [[$class: 'JMeterParser', glob: 'path/to/results.jtl']]
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    sh 'docker build -t my-rpg-app .'
                    sh 'docker run -d -p 8080:8080 my-rpg-app'
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
