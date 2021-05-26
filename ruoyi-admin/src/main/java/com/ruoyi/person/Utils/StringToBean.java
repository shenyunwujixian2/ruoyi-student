package com.ruoyi.person.Utils;

import com.ruoyi.person.Bean.UniResult;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertySetStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sW4716 on 2018/3/8.
 */
public class StringToBean {
    /**
     * 将结果转化为UniResult
     * @param jString
     */
   public UniResult stringToUniResult(String jString){
       JsonConfig config = new JsonConfig();
       Map<String, Object> classMap = new HashMap<String, Object>();
       config.setClassMap(classMap);
       config.setRootClass(UniResult.class);
       config.setPropertySetStrategy(new PropertyStrategyWrapper(PropertySetStrategy.DEFAULT));
       JSONObject obj = JSONObject.fromObject(jString);
       UniResult uniResult= (UniResult) JSONObject.toBean(obj,config);
       return uniResult;
   }
}
