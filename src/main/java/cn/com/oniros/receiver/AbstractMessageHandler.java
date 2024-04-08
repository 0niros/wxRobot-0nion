package cn.com.oniros.receiver;

import cn.com.oniros.constant.TextConstant;
import cn.com.oniros.entity.vo.SourceVO;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.receiver  AbstractMessageHandler
 * @date 2024/4/7 17:52
 */
public abstract class AbstractMessageHandler {

    public static Map<Integer, AbstractMessageHandler> handlers = new HashMap<>();

    protected abstract boolean parse(String content);

    protected abstract int getLevel();

    protected abstract String doHandle(String content, SourceVO sourceVO);

    protected void register(int level, AbstractMessageHandler handler) {
        handlers.put(level, handler);
    }

    public String handle(String content, SourceVO sourceVO) {
        if (parse(content)) {
            return doHandle(content, sourceVO);
        }
        int level = getLevel();
        AbstractMessageHandler nextHandler = handlers.get(level + 1);
        if (nextHandler == null) {
            return String.format(TextConstant.NO_HANDLER, sourceVO.getFrom().getPayload().getName(), content);
        }

        return nextHandler.handle(content, sourceVO);
    }

    public static AbstractMessageHandler getHandler() {
        return handlers.get(1);
    }

}
