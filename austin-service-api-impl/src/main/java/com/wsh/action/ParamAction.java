package com.wsh.action;

import com.wsh.domain.SendTaskModel;
import com.wsh.pipeline.BusinessProcess;
import com.wsh.pipeline.ProcessContext;

/**
 * @author 3y
 * @date 2021/11/22
 * @description 参数校验
 */
public class ParamAction implements BusinessProcess {
    @Override
    public void process(ProcessContext context) {
        SendTaskModel sendTaskModel = (SendTaskModel) context.getProcessModel();
    }
}