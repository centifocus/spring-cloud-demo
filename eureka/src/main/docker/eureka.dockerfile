
# FROM <image>:<tag>
# FROM指令必须指定且需要在Dockerfile其他指令的前面，指定的基础image可以是官方远程仓库中的，也可以位于本地仓库。
# 当在同一个Dockerfile中建立多个镜像时，可以使用多个FROM指令。
FROM frolvlad/alpine-oraclejdk8:slim
# VOLUME ["/dir"]
# 使容器中的一个目录具有持久化存储数据的功能，该目录可以被容器本身使用，也可以共享给其他容器。
VOLUME /tmp
# 从src复制文件到容器的dest。src是Dockerfile所在目录的相对路径
ADD eureka-0.0.1-SNAPSHOT.jar eureka.jar
# 指定Docker容器启动时执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka.jar"]
# 为Docker容器设置对外的端口号
EXPOSE 9901

# 安装docker
# https://docs.docker.com/engine/installation/linux/docker-ce/centos/






