package com.wsh.script;


import com.wsh.domain.SmsRecord;
import com.wsh.pojo.SmsParam;

import java.util.List;

public interface SmsScript {
    /**
     * @param smsParam 发送短信参数
     * @return 渠道商接口返回值
     */
    List<SmsRecord> send(SmsParam smsParam);
}
