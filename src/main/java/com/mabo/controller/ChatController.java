package com.mabo.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mabo.entity.ChatInfo;
import com.mabo.service.ChatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO your comment
 *
 * @author Yujiaqi
 * @date 2020/12/2 19:20
 */
@RestController
@RequestMapping("/chat")
@Api(tags = "用户接口")
public class ChatController {
    @Resource
    private ChatService chatService;

    /**
     * 根据ID获取用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:34
     * @Param  userId  用户ID
     * @Return UserInfoEntity 用户实体
     */
    @ApiOperation("新增用户")
    @PostMapping("/getInfo")
    public ChatInfo getInfo(String userId){
        QueryWrapper<ChatInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ChatInfo::getId,"1").eq(ChatInfo::getId,"1");
        List<ChatInfo> list = chatService.list(queryWrapper);
        System.out.println(list);
        return chatService.getById(userId);
    }
    /**
     * 查询全部信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:35
     * @Param  userId  用户ID
     * @Return List<UserInfoEntity> 用户实体集合
     */
    @ApiOperation("获取集合")
    @PostMapping("/getList")
    public List<ChatInfo> getList(){
        List<ChatInfo> userInfoEntityList = chatService.list();
        return userInfoEntityList;
    }
    /**
     * 分页查询全部数据
     * @Author Sans
     * @CreateTime 2019/6/8 16:37
     * @Return IPage<UserInfoEntity> 分页数据
     */
    @PostMapping("/getInfoListPage")
    public IPage<ChatInfo> getInfoListPage(@RequestParam int pageNum,@RequestParam int size){
        //需要在Config配置类中配置分页插件
        IPage<ChatInfo> page = new Page<>(pageNum,size);
//        LambdaQueryWrapper<ChatInfo> queryWrapper = Wrappers.lambdaQuery();
//        queryWrapper.eq(ChatInfo::getId,"1").eq(ChatInfo::getId,"1");
        IPage<ChatInfo> page1 = chatService.page(page);
        return page1;
    }
    /**
     * 根据指定字段查询用户信息集合
     * @Author Sans
     * @CreateTime 2019/6/8 16:39
     * @Return Collection<UserInfoEntity> 用户实体集合
     */
    @PostMapping("/getListMap")
    public Collection<ChatInfo> getListMap(){
        Map<String,Object> map = new HashMap<>();
        //kay是字段名 value是字段值
        map.put("age",20);
        Collection<ChatInfo> userInfoEntityList = chatService.listByMap(map);
        return userInfoEntityList;
    }
    /**
     * 新增用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:40
     */
    @PostMapping("/saveInfo")
    public void saveInfo(){
        ChatInfo userInfoEntity = new ChatInfo();
        userInfoEntity.setId("小龙");
        userInfoEntity.setMsg("JAVA");
        chatService.save(userInfoEntity);
    }
    /**
     * 批量新增用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:42
     */
    @PostMapping("/saveInfoList")
    public void saveInfoList(){
        //创建对象
        ChatInfo userInfoEntity = new ChatInfo();
        userInfoEntity.setId("小龙");
        userInfoEntity.setMsg("JAVA");
        ChatInfo userInfoEntity2 = new ChatInfo();
        userInfoEntity2.setId("小龙2");
        userInfoEntity2.setMsg("JAVA2");
        //批量保存
        List<ChatInfo> list =new ArrayList<>();
        list.add(userInfoEntity);
        list.add(userInfoEntity2);
        chatService.saveBatch(list);
    }
    /**
     * 更新用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:47
     */
    @PostMapping("/updateInfo")
    public void updateInfo(){
        //根据实体中的ID去更新,其他字段如果值为null则不会更新该字段,参考yml配置文件
        ChatInfo userInfoEntity = new ChatInfo();
        userInfoEntity.setId("小龙2");
        userInfoEntity.setMsg("JAVA2");
        chatService.updateById(userInfoEntity);
    }
    /**
     * 新增或者更新用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:50
     */
    @PostMapping("/saveOrUpdateInfo")
    public void saveOrUpdate(){
        //传入的实体类userInfoEntity中ID为null就会新增(ID自增)
        //实体类ID值存在,如果数据库存在ID就会更新,如果不存在就会新增
        ChatInfo userInfoEntity = new ChatInfo();
        userInfoEntity.setId("小龙2");
        userInfoEntity.setMsg("JAVA2");
        chatService.saveOrUpdate(userInfoEntity);
    }
    /**
     * 根据ID删除用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:52
     */
    @PostMapping("/deleteInfo")
    public void deleteInfo(String userId){
        chatService.removeById(userId);
    }
    /**
     * 根据ID批量删除用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:55
     */
    @PostMapping("/deleteInfoList")
    public void deleteInfoList(){
        List<String> userIdlist = new ArrayList<>();
        userIdlist.add("12");
        userIdlist.add("13");
        chatService.removeByIds(userIdlist);
    }
    /**
     * 根据指定字段删除用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:57
     */
    @PostMapping("/deleteInfoMap")
    public void deleteInfoMap(){
        //kay是字段名 value是字段值
        Map<String,Object> map = new HashMap<>();
        map.put("skill","删除");
        map.put("fraction",10L);
        chatService.removeByMap(map);
    }

    /**
     * 查询全部信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:35
     * @Param  userId  用户ID
     * @Return List<UserInfoEntity> 用户实体集合
     */
    @ApiOperation("分页查询")
    @PostMapping("/page")
    public IPage<ChatInfo> getList(@RequestBody JSONObject inData){
        int pageNum = inData.getInteger("pageNum");
        int size = inData.getInteger("size");
        IPage<ChatInfo> page = chatService.page(new Page<>(pageNum, size));
        return page;
    }
}
