package cn.com.oniros.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.entity.vo  RoomPayload
 * @date 2024/4/7 23:41
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomPayload {

    private String topic;

}
