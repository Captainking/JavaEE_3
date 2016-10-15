import java.io.IOException;  
import java.io.OutputStream;  
import java.io.PrintWriter;  
import java.util.Locale;  
  
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;  
  
public class Response implements ServletResponse{  
    private OutputStream output;  
    private Request request;  
    private PrintWriter writer;  
  
    public Response(OutputStream output) {  
        this.output = output;  
    }  
  
    public void setRequest(Request request) {  
        this.request = request;  
          
    }    
    
    public PrintWriter getWriter() throws IOException {  
        writer = new PrintWriter(output,true);  
        return writer;  
    }  
    public void flushBuffer() throws IOException {  
        // TODO Auto-generated method stub  
          
    }  
  
    public int getBufferSize() {  
        // TODO Auto-generated method stub  
        return 0;  
    }  
  
    public String getCharacterEncoding() {  
        // TODO Auto-generated method stub  
        return null;  
    }  
  
    public String getContentType() {  
        // TODO Auto-generated method stub  
        return null;  
    }  
  
    public Locale getLocale() {  
        // TODO Auto-generated method stub  
        return null;  
    }  
  
    public ServletOutputStream getOutputStream() throws IOException {  
        // TODO Auto-generated method stub  
        return null;  
    }  
    public boolean isCommitted() {  
        // TODO Auto-generated method stub  
        return false;  
    }  
  
    public void reset() {  
        // TODO Auto-generated method stub  
          
    }  
  
    public void resetBuffer() {  
        // TODO Auto-generated method stub  
          
    }  
  
    public void setBufferSize(int arg0) {  
        // TODO Auto-generated method stub  
          
    }  
  
    public void setCharacterEncoding(String arg0) {  
        // TODO Auto-generated method stub  
          
    }  
  
    public void setContentLength(int arg0) {  
        // TODO Auto-generated method stub  
          
    }  
  
    public void setContentType(String arg0) {  
        // TODO Auto-generated method stub  
          
    }  
  
    public void setLocale(Locale arg0) {  
        // TODO Auto-generated method stub  
          
    }  
  
}  