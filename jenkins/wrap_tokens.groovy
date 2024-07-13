    node{
        try {
            // checkout scm
            
            rootDir = pwd()
            println "$rootDir"


            stage("MyStage1") {
                echo "Hello"
            }
            dir("ansible") {
                stage("Playbook") {
                // ansibleTool = tool name: 'ansible29-py3', type: 'org.jenkinsci.plugins.ansible.AnsibleInstallation'
                // "${ansibleTool}/ansible-playbook -v -i ${ANSIBLE_INVENTORY} --limit ${LIMIT} --ask-vault-pass ${PLAYBOOK} --tags ${TAGS} ${EXTRA}"
                    sh 'ls -lah'
                    // sh 'ansible -i inventory.ini master -u ansible -m shell -a "echo HELLO! > test.txt" '
                }
            }

        } catch (e) {
            print(e)
            throw e
        } finally {
            cleanWs disableDeferredWipeout: true, deleteDirs: true
        }
    }
