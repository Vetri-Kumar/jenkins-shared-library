#!/user/bin/env groovy

def call(){
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-id', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t vetri18/not-public:jma-9.9.9 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push vetri18/not-public:jma-9.9.9'
    }
}