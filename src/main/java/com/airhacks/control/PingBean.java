/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.control;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 *
 * @author altuga
 */
@Stateless
@Interceptors(CallTracer.class)
public class PingBean {
    
    public String getHello() {
        return "Hello from PingBean " ;
    }
    
}
