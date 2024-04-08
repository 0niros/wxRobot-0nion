package cn.com.oniros.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.entity.vo  PersonPayloadVO
 * @date 2024/4/7 17:39
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonPayloadVO {

    private String alias;

    private String id;

    private String name;

    private Boolean friend;

}
