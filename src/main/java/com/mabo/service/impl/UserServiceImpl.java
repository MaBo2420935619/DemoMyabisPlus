package com.mabo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mabo.dao.UserDao;
import com.mabo.entity.User;
import com.mabo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-03-02 20:25:27
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}

