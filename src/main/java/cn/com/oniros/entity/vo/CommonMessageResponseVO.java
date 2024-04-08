package cn.com.oniros.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.entity.vo  CommonResponseVO
 * @date 2024/4/7 17:44
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class CommonMessageResponseVO {

    private String type;

    private String content;

}
