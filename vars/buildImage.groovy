#!/usr/bin/env groovy

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t belwalrohit642/demo-app:2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push  belwalrohit642/demo-app:2.0' 
    }
} 


