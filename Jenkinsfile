// image version
def tag = "latest"
def harbor_url = "192.168.8.153:15502"
def harbor_project_name = "micro-service"
def harbor_authorization = "55f306ea-c84a-40e4-95e4-24c77d912101"

node {
    def list_select_project_names = "${project_name}".split(",")

    stage('pull code') {
        checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: 'd6de8504-48c7-402b-b727-4a42202a681d', url: 'git@192.168.8.151:root/micro-service-template.git']]])
    }

    stage('check code') {
        for(int i = 0; i < list_select_project_names.length; i++) {
            def infos = list_select_project_names[i].split("@")
            def project_name = infos[0]
            echo "${project_name}"
            def project_port = infos[1]
            echo "${project_port}"
        }
    }

    stage('install common environment') {
        sh "mvn -f micro-dependencies clean install"
        sh "mvn -f micro-common clean install"
        sh "mvn -f micro-feign-api clean install"
    }

    stage('build images') {
        for(int i = 0; i < list_select_project_names.length; i++) {
            def infos = list_select_project_names[i].split("@")
            def project_name = infos[0]
            def project_port = infos[1]
            sh "mvn -f ${project_name} clean package dockerfile:build"
            def image_name = "${project_name}:${tag}"
            sh "docker tag ${image_name} ${harbor_url}/${harbor_project_name}/${image_name}"
        }
    }

}