package cn.com.oniros.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.clients  WxRobotServerConfig
 * @date 2024/4/7 19:21
 */
@Configuration
@Data
public class WxRobotServerConfig {

    @Value("${wx.robot.address}")
    private String serverLocation;

    @Value("${wx.robot.token}")
    private String token;

    @Value("${wx.robot.name}")
    private String robotName;

    @Value("${wx.robot.nickname}")
    private String nickname;

    public String generateRequestUrl(String url) {
        return serverLocation + url + "?token=" + token;
    }

}
