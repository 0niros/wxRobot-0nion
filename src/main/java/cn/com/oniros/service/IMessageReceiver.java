package cn.com.oniros.service;

import cn.com.oniros.entity.vo.CommonMessageResponseVO;
import cn.com.oniros.entity.vo.SourceVO;
import cn.com.oniros.response.CommonResponse;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.service  IMessageReceiver
 * @date 2024/4/7 17:50
 */
public interface IMessageReceiver {

    CommonResponse<CommonMessageResponseVO> doHandleMessage(String type,
                                                             byte[] content,
                                                             SourceVO source,
                                                             String isMentioned,
                                                             String isSelfMessage);

}
