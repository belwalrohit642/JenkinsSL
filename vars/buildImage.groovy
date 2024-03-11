#!/usr/bin/env groovy

def buildImage(String imageName) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t $imageName .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push  $imageName' 
    }
} 


