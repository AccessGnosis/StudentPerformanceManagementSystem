FROM tomcat

ADD target/*.war /usr/local/tomcat/webapp

WORKDIR /usr/local/tomcat/webapp
