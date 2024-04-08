package cn.com.oniros.receiver.handlers;

import cn.com.oniros.constant.TextConstant;
import cn.com.oniros.entity.vo.SourceVO;
import cn.com.oniros.receiver.AbstractMessageHandler;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.receiver.handlers  ActiveWhetherHandler
 * @date 2024/4/7 18:18
 */
@Service
public class ActiveWhetherHandler extends AbstractMessageHandler {

    private static final int LEVEL = 3;

    @Override
    protected boolean parse(String content) {
        return content.contains(TextConstant.ACTIVE_METHOD) && content.contains(TextConstant.ACTIVE_WHETHER);
    }

    @Override
    protected int getLevel() {
        return LEVEL;
    }

    @Override
    protected String doHandle(String content, SourceVO sourceVO) {
        return null;
    }

    @PostConstruct
    public void register() {
        super.register(LEVEL, this);
    }
}
