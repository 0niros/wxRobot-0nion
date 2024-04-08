FROM ubuntu/jre:17-22.04_41

ADD build /app
WORKDIR /app/build

CMD ["java -classpath /app/build:/app/build/lib --spring.config.location=/etc/wxbot/application.properties cn.com.oniros.WxRobotApplication"]
