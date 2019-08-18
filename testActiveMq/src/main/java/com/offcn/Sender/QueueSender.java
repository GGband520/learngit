package com.offcn.Sender;

import com.alibaba.fastjson.JSON;
import com.offcn.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jms.*;

@Controller
@RequestMapping("/Jms")
public class QueueSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Destination queueDistination;

    @RequestMapping("/sendMessage")
    public void MessageSende() {
        Student zhangsan = new Student(1, "zhangsan", "22");
        final String jsonString = JSON.toJSONString(zhangsan);
        jmsTemplate.send(queueDistination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                System.out.println("开始发送消息");
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(jsonString);
                return textMessage;
            }
        });
    }
}
