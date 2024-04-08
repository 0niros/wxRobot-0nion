package cn.com.oniros.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.config  KimiConfig
 * @date 2024/4/7 19:23
 */
@Configuration
@Data
public class KimiConfig {

    @Value("${kimi.token}")
    private String token;

    public String generateKimiRequestUrl() {
        return "https://api.moonshot.cn/v1/chat/completions";
    }

}
