package cn.com.oniros.receiver.handlers;

import cn.com.oniros.clients.KimiClient;
import cn.com.oniros.config.WxRobotServerConfig;
import cn.com.oniros.constant.TextConstant;
import cn.com.oniros.entity.dto.KimiResponse;
import cn.com.oniros.entity.vo.SourceVO;
import cn.com.oniros.receiver.AbstractMessageHandler;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.receiver.handlers  CommonQuestionHandler
 * @date 2024/4/7 18:21
 */
@Service
public class CommonQuestionHandler extends AbstractMessageHandler {

    private static final int LEVEL = 4;

    @Resource
    KimiClient kimiClient;
    
    @Resource
    WxRobotServerConfig wxRobotServerConfig;


    @Override
    protected boolean parse(String content) {
        return true;
    }

    @Override
    protected int getLevel() {
        return LEVEL;
    }

    @Override
    protected String doHandle(String content, SourceVO sourceVO) {
        String question = content.replaceAll("@" + wxRobotServerConfig.getRobotName(), "");
        String from = sourceVO.getFrom().getPayload().getName();
        KimiResponse response = kimiClient.doKimiRequest(question);

        return String.format(TextConstant.QUESTION_RESPONSE, from, response.getChoices().get(0).getMessage().getContent());
    }

    @PostConstruct
    public void register() {
        super.register(LEVEL, this);
    }
}
