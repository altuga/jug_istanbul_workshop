package com.airhacks.ping.boundary;

import com.airhacks.control.PingBean;
import com.airhacks.entity.Ping;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
public class PingResource {
    
    @Inject
    PingBean pingBean;
    
    @Resource
    ManagedExecutorService executorService;

    @GET
    public String ping() {
        return "Enjoy Java EE 8!" 
                 + " "+ pingBean.getHello()
                + " " +  pingBean.getClass().getName()
                + " " +pingBean.toString()
                + " " + executorService.getClass().getName();
    }
    
    @POST
    public Ping save(Ping ping) {
        return pingBean.save(ping);
    }
}
