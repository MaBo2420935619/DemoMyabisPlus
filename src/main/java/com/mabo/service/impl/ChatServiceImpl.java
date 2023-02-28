package com.mabo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mabo.dao.ChatInfoDao;
import com.mabo.entity.ChatInfo;
import com.mabo.service.ChatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ChatServiceImpl extends ServiceImpl<ChatInfoDao, ChatInfo> implements ChatService {
    @Resource
    private ChatInfoDao chatInfoDao;
    @Override
    public List<ChatInfo> queryByMsg(String msg) {
        return chatInfoDao.queryByMsg(msg);
    }
}
