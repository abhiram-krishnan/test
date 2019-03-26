node("trigger"){
        try {
        stage ('Init') {
            try {
                echo "Init result: ${currentBuild.result}"
                echo "Init currentResult: ${currentBuild.currentResult}"
            }
            finally {
                    echo "Post-Init result: ${currentBuild.result}"
                    echo "Post-Init currentResult: ${currentBuild.currentResult}"
            }
        }
        stage ('Build') {
            try {
                echo "During Build result: ${currentBuild.result}"
                echo "During Build currentResult: ${currentBuild.currentResult}"
                sh 'exit 1'
            }
            finally {
                    echo "Post-Build result: ${currentBuild.result}"
                    echo "Post-Build currentResult: ${currentBuild.currentResult}"
            }
        }
    }
    
    finally {
            withCredentials([usernamePassword(credentialsId: '55b3fdf1-d87f-41b0-87e9-5d7e14517498', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            sh '''
            if [ "${USERNAME}" = "abhiram-krishnan" ]; then
                echo "It's my account"
	    fi
            echo "Username = " 
	    echo "${USERNAME}"
            echo "Password = " 
            echo "${PASSWORD}"
            '''
            echo "Pipeline result: ${currentBuild.result}"
            echo "Pipeline currentResult: ${currentBuild.currentResult}"
       }
    }
    //commitId = sh(returnStdout: true, script: 'git rev-parse HEAD')
    //echo commitId
}
