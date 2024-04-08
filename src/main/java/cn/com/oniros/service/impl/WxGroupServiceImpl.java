package cn.com.oniros.service.impl;

import cn.com.oniros.entity.po.WxGroupPO;
import cn.com.oniros.service.IWxGroupService;
import org.springframework.stereotype.Service;

/**
 * @author Li Xiaoxu
 * @description cn.com.oniros.service.impl  WxGroupServiceImpl
 * @date 2024/4/7 18:57
 */
@Service
public class WxGroupServiceImpl implements IWxGroupService {
    @Override
    public void addGroup(String groupId, String groupName) {
        WxGroupPO groupPO = new WxGroupPO();
        groupPO.setId(groupId);
        groupPO.setRoomName(groupName);
    }
}
