package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.ActiveMapper;
import com.gsxy.core.pojo.Activity;
import com.gsxy.core.pojo.bo.ActiveAddBo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.ActiveService;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActiveService {

    @Autowired
    private ActiveMapper activeMapper;

    /**
     * @auhtor hln 2023-10-24
     *      添加活动功能
     * @param activityAddBo
     * @return
     */
    @Override
    public ResponseVo addActive(ActiveAddBo activityAddBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");


        return new ResponseVo("增加成功",null,"0x200");
    }

}
