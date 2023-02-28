package com.mabo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.io.Serializable;
import java.util.Date;

/**
 * (ChatInfo)实体类
 *
 * @author makejava
 * @since 2022-08-01 16:18:08
 */
@Data
@TableName("chat_info")
public class ChatInfo implements Serializable {
    private static final long serialVersionUID = -23748083142857458L;
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private String id;
    /**
     * 消息
     */
    private String msg;

}

