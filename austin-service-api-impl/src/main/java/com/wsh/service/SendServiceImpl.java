package com.wsh.service;

import com.wsh.domain.BatchSendRequest;
import com.wsh.domain.SendRequest;
import com.wsh.domain.SendResponse;
import com.wsh.domain.SendTaskModel;
import com.wsh.enums.RequestType;
import com.wsh.pipeline.ProcessContext;
import com.wsh.pipeline.ProcessController;
import com.wsh.pojo.TaskInfo;
import org.aspectj.util.LangUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 发送接口
 * @author 3y
 */
@Service
public class SendServiceImpl implements SendService  {

    @Autowired
    private ProcessController processController;

    @Override
    public SendResponse send(SendRequest sendRequest) {

        SendTaskModel sendTaskModel = SendTaskModel.builder()
                .requestType(RequestType.SINGLE.getCode())
                .messageParam(sendRequest.getMessageParam())
                .taskInfo(TaskInfo.builder().messageTemplateId(sendRequest.getMessageTemplateId()).build())
                .build();

        ProcessContext context = ProcessContext.builder()
                .code(sendRequest.getCode())
                .processModel(sendTaskModel).build();

        ProcessContext process = processController.process(context);

        return new SendResponse(process.getResponse().getCode(), process.getResponse().getMsg());
    }

    @Override
    public SendResponse batchSend(BatchSendRequest batchSendRequest) {
        SendTaskModel sendTaskModel = SendTaskModel.builder()
                .requestType(RequestType.BATCH.getCode())
                .messageParamList(batchSendRequest.getMessageParamList())
                .taskInfo(TaskInfo.builder().messageTemplateId(batchSendRequest.getMessageTemplateId()).build())
                .build();

        ProcessContext context = ProcessContext.builder()
                .code(batchSendRequest.getCode())
                .processModel(sendTaskModel).build();

        ProcessContext process = processController.process(context);

        return new SendResponse(process.getResponse().getCode(), process.getResponse().getMsg());
    }


}

