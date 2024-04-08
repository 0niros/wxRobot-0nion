package cn.com.oniros.clients;

import cn.com.oniros.config.WxRobotServerConfig;
import cn.com.oniros.constant.WxApiUrl;
import cn.com.oniros.entity.dto.CommonMessage;
import cn.com.oniros.entity.dto.SendMsgRequest;
import cn.com.oniros.entity.vo.TaskVO;
import cn.com.oniros.response.SendResponse;
import jakarta.annotation.Resource;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.clients  WxRobotClient
 * @date 2024/4/7 19:23
 */
@Component
public class WxRobotClient {

    @Resource
    WxRobotServerConfig serverConfig;

    public SendResponse<?> sendMessage(String type, String content, String to, Boolean isRoom) {
        String url = serverConfig.generateRequestUrl(WxApiUrl.SEND_MSG);
        SendMsgRequest request = new SendMsgRequest();
        request.setTo(to);
        request.setData(new CommonMessage(type, content));
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(url, request, SendResponse.class);
    }

}
