pipeline {
    agent any
    stages{

    stage('Test On Linux') {

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
}