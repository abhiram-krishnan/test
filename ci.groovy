node("trigger") {
    echo "This is to test CI"
    print env
    sh """
	echo "Printing all environment variables:"
        printenv
	echo "GIT_COMMIT=" $GIT_COMMIT
    """
}

