package com.airhacks.ping.boundary;

import com.airhacks.control.PingBean;
import com.airhacks.entity.Ping;
import java.util.Arrays;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;
import org.eclipse.microprofile.faulttolerance.Bulkhead;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metered;

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
    
    @GET
    @Path("all")
    @Metered
    @Fallback(fallbackMethod = "hagetallPing")
    @Bulkhead
    public List<Ping> getallPing() {
        if(true) {
            throw new RuntimeException("no code for today");
        }
        return pingBean.listall();
    }
    
    public List<Ping> hagetallPing() {
        return Arrays.asList(new Ping());
    }
    
    @POST
    @Counted(monotonic = true)
    public Ping save(Ping ping) {
        return pingBean.save(ping);
    }
}
