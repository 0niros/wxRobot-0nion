package cn.com.oniros.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.response  CommonResponse
 * @date 2024/4/7 17:43
 */
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonResponse<T> {

    private Boolean success;

    private T data;

}
