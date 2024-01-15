package com.alibaba.nacos.example.spring.boot.controller;

import com.alibaba.nacos.example.spring.boot.controller.config.CodeConfig;
import com.alibaba.nacos.example.spring.boot.controller.config.LocalConfig;
import com.alibaba.nacos.example.spring.boot.controller.config.ObjConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("config")
public class ConfigController {

    @Autowired
    private CodeConfig codeConfig;

    @Autowired
    private ObjConfig objConfig;

    @Autowired
    private LocalConfig localConfig;


    /**
     * @return
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     */
    @GetMapping("/list-code")
    @ResponseBody
    public Map<String, Object> listCode() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return getConfigMap(codeConfig);
    }

        /**
     * @return
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     */
    @GetMapping("/list-obj")
    @ResponseBody
    public Map<String, Object> listOri() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return getConfigMap(objConfig);
    }

            /**
     * @return
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     */
    @GetMapping("/list-local")
    @ResponseBody
    public Map<String, Object> listLocal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return getConfigMap(localConfig);
    }

    private Map<String, Object> getConfigMap(Object config) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Map<String, Object> result = new HashMap<String, Object>();
        for(Method m : config.getClass().getMethods()){
            if(m.getName().equals("getClass")){
                continue;
            }
            if(m.getName().startsWith("get")){
                result.put(m.getName(), m.invoke(config, null));
            }else if(m.getName().startsWith("is")){
                result.put(m.getName(), m.invoke(config, null));
            }
        }
        return result;
    }
    
}