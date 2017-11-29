package launch;

import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.Host;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Main {

    public static void main(String args[]) throws LifecycleException, ServletException{
        Tomcat tomcat = new Tomcat();
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        tomcat.setPort(Integer.valueOf(webPort));

        // Activiti
        Host host = tomcat.getHost();
        tomcat.addWebapp(host,"activiti-app", new File("src/main/webapp/activiti-app.war").getAbsolutePath());
        
        tomcat.start();
        tomcat.getServer().await();
    }

}