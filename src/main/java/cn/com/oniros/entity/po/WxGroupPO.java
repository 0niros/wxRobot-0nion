package cn.com.oniros.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.entity.po  WxGroupPO
 * @date 2024/4/7 17:09
 */
@TableName("wx_group")
@Data
public class WxGroupPO {

    @TableId
    private String id;

    private String roomName;

}
