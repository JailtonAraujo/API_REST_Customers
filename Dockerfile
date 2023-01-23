FROM openjdk:17

WORKDIR /usr/src/myapp

COPY ./target/customer.jar .

EXPOSE 8082

CMD [ "java", "-jar", "customer.jar" ]