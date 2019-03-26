pipeline {
    agent { label 'trigger' }
    stages {
        stage ('Init') {
            steps {
                echo "Init result: ${currentBuild.result}"
                echo "Init currentResult: ${currentBuild.currentResult}"
            }
            post {
                always {
                    echo "Post-Init result: ${currentBuild.result}"
                    echo "Post-Init currentResult: ${currentBuild.currentResult}"
                }
            }
        }
        stage ('Build') {
            steps {
                echo "During Build result: ${currentBuild.result}"
                echo "During Build currentResult: ${currentBuild.currentResult}"
                sh 'exit 1'
            }
            post {
                always {
                    echo "Post-Build result: ${currentBuild.result}"
                    echo "Post-Build currentResult: ${currentBuild.currentResult}"
                }
            }
        }
    }
    post {
        always {
            echo "Pipeline result: ${currentBuild.result}"
            echo "Pipeline currentResult: ${currentBuild.currentResult}"
        }
    }
    //commitId = sh(returnStdout: true, script: 'git rev-parse HEAD')
    //echo commitId
}

