package com.wsh.service;

import com.wsh.domain.SendRequest;
import com.wsh.domain.SendResponse;

/**
 * 发送接口
 *
 * @author 3y
 */
public interface SendService {


    SendResponse send(SendRequest sendRequest);


    SendResponse batchSend(SendRequest sendRequest);
}
