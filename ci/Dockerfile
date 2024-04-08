FROM ubuntu/jre:17-22.04_41

ADD build /app
WORKDIR /app/build

CMD ["java -classpath /app/build:/app/build/lib cn.com.oniros.WxRobotApplication"]