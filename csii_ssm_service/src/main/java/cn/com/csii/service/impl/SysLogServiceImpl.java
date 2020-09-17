package cn.com.csii.service.impl;

import cn.com.csii.dao.SysLogDao;
import cn.com.csii.domain.SysLog;
import cn.com.csii.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;
    @Override
    public void saveLog(SysLog sysLog) throws Exception {
        sysLogDao.saveLog(sysLog);
    }
}
