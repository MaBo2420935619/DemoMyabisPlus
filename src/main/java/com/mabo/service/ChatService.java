package com.mabo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mabo.entity.ChatInfo;

import java.util.List;

public interface ChatService  extends IService<ChatInfo> {
    List<ChatInfo> queryByMsg(String msg);
}
