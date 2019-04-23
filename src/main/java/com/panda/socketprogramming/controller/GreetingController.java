package com.panda.socketprogramming.controller;

import com.panda.socketprogramming.model.Greeting;
import com.panda.socketprogramming.model.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.Timer;
import java.util.TimerTask;

@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    //@SendTo("/topic/greetings")
    public void greeting(HelloMessage message) throws Exception {
        System.out.println(message.getName());
        System.out.println(message.getVisitorId());
        Thread.sleep(1000); // simulated delay
        simpMessagingTemplate.convertAndSend("/topic/" + message.getVisitorId(), new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!"));
        Thread.sleep(2000);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                simpMessagingTemplate.convertAndSend("/topic/" + message.getVisitorId(), new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!"));
            }
        }, 2000);// 设定指定的时间time,此处为2000毫秒
    }



}