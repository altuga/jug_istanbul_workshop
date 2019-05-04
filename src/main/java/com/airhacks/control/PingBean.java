/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.control;

import com.airhacks.entity.Ping;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author altuga
 */
@Stateless
@Interceptors(CallTracer.class)
public class PingBean {
    
    @PersistenceContext
    EntityManager entityManager;
    
    public String getHello() {
        return "Hello from PingBean " ;
    }
    
    
    public Ping save(Ping ping) {
        return entityManager.merge(ping);
        
    }
    
    public List<Ping> listall() {
       return entityManager.createNamedQuery("all", Ping.class).getResultList();
    }
    
}
