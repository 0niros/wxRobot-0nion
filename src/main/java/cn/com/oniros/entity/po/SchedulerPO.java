package cn.com.oniros.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.entity.po  SchedulerPO
 * @date 2024/4/7 18:26
 */
@TableName("scheduler")
@Data
public class SchedulerPO {

    @TableId
    private Long id;

    private String roomId;

    private Integer method;

    private String extendInfo;

}
