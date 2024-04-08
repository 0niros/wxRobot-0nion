package cn.com.oniros.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.entity.dto  KimiResponse
 * @date 2024/4/8 0:08
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KimiResponse {

    private String id;

    private Long created;

    private List<KimiChoice> choices;

}
