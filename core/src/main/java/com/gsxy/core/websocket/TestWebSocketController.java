package com.gsxy.core.websocket;

import com.gsxy.core.controller.UserAdminController;
import com.gsxy.core.mapper.UserAdminMapper;
import com.gsxy.core.pojo.bo.AdminCheckInStatusInRealTimeBo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.SystemService;
import com.gsxy.core.util.SpringContextUtil;
import com.gsxy.core.util.ThreadLocalUtil;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@ServerEndpoint("/websocket/{token}")
@CrossOrigin
@Component
public class TestWebSocketController {

    // 构造函数注入任何需要的依赖项
    private UserAdminController userAdminController = SpringContextUtil.getBean(UserAdminController.class);

    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token,@PathParam("content") String content) throws IOException {
//        System.out.println("签到已发起"+token);
        String s = this.serviceFunction(token, session,content);
        session.getBasicRemote().sendText(s);
    }

    // 其他方法...
    @OnMessage
    public void onMessage(String token, Session session,String content) throws IOException {

        //实现用户签到信息的实时查看
        String s = this.serviceFunction(token, session,content);
        session.getBasicRemote().sendText(s);

    }


    public String serviceFunction(String token, Session session,String content) throws IOException {
        AdminCheckInStatusInRealTimeBo adminCheckInStatusInRealTimeBo = new AdminCheckInStatusInRealTimeBo();
        adminCheckInStatusInRealTimeBo.setContent(content);
        adminCheckInStatusInRealTimeBo.setToken(token);
        String str = userAdminController.adminCheckInStatusInRealTime(adminCheckInStatusInRealTimeBo);

        return str;
    }


}
