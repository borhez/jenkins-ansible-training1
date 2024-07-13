    node{
        try {
            checkout scm
            
            rootDir = pwd()
            println "$rootDir"


            stage("MyStage1") {
                echo "Hello"
            }

        } catch (e) {
            print(e)
            throw e
        } finally {
            cleanWs disableDeferredWipeout: true, deleteDirs: true
        }
    }
