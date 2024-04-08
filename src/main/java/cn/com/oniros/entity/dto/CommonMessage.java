package cn.com.oniros.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.entity.dto  CommonMessage
 * @date 2024/4/7 19:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonMessage {

    private String type;

    private String content;

}
