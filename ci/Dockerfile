FROM ubuntu:22.04

RUN apt-get update && apt-get install -y openjdk-17-jre

ADD build /app
WORKDIR /app

CMD ["sh", "/app/startup.sh"]
