package com.swb.springbootuser.service.impl;

import com.swb.springbootuser.bean.User;
import com.swb.springbootuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: UserServiceImpl
 * @author: 流沐颖
 * @date:2022/6/13 17:54
 * @description:
 * @version: study
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 调用dao层
     */
    @Autowired
    private List<User> user;

    /**
     * @param
     * @return
     * @title:
     * @author: 流沐颖
     * @date:2022/6/13 20:21
     * @description: 查询所有 done
     * @version: study
     */
    @Override
    public String getAll() {
        System.out.println(user);
        return "ok" + System.currentTimeMillis();
    }

    /**
     * @param
     * @return
     * @title:
     * @author: 流沐颖
     * @date:2022/6/13 20:21
     * @description: 删除用户
     * @version: study
     */
    @Override
    public int delUser(Integer uid) {
        System.out.println("需要删除的用户编号为:"+uid);
        if(uid!=0){
            return 10;
        }else {
            return 0;
        }



    }

    /**
     * @param
     * @return
     * @title:
     * @author: 流沐颖
     * @date:2022/6/13 20:29
     * @description: 更新
     * @version: study
     */
    @Override
    public int updateUser(Integer uid) {
        System.out.println("需要更新的用户编号为:"+uid);

        if(uid!=0){
            return 10;
        }else {
            return 0;
        }
    }

    /**
     * @param
     * @return
     * @title:
     * @author: 流沐颖
     * @date:2022/6/13 20:31
     * @description: 添加
     * @version: study
     */
    @Override
    public int addUser(User user) {
        System.out.println("添加的用户为："+user);
        if(user!=null){
            return 10;
        }else {
            return 0;
        }
    }


}
