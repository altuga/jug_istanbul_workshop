FROM airhacks/payara5
COPY ./target/jug_workshop.war ${DEPLOYMENT_DIR}
