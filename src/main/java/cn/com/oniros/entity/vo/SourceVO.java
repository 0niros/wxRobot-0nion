package cn.com.oniros.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.entity.vo  SourceVO
 * @date 2024/4/7 17:46
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceVO {

    private RoomMessageVO room;

    private PersonToMessageVO to;

    private PersonFromMessageVO from;

}
