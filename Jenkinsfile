pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'echo "openweather_data_api_key=aabb" >> local.properties'
        sh './gradlew build'
      }
    }

  }
}