#!/bin/sh

java -XX:+UseG1GC -Xmx512m -Xms512m -classpath /app/*:/app/lib/* cn.com.oniros.WxRobotApplication --spring.config.location=/etc/wxbot/application.properties