/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.ApplicationContextHelper.TestingDataInjector;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author EJB Laptop
 */
public class ApplicationContextHelper {
    
    private static ApplicationContext ctx;
    
    public static ApplicationContext getContext() {
        
        if(ctx == null) {
            ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        }
        return ctx;
    }
    
}
