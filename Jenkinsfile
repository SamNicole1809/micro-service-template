// image version
def tag = "latest"
def harbor_url = "192.168.8.153:15502"
def hanbor_project_name = "micro-service"
def harbor_authorization = "55f306ea-c84a-40e4-95e4-24c77d912101"

node {
    def list_select_project_names = "${project_name}".split(",")

    stage('pull code') {
        echo "${project_name}"
        echo list_select_project_names
        checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: 'd6de8504-48c7-402b-b727-4a42202a681d', url: 'git@192.168.8.151:root/micro-service-template.git']]])
    }

    stage('check code') {
        for(int i = 0; i < list_select_project_names.length; i++) {
            echo list_select_project_names[i]
            def infos = list_select_project_names[i].split("@")
            echo infos
            def project_name = infos[0]
            def project_port = infos[1]
            echo "${project_name}" - "${project_port}"
        }
    }

}