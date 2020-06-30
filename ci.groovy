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
	    echo "The change URL = "
	    echo "${env.CHANGE_URL}"
            def change_url = env.CHANGE_URL
	    project = change_url.tokenize('/')[3]
	    repo = change_url.tokenize('/')[4]
            echo "Project name = ${project}"
	    echo "Repo name = ${repo}"
            echo project
	    echo repo
            echo "Pipeline result: ${currentBuild.result}"
            echo "Pipeline currentResult: ${currentBuild.currentResult}"
    }
}
