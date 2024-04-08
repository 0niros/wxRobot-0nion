package cn.com.oniros.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.entity.vo  PersonToMessageVO
 * @date 2024/4/7 17:38
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonToMessageVO {

    private String id;

    private PersonPayloadVO payload;

}
