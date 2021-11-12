# Spring boot server port 
* 8090
# Url after swagger
* http://localhost:8090/swagger-ui.html#
# Dockerizing
* Add appName to pom:
```
 <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
        <finalName><app-name></finalName>
    </build>
```
* `mvn clean install`
* Create image : ` docker build -f Dockerfile -t <app-name>:<app-version> .`
    * * ` docker build -f Dockerfile -t hhssaaffii/tech-search:2 .` 
* Check image is correct before deploy to kubernetes by build container: `docker run -p <port-for-docker>:<port-for-spring> <app-name>`
* stop container :`docker container stop $(docker container ls -aq)`

# Push Created Image to remote docker hub
* Login to remote docker: `docker login`
* Create remote tag image for app: ` docker image tag <app-name>:<app-version> <remote-repo-name>/<app-name>:<app-version>` 
    * * example: ` docker image tag tech-search:1 hhssaaffii/tech-search:1` 
* See the image created locally: `docker image ls` 

* Push to remote: `docker push <remote-repository-name>/tech-search:1` 
    * * for example: `docker push hhssaaffii/tech-search:1`
 
# Pull the image in server
*  `docker pull hhssaaffii/tech-search:2`

# deploy with helm
* change tag in `values.yaml` helm chart
*  Go to app directory `helm install <app-nam,tech-search> .`
 
 
* Jenkins is in main directory directory
* `cd jenkins/workspace` is workspace 
* Take a backup from jenkins:
`tar -czf jenkins_home_end_m4.tgz .jenkins/`
