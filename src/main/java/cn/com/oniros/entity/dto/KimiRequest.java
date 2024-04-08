package cn.com.oniros.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.entity.dto  KimiRequest
 * @date 2024/4/8 0:11
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KimiRequest {

    private String model;

    private Double temperature = 0.3;

    private List<KimiMessage> messages;

    public KimiRequest(String content) {
        this.model = "moonshot-v1-8k";
        this.temperature = 0.3;
        this.messages = new LinkedList<>();
        messages.add(new KimiMessage("user", content));
    }

}
