FROM registry.access.redhat.com/ubi8/openjdk-11

LABEL maintainer="Debezium Community"
ENV DEBEZIUM_VERSION=1.9.6.Final SERVER_HOME=/debezium MAVEN_REPO_CENTRAL=https://repo1.maven.org/maven2
ENV SERVER_URL_PATH=io/debezium/debezium-server-dist/1.9.6.Final/debezium-server-dist-1.9.6.Final.tar.gz SERVER_MD5=d078740140b1a3a92f52b392bc660a58
USER root
RUN microdnf -y install gzip  \
	&& microdnf clean all  \
	&& mkdir $SERVER_HOME  \
	&& chmod 755 $SERVER_HOME # buildkit
RUN chown -R jboss $SERVER_HOME  \
	&& chgrp -R jboss $SERVER_HOME # buildkit
USER jboss
RUN mkdir $SERVER_HOME/conf  \
	&& mkdir $SERVER_HOME/data # buildkit
RUN curl -fSL -o /tmp/debezium.tar.gz "$MAVEN_REPO_CENTRAL/$SERVER_URL_PATH" # buildkit
RUN echo "$SERVER_MD5 /tmp/debezium.tar.gz" | md5sum -c -  \
	&& tar xzf /tmp/debezium.tar.gz -C $SERVER_HOME --strip-components 1  \
	&& rm -f /tmp/debezium.tar.gz # buildkit
RUN chmod -R g+w,o+w $SERVER_HOME # buildkit
WORKDIR /debezium
EXPOSE 8080
VOLUME [/debezium/conf /debezium/data]
CMD ["/debezium/run.sh"]
