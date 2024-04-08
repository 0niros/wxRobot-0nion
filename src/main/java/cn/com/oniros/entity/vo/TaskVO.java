package cn.com.oniros.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.entity.vo  TaskVO
 * @date 2024/4/7 19:28
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskVO {

    private Integer successCount;

    private Integer totalCount;

    private Integer failedCount;

}
