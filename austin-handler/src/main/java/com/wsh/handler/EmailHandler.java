package com.wsh.handler;

import com.wsh.domain.TaskInfo;
import com.wsh.enums.ChannelType;
import org.springframework.stereotype.Component;

/**
 * 邮件发送处理
 *
 * @author 3y
 */
@Component
public class EmailHandler extends Handler {

    public EmailHandler() {
        channelCode = ChannelType.EMAIL.getCode();
    }

    @Override
    public void handler(TaskInfo taskInfoList) {
    }
}
