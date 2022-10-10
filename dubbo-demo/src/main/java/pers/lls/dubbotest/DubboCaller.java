package pers.lls.dubbotest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import uyun.indian.model.api.MetricMetaService;

@Component
public class DubboCaller {

//    @Autowired
//    MetricMetaService metricMetaService;

    public void init(){
        String tenantId = "e10adc3949ba59abbe56e057f2gg88dd";
        String classCode = null;
        String code = "system.disk.partition.use.pct_usage";
//        System.out.println(JSONObject.toJSONString(metricMetaService.getOne(tenantId,classCode,code)));
    }
}
