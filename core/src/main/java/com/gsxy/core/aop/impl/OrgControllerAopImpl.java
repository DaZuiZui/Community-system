package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.OrgControllerAop;
import com.gsxy.core.pojo.bo.OrgAddBo;
import com.gsxy.core.pojo.bo.OrgDeleteByIdBo;
import com.gsxy.core.pojo.bo.OrgSelectByIdBo;
import com.gsxy.core.pojo.bo.OrgUpdateByIdBo;
import com.gsxy.core.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrgControllerAopImpl implements OrgControllerAop {

    @Autowired
    private SystemService systemService;
    /**
     * @author zhuxinyu 2023-10-24
     * 添加Org 主要做了鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @After("execution(* com.gsxy.core.controller.*.*(..))")
    public String OrgAdd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        OrgAddBo arg = (OrgAddBo) args[0];
        String token = arg.getToken();
        systemService.auth(token);
        return null;
    }
    /**
     * @author zhuxinyu 2023-10-24
     *      删除班级权限验证
     * @param joinPoint
     * @return
     */
    @Override
    public String OrgDeleteById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        OrgDeleteByIdBo arg = (OrgDeleteByIdBo) args[0];
        String token = arg.getToken();
        systemService.auth(token);
        return null;
    }

    /**
     * @author zhuxinyu 2023-10-24
     * 做了权限验证
     * @param joinPoint
     * @return
     */
    @Override
    @After("execution(* com.gsxy.core.controller.*.*(..))")
    public String OrgSelectById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        OrgSelectByIdBo arg = (OrgSelectByIdBo) args[0];
        String token = arg.getToken();
        systemService.auth(token);
        return null;
    }

    /**
     * @author zhuxinyu 2023-10-24
     *   修改权限验证
     * @param joinPoint
     * @return
     */
    @Override
    @After("execution(* com.gsxy.core.controller.*.*(..))")
    public String OrgUpdateById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        OrgUpdateByIdBo arg = (OrgUpdateByIdBo) args[0];
        String token = arg.getToken();
        systemService.auth(token);
        return null;
    }
}
