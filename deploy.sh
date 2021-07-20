#! /bin/sh
harbor_url = $1
harbor_project_name = $2
project_name = $3
project_port = $4
tag = $5

image_name = $harbor_url/$harbor_project_name/$project_name
tag_name = $image_name:$tag

containerId = `docker ps -a | grep -w ${image_name} | awk '{print $1}'`
if [ "$containerId" != "" ]; then
    docker stop $containerId
    docker rm $containerId
fi
imageId = `docker images | grep -w ${image_name} | awk '{print $3}'`
if [ "$imageId" != "" ]; then
    docker rmi $imageId
fi
docker login -u sam -p Sam123456 $harbor_url
docker pull $tag_name
docker run -d --restart=always -p $project_port:$project_port $tag_name
