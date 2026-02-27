#!/user/bin/env groovy

def call(){
    echo "building the application... in branch $BRANCH_NAME"
    sh 'mvn package'
}
