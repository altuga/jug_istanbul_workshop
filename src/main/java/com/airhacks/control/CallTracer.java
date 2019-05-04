/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.control;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author altuga
 */
public class CallTracer {
    
    @AroundInvoke
    public Object trace(InvocationContext context) throws Exception{
         System.out.println("-- before -- ");
        try {
            return context.proceed();
        } finally {
            System.out.println("-- after -- ");
        }
        
    }
    
}
