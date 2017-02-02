package com.ch8sessionredis.controller;

import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

	//http://localhost:8081/boot/uid
	@RequestMapping("/uid")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
        	System.out.println("新生成");
            uid = UUID.randomUUID();
        }else{
        	System.out.println("缓存获取");
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

}
