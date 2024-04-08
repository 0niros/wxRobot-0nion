package cn.com.oniros.clients;

import cn.com.oniros.config.KimiConfig;
import cn.com.oniros.entity.dto.KimiRequest;
import cn.com.oniros.entity.dto.KimiResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.clients  KimiClient
 * @date 2024/4/7 19:23
 */
@Component
@Slf4j
public class KimiClient {

    @Resource
    KimiConfig kimiConfig;

    public KimiResponse doKimiRequest(String question) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + kimiConfig.getToken());
        RestTemplate template = new RestTemplate();

        KimiRequest request = new KimiRequest(question);

        HttpEntity<KimiRequest> entity = new HttpEntity<>(request, headers);
        return template.postForEntity(kimiConfig.generateKimiRequestUrl(), entity, KimiResponse.class).getBody();
    }


}
