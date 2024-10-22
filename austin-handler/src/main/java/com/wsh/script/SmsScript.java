package com.wsh.script;


import com.wsh.domain.SmsRecord;
import com.wsh.domain.SmsParam;

import java.util.List;

/**
 * 短信脚本 接口
 * @author 3y
 */
public interface SmsScript {


    /**
     * 发送短信
     * @param smsParam 发送短信参数
     * @return 渠道商接口返回值
     */
    List<SmsRecord> send(SmsParam smsParam);

}
