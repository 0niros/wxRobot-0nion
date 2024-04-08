package cn.com.oniros.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.entity.vo  RoomMessageVO
 * @date 2024/4/7 17:35
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomMessageVO {

    private String id;

    private RoomPayload payload;

}
