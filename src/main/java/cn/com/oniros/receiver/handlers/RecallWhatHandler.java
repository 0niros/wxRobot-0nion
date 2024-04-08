package cn.com.oniros.receiver.handlers;

import cn.com.oniros.constant.TextConstant;
import cn.com.oniros.entity.po.MessageRecordPO;
import cn.com.oniros.entity.vo.SourceVO;
import cn.com.oniros.receiver.AbstractMessageHandler;
import cn.com.oniros.service.IMessageRecordService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.receiver.handlers  RecallWhat
 * @date 2024/4/7 18:16
 */
@Service
public class RecallWhatHandler extends AbstractMessageHandler {

    @Resource
    IMessageRecordService recordService;

    private static final int LEVEL = 2;

    @Override
    protected boolean parse(String content) {
        return content.contains(TextConstant.RECALL_METHOD);
    }

    @Override
    protected int getLevel() {
        return LEVEL;
    }

    @Override
    protected String doHandle(String content, SourceVO sourceVO) {
        StringBuilder contentBuilder = new StringBuilder();
        if (sourceVO.getRoom() == null || sourceVO.getRoom().getPayload() == null ) {
            return TextConstant.NOT_IN_ROOM;
        }

        List<MessageRecordPO> messageByRoom = recordService.getMessageByRoom(sourceVO.getRoom().getPayload().getTopic());
        for (MessageRecordPO msg : messageByRoom) {
            String formatted = String.format(TextConstant.SAY, msg.getPersonName(), msg.getContentOrUrl());
            contentBuilder.append(formatted);
        }

        return contentBuilder.toString();
    }

    @PostConstruct
    public void register() {
        super.register(LEVEL, this);
    }
}
