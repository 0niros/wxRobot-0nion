package cn.com.oniros.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.entity.po  GroupMessageRecord
 * @date 2024/4/7 18:15
 */
@TableName("msg_record")
@Data
public class MessageRecordPO {

    @TableId
    private Long id;

    private String roomId;

    private String roomName;

    private String personId;

    private String personName;

    private String type;

    private String contentOrUrl;

    private Long time;

}
