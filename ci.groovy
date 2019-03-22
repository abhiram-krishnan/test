node("trigger") {
    echo "This is to test CI"
    sh """
	echo "Printing all environment variables:"
        printenv
	ls
	pwd
    """
    commitId = sh(returnStdout: true, script: 'git rev-parse HEAD')
    echo commitId
}

