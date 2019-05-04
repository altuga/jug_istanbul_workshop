# Build
mvn clean package && docker build -t com.airhacks/jug_workshop .

# RUN

docker rm -f jug_workshop || true && docker run -d -p 8080:8080 -p 4848:4848 --name jug_workshop com.airhacks/jug_workshop 

# http://www.cs.sjsu.edu/faculty/pearce/modules/lectures/ooa/analysis/ecb.htm

#curl -H "Content-Type:application/json" -d '{"name":"jug"}' -X POST http://localhost:8080/jug_workshop/resources/ping {"id":1,"name":"jug"}%