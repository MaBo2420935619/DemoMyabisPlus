package com.mabo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mabo.entity.ChatInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ChatInfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-01 16:18:08
 */
@Mapper
public interface ChatInfoDao extends BaseMapper<ChatInfo> {
    List<ChatInfo> queryByMsg(String msg);
}

