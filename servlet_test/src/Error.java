import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.Servlet;  
import javax.servlet.ServletConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
  
  
public class Error implements Servlet {  
  
    public void destroy() {  
        System.out.println("destroy");  
  
    }  
  
    public ServletConfig getServletConfig() {  
        // TODO Auto-generated method stub  
        return null;  
    }  
  
    public String getServletInfo() {  
        // TODO Auto-generated method stub  
        return null;  
    }  
  
    public void init(ServletConfig arg0) throws ServletException {  
        System.out.println("init");  
  
    }  
  
    public void service(ServletRequest arg0, ServletResponse arg1)  
            throws ServletException, IOException {  
        System.out.println("form service");  
        PrintWriter out = arg1.getWriter(); 
        out.println("File Not Found or Some Other Reason");  
       
    }  
}