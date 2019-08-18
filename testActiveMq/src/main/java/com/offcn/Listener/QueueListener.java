package com.offcn.Listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.offcn.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class QueueListener implements MessageListener {


    @Override
    public void onMessage(Message message) {
        System.out.println("监听到消息");
        TextMessage textMessage = (TextMessage) message;
        try {
            String text = textMessage.getText();
            Student student = JSON.parseObject(text,Student.class);
            System.out.println(student);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
