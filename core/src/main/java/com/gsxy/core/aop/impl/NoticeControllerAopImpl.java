package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.NoticeControllerAop;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NoticeControllerAopImpl implements NoticeControllerAop {

    @Autowired
    private SystemService systemService;


    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      查询鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.NoticeController.noticeSelectById(..))")
    public void noticeSelect(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        NoticeSelectByIdBo noticeSelectByIdBo = (NoticeSelectByIdBo) args[0];
        String token = noticeSelectByIdBo.getToken();
        systemService.auth(token);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      删除鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.NoticeController.noticeDeleteById(..))")
    public void noticeDeleteById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        NoticeDeleteByIdBo noticeDeleteByIdBo = (NoticeDeleteByIdBo) args[0];
        String token = noticeDeleteByIdBo.getToken();
        systemService.auth(token);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      添加鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.NoticeController.noticeAdd(..))")
    public void noticeAdd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        NoticeAddByBo noticeAddByBo = (NoticeAddByBo) args[0];
        String token = noticeAddByBo.getToken();
        systemService.auth(token);

    }

    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      修改鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.NoticeController.noticeUpdateById(..))")
    public void noticeUpdateById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        NoticeUpdateByIdBo noticeUpdateByIdBo = (NoticeUpdateByIdBo) args[0];
        String token = noticeUpdateByIdBo.getToken();
        systemService.auth(token);
    }

}
