node("trigger") {
    echo "This is to test CI"
    sh """
	echo "Printing all environment variables:"
        printenv
    """
}

