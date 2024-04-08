package cn.com.oniros.receiver.handlers;

import cn.com.oniros.constant.TextConstant;
import cn.com.oniros.entity.vo.SourceVO;
import cn.com.oniros.receiver.AbstractMessageHandler;
import cn.com.oniros.service.IWxGroupService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.receiver.handlers  AddNewGroupHandler
 * @date 2024/4/7 17:58
 */
@Service
@Slf4j
public class AddNewGroupHandler extends AbstractMessageHandler {

    private static final int LEVEL = 1;

    @Resource
    IWxGroupService wxGroupService;

    @Override
    protected boolean parse(String content) {
        return content.contains(TextConstant.CALL_ONION);
    }

    @Override
    protected int getLevel() {
        return LEVEL;
    }

    @Override
    protected String doHandle(String content, SourceVO sourceVO) {
        log.info(sourceVO.toString());
        if (sourceVO.getRoom() == null || sourceVO.getRoom().getPayload() == null || sourceVO.getRoom().getPayload().getTopic() == null || sourceVO.getRoom().getPayload().getTopic().isBlank()) {
            return TextConstant.NOT_IN_ROOM;
        }
        wxGroupService.addGroup(sourceVO.getRoom().getId(), sourceVO.getRoom().getPayload().getTopic());

        return TextConstant.CALL_SUCCESS;
    }

    @PostConstruct
    public void register() {
        super.register(LEVEL, this);
    }

}
