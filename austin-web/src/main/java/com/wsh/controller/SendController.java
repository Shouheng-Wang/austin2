package com.wsh.controller;

import com.wsh.handler.SmsHandler;
import com.wsh.pojo.TaskInfo;
import com.wsh.pojo.vo.BasicResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@RestController
public class SendController {


    @Autowired
    private SmsHandler smsHandler;

    /**
     * 测试发送短信
     * @param phone 手机号
     * @return BasicResultVO
     */
    @GetMapping("/sendSms")
    public BasicResultVO<Void> sendSms(String phone, String content, Long messageTemplateId) {

        TaskInfo taskInfo = TaskInfo.builder().receiver(new HashSet<>(
                        Collections.singletonList(phone)))
                .content(content)
                .messageTemplateId(messageTemplateId)
                .build();

        if (smsHandler.doHandler(taskInfo)) {
            return BasicResultVO.success("发送信息成功");
        }

        return BasicResultVO.fail();
    }

}
