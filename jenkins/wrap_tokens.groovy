    node{
        try {
            checkout scm
            
            rootDir = pwd()
            println "$rootDir"


            stage("MyStage1") {
                echo "Hello"
            }
            dir("ansible") {
                stage("Playbook") {
                    sh 'ansible-playbook -i inventory.ini put_tokens.yml -u ansible'
                }
            }

        } catch (e) {
            print(e)
            throw e
        } finally {
            cleanWs disableDeferredWipeout: true, deleteDirs: true
        }
    }
