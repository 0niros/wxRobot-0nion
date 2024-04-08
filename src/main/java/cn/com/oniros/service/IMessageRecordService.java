package cn.com.oniros.service;

import cn.com.oniros.entity.po.MessageRecordPO;
import cn.com.oniros.entity.vo.SourceVO;

import java.util.List;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.service  IMessageRecordService
 * @date 2024/4/7 18:30
 */
public interface IMessageRecordService {

    void addMessage(String content, SourceVO source, String type);

    void addMessage(byte[] content, SourceVO source, String type);

    List<MessageRecordPO> getMessageByRoom(String room);

}
