// timeout(time: 2, unit: 'HOURS') {
    node{
        try {
            checkout scm
            
            rootDir = pwd()
            println $rootDir
//             ansibleTool = tool name: 'ansible29-py3', type: 'org.jenkinsci.plugins.ansible.AnsibleInstallation'

// // --- V4 PROPERTIES BLOCK START
//             ENV = readYaml file: "${rootDir}/jenkins_v4/configs/env/env.yml"
//             clusterChoicer = load "${rootDir}/jenkins_v4/configs/env/env.groovy"

//             properties([
//                 parameters([
//                     clusterChoicer.stand_choicer(ENV),
//                     clusterChoicer.dev_choicer(ENV),
//                     clusterChoicer.ift_choicer(ENV),
//                     clusterChoicer.auto_test_choicer(ENV),
//                     clusterChoicer.psi_choicer(ENV),
//                     clusterChoicer.rdt_choicer(ENV),
//                     clusterChoicer.prod_choicer(ENV),
//                     string(name: 'LIMIT', trim: true, defaultValue: 'all', description: 'Limit by group or hostname'),
//                     // string(name: 'BB_SBRF_BRANCH', defaultValue: '*/dev', description: 'Бранч для ansible скриптов. Пример "*/feature/OS4"'),
//                     choice(
//                         name: 'MODULE',
//                         choices: [
//                             'appapi',
//                             'metrics',
//                             'core',
//                             'gpbackup',
//                             'pxf'
//                         ]
//                     ),
//                     choice(
//                         name: 'ANSIBLE_USER',
//                         choices: [
//                             'LOCAL_USER',
//                             'IPA_DEVOPS_USER'
//                         ]
//                     )
//                 ])
//             ])

//             CLUSTER = clusterChoicer.get_CLUSTER(params.STAND, params.DEV, params.IFT, params.AUTO_TEST, params.PSI, params.RDT, params.PROD)
//             INVENTORY = "${rootDir}/ansible_v4/inventory/${CLUSTER}"
//             load "${rootDir}/jenkins_v4/configs/vault/secman.${params.STAND}.groovy"
//             def ansibleModule = load "${rootDir}/jenkins_v4/configs/ansible/ansible.groovy"
//             println("Path: secman.${params.STAND}.groovy")
//             println("Cluster: ${CLUSTER}")
//             println("Inventory path: ${INVENTORY}")

//             currentBuild.displayName = "${STAND}:${CLUSTER}"
// // --- V4 PROPERTIES BLOCK END

            // timestamps {
                // stage("Pre-check") {
                //     // println("Check if git available")
                //     // try {
                //     //     secret = SECMAN.bitbucket_devops['secret']
                //     //     withVaultCredential(configuration: SECMAN.bitbucket_devops.config, vaultSecrets: [secret]) {
                //     //         checkout(
                //     //             [
                //     //                 $class: 'GitSCM',
                //     //                 branches: [[name: "${params.BB_SBRF_BRANCH}"]],
                //     //                 doGenerateSubmoduleConfigurations: false,
                //     //                 extensions: [[$class: 'CloneOption', depth: 1, noTags: false, reference: '', shallow: true]],
                //     //                 submoduleCfg: [],
                //     //                 userRemoteConfigs: [
                //     //                     [credentialsId: secret.credentialsId, url: GIT_URL]
                //     //                 ]
                //     //             ]
                //     //         )
                //     //     }
                //     // }
                //     // catch (e) {
                //     //     error "Git FAILURE: " + e
                //     // }

                //     println("Check if stand available")
                //     dir('ansible_v4') {
                //         ansibleModule.call('PING', INVENTORY, ANSIBLE_USER)
                //     }
                // }

                // dir('ansible_v4') {
                //     inventoryYAML = null
                //     inventoryYAML = readYaml file: "${INVENTORY}/01_hosts.yml"

                //     hostnames = get_hostnames(inventoryYAML)
                //     def vault_path = "${INVENTORY}/vault.groovy"
                //     if (!fileExists(vault_path)) {
                //         error 'This environment does not have a vault.groovy file'
                //     }
                //     load vault_path
                // }

                // Map hosttoken = [:]
                // Map catoken = [:]
                // stage("Get wrap tokens") {
                //     switch(params.MODULE) {
                //         case "appapi":
                //             wrap_secman = appapi
                //             break
                //         case "metrics":
                //             wrap_secman = metrics
                //             break
                //         case "core":
                //             wrap_secman = core
                //             break
                //         case "gpbackup":
                //             wrap_secman = gpbackup
                //             break
                //         case "pxf":
                //             wrap_secman = pxf
                //             break
                //     }
                //     println(wrap_secman)
                //     hosttoken = get_token_from_hosts(hostnames, "wrap", wrap_secman.config, wrap_secman.secrets)
                // }
                // stage("Get CA token") {
                //     catoken = get_token_from_hosts(hostnames, "ca", sberca.config, sberca.secrets)
                // }
                // secret = SECMAN.ansible_vault['secret']
                // withVault([configuration: SECMAN.ansible_vault.config, vaultSecrets: [secret]]) {
                //     stage("Configure cluster") {
                //         dir('ansible_v4') {
                //             hosttokenJson = writeJSON returnText: true, json: JsonOutput.toJson(hosttoken)
                //             catokenJson = writeJSON returnText: true, json: JsonOutput.toJson(catoken)
                //             wrap([$class: "MaskPasswordsBuildWrapper", varPasswordPairs: [[password: hosttokenJson], [password: catokenJson]]]) {
                //                 def extra = """--extra-vars='{"hosttokens": $hosttokenJson}' --extra-vars='{"catokens": $catokenJson}'"""
                //                 // Install wrap token to host
                //                 ansibleModule.call('PLAYBOOK', INVENTORY, ANSIBLE_USER, "wrapped_token_${params.MODULE.toLowerCase()}.yml", 'all', params.LIMIT, extra)
                //             }
                //         }
                //     }
                // }





                stage("MyStage1") {
                    echo "Hello"
                }
            // }
        } catch (e) {
            print(e)
            throw e
        } finally {
            cleanWs disableDeferredWipeout: true, deleteDirs: true
        }
    }
// }
