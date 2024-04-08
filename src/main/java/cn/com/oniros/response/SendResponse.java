package cn.com.oniros.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.response  SendResponse
 * @date 2024/4/7 19:28
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendResponse<T> {

    private Boolean success;

    private T task;

    private String message;

}
