package cn.com.oniros.controller;

import cn.com.oniros.constant.TextConstant;
import cn.com.oniros.entity.vo.CommonMessageResponseVO;
import cn.com.oniros.entity.vo.SourceVO;
import cn.com.oniros.response.CommonResponse;
import cn.com.oniros.service.IMessageReceiver;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.awt.*;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.controller  WxWebHookController
 * @date 2024/4/7 17:34
 */

@RestController
@Slf4j
@RequestMapping("/wx/webhook/v1")
public class WxWebHookController {

    @Resource
    IMessageReceiver messageReceiver;

    @PostMapping(path = "/receiveMessage", consumes = {MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public CommonResponse<CommonMessageResponseVO> doReceiveMessage(@RequestPart("type") String type,
                                                                    @RequestPart(value = "isMentioned", required = false) String isMentioned,
                                                                    @RequestPart(value = "isMsgFromSelf", required = false) String isSelfMessage,
                                                                    MultipartHttpServletRequest request) {
        if (type == null || type.isBlank() || type.equalsIgnoreCase("unknown") || "1".equals(isSelfMessage)) {
            return new CommonResponse<>(true, new CommonMessageResponseVO("text", ""));
        }
        byte[] content = TextConstant.CONTENT_IN.getBytes();
        SourceVO source = null;
        try {
            Part partContent = request.getPart("content");
            Part sourceContent = request.getPart("source");
            ObjectMapper objectMapper = new ObjectMapper();
            source = objectMapper.readValue(sourceContent.getInputStream(), new TypeReference<>(){});
            if ("application/octect-stream".equals(partContent.getContentType())) {
                MultipartFile file = request.getFile("content");
                if (file != null) {
                    content = file.getBytes();
                }
            } else {
                content = partContent.getInputStream().readAllBytes();
            }
        } catch (Exception e) {
            log.info("[Multipart] get multipart content error: ", e);
        }

        return messageReceiver.doHandleMessage(type, content, source, isMentioned, isSelfMessage);
    }

}
