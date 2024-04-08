package cn.com.oniros.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.entity.vo  PersonFromMessageVO
 * @date 2024/4/7 17:40
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonFromMessageVO {

    private String id;

    private PersonPayloadVO payload;

}
