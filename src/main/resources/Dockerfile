FROM java:8
#spring-boot-docker-0.0.1-SNAPSHOT.jar 请确认构建的jar包名称
ADD spring-boot-docker.jar app.jar
RUN bash -c 'touch /app.jar'
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENTRYPOINT ["java","-jar","/app.jar"]