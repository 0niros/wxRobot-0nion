package cn.com.oniros.service.impl;

import cn.com.oniros.constant.TextConstant;
import cn.com.oniros.entity.vo.CommonMessageResponseVO;
import cn.com.oniros.entity.vo.SourceVO;
import cn.com.oniros.receiver.AbstractMessageHandler;
import cn.com.oniros.response.CommonResponse;
import cn.com.oniros.service.IMessageReceiver;
import cn.com.oniros.service.IMessageRecordService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.service.impl  MessageReceiverImpl
 * @date 2024/4/7 17:51
 */
@Service
@Slf4j
public class MessageReceiverImpl implements IMessageReceiver {

    @Resource
    private IMessageRecordService messageRecordService;

    @Override
    public CommonResponse<CommonMessageResponseVO> doHandleMessage(String type, byte[] content, SourceVO source,
                                                                   String isMentioned, String isSelfMessage) {
        // 0. Deal with type.
        if ("text".equals(type) || "urlLink".equals(type)) {
            // 1. Add message.
            String contentStr = new String(content, StandardCharsets.UTF_8);
            messageRecordService.addMessage(contentStr, source, type);

            // 2. Handle message via handler chain.
            AbstractMessageHandler handler = AbstractMessageHandler.getHandler();
            if ("1".equals(isMentioned) && "0".equals(isSelfMessage)) {
                String handledResponse = handler.handle(contentStr, source);
                return new CommonResponse<>(true, new CommonMessageResponseVO("text", handledResponse));
            }
        } else {
            // 0.2 Case not supported, add message only.
            if (source.getFrom() == null || source.getFrom().getPayload() == null) {
                return new CommonResponse<>(true, null);
            }
            messageRecordService.addMessage(content, source, type);
        }

        return new CommonResponse<>(true, new CommonMessageResponseVO("text", ""));
    }
}
