package com.samgau.start.standalone;

import com.samgau.start.dep.Employee;
import com.samgau.start.dep.EmployeeService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by Tolegen Izbassar on 06.05.2017.
 */
public class Runner {

    public static void main(String[] args) throws NamingException {
        Properties prop = new Properties();

        prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        prop.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
        prop.put(Context.SECURITY_PRINCIPAL, "admin");
        prop.put(Context.SECURITY_CREDENTIALS, "admin");

        prop.put("jboss.naming.client.ejb.context", true);

        Context context = new InitialContext(prop);

        EmployeeService service = (EmployeeService)
                context.lookup("java:app/service-1.0/EmployeeServiceImpl!com.samgau.start.api.EmployeeServiceRemote");

        Employee testEmployee = new Employee();
        testEmployee.setEmail("asd");
        testEmployee.setSkype("asd");
        service.save(testEmployee);
    }
}
