FROM airhacks/glassfish
COPY ./target/jug_workshop.war ${DEPLOYMENT_DIR}
