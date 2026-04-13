FROM tomcat:10.1.53-jre21-temurin-noble

ARG COMPILE_VERSION=1.0.0
ARG APPLICATION_CONTEXT=technical-test-webapp-jsp-essential

RUN apt-get update && \
    apt-get install -y vim && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* && \
    rm -rf /usr/local/tomcat/webapps/*

ENV LANG=es_MX.UTF-8
ENV LANGUAGE=es_MX:es
ENV TZ=America/Mexico_City

COPY /target/technical-test-webapp-jsp-essential-${COMPILE_VERSION}.war /usr/local/tomcat/webapps/${APPLICATION_CONTEXT}.war
COPY /docker/technical-test-webapp-jsp-essential.xml /usr/local/tomcat/conf/Catalina/localhost/${APPLICATION_CONTEXT}.xml

EXPOSE 8080

CMD ["catalina.sh", "run"]