pipeline {
    agent none
    stage('Test On Linux') {
                        agent {
                            label "mac"
                        }
                        steps {
                            sh "mvn test"
                        }
                        post {
                            always {
                                junit '**/target/surefire-reports/TEST-*.xml'
                                archive 'target/*.jar'
                            }
                        }
      }
}