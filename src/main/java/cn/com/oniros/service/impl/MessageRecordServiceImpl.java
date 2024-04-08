package cn.com.oniros.service.impl;

import cn.com.oniros.constant.TextConstant;
import cn.com.oniros.dao.IMessageRecordDao;
import cn.com.oniros.entity.po.MessageRecordPO;
import cn.com.oniros.entity.vo.SourceVO;
import cn.com.oniros.service.IMessageRecordService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.service.impl  MessageRecordServiceImpl
 * @date 2024/4/7 18:33
 */
@Service
@Slf4j
public class MessageRecordServiceImpl implements IMessageRecordService {

    @Resource
    private IMessageRecordDao messageRecordDao;

    @Override
    public void addMessage(String content, SourceVO source, String type) {
        MessageRecordPO messageRecord = new MessageRecordPO();
        messageRecord.setType(type);
        messageRecord.setContentOrUrl(content);
        if (source.getRoom() != null && source.getRoom().getPayload() != null) {
            messageRecord.setRoomId(source.getRoom().getId());
            messageRecord.setRoomName(source.getRoom().getPayload().getTopic());
        }
        messageRecord.setPersonId(source.getFrom().getPayload().getId());
        messageRecord.setPersonName(source.getFrom().getPayload().getName());
        messageRecord.setTime(System.currentTimeMillis());

        messageRecordDao.insert(messageRecord);
    }

    @Override
    public void addMessage(byte[] content, SourceVO source, String type) {
        addMessage(TextConstant.UNKNOWN_FILE, source, type);
    }

    @Override
    public List<MessageRecordPO> getMessageByRoom(String room) {
        QueryWrapper<MessageRecordPO> wrapper = new QueryWrapper<>();
        wrapper.eq("room_name", room);
        wrapper.orderByDesc("time");
        Page<MessageRecordPO> page = new Page<>(1, 10);

        Page<MessageRecordPO> pageQueried = messageRecordDao.selectPage(page, wrapper);

        return pageQueried.getRecords();
    }

    @Scheduled(fixedRate = 2 * 1000 * 60 * 60 * 24)
    public void cleanupRecord() {
        Long cleanupTime = System.currentTimeMillis() - 2 * 1000 * 60 * 60 * 24;
        QueryWrapper<MessageRecordPO> wrapper = new QueryWrapper<>();
        wrapper.le("time", cleanupTime);

        messageRecordDao.delete(wrapper);
    }

}
