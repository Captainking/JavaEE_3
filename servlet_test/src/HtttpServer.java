
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.net.InetAddress;  
import java.net.ServerSocket;  
import java.net.Socket;  
  
public class HtttpServer {  
    public static void main(String[] args) {  
        HtttpServer  server = new HtttpServer();  
        server.await();  
    }  
  
    @SuppressWarnings("resource")
	private void await() {  
        ServerSocket serverSocket = null;  
        int port = 3030;  
        try{  
            serverSocket = new ServerSocket(port,1,InetAddress.getByName("127.0.0.1"));  
        }catch(IOException e){  
            e.printStackTrace();  
            System.exit(1);  
        }  
          
        while(true){  
            Socket socket = null;  
            InputStream input = null;  
            OutputStream output = null;  
            try{  
                socket = serverSocket.accept();  
                input = socket.getInputStream();  
                output = socket.getOutputStream();  
                  
                Request request = new Request(input);  
                request.parse();  
                  
                Response response = new Response(output);  
                response.setRequest(request);  
                if(true){  
                    ServletProcessor  processor = new ServletProcessor();  
                    processor.process(request,response);  
                }
                socket.close();  
            }catch(IOException e){  
                e.printStackTrace();  
                System.exit(1);  
            }  
        }  
          
    }  
  
}  