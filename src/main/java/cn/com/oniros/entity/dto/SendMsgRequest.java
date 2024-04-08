package cn.com.oniros.entity.dto;

import lombok.Data;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.entity.dto  SendMsgRequest
 * @date 2024/4/7 19:33
 */
@Data
public class SendMsgRequest {

    private String to;

    private CommonMessage data;

}
