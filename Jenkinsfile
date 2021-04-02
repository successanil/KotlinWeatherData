pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh '''echo "openweather_data_api_key=aabb" >> local.properties
echo "sdk.dir=/home/relsell/Android/Sdk" >> local.properties'''
        sh './gradlew build'
      }
    }

  }
}