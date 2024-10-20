package com.wsh.dao;

import com.wsh.domain.SmsRecord;
import org.springframework.data.repository.CrudRepository;

public interface SmsRecordDao extends CrudRepository<SmsRecord, Long> {


}
