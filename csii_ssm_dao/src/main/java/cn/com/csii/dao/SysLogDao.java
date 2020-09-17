package cn.com.csii.dao;

import cn.com.csii.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface SysLogDao {
    @Insert("INSERT into sysLog (VISITTIME,USERNAME,ip,url,EXECUTIONTIME,METHOD) VALUES (#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void saveLog(SysLog sysLog);
}
