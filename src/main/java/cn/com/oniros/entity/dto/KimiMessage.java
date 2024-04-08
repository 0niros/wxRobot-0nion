package cn.com.oniros.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.entity.dto  KimiMessage
 * @date 2024/4/8 0:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KimiMessage {

    private String role;

    private String content;

}
