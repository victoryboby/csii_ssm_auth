package cn.com.csii.service;

import cn.com.csii.domain.SysLog;

public interface SysLogService {
    void saveLog(SysLog sysLog) throws Exception;
}
