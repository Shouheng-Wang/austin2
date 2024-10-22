package com.wsh.action;

import cn.hutool.core.collection.CollUtil;
import com.wsh.enums.RespStatusEnum;
import com.wsh.domain.MessageParam;
import com.wsh.domain.SendTaskModel;
import com.wsh.pipeline.BusinessProcess;
import com.wsh.pipeline.ProcessContext;
import com.wsh.vo.BasicResultVO;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author 3y
 * @date 2021/11/22
 * @description 前置参数校验
 */
@Slf4j
public class PreParamAction implements BusinessProcess {

    @Override
    public void process(ProcessContext context) {
        SendTaskModel sendTaskModel = (SendTaskModel) context.getProcessModel();

        Long messageTemplateId = sendTaskModel.getMessageTemplateId();
        List<MessageParam> messageParamList = sendTaskModel.getMessageParamList();

        if (messageTemplateId == null || CollUtil.isEmpty(messageParamList)) {
            context.setNeedBreak(true);
            context.setResponse(BasicResultVO.fail(RespStatusEnum.CLIENT_BAD_PARAMETERS));
        }
    }
}
