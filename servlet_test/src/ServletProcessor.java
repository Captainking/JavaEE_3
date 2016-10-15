import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletProcessor {

	public void process(Request request, Response response) {
		String uri = request.getUri();
		System.out.println("uri: "+uri);
		if(uri!=null){
		String servletName = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println("Servlet: " + servletName + "**********");
		URLClassLoader loader = null;
		try {
			URL[] urls = new URL[1];
			URLStreamHandler streamHandler = null;
			File classPath = new File(System.getProperty("user.dir") + File.separator + "src");
			String repository = new URL("file", null, classPath.getCanonicalPath() + File.separator).toString();
			System.out.println("repository: " + repository + "*********");
			urls[0] = new URL(null, repository, streamHandler);
			loader = new URLClassLoader(urls);
		} catch (IOException e) {
			System.out.println(e.toString() + "****1****");
		}

		Class myClass = null;
		try {
			myClass = loader.loadClass(servletName);
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}

		Servlet servlet = null;
		try {
			servlet = (Servlet) myClass.newInstance();
			servlet.service((ServletRequest) request, (ServletResponse) response);
		} catch (Exception e) {
			System.out.println(e.toString() + "****2****");
		} catch (Throwable e) {
			System.out.println(e.toString() + "****3****");
		}

	}else{
		uri="/Error";
			String servletName = uri.substring(uri.lastIndexOf("/")+1);
			System.out.println("Servlet: " + servletName + "**********");
			URLClassLoader loader = null;
			try {
				URL[] urls = new URL[1];
				URLStreamHandler streamHandler = null;
				File classPath = new File(System.getProperty("user.dir") + File.separator + "src");
				String repository = new URL("file", null, classPath.getCanonicalPath() + File.separator).toString();
				System.out.println("repository: " + repository + "*********");
				urls[0] = new URL(null, repository, streamHandler);
				loader = new URLClassLoader(urls);
			} catch (IOException e) {
				System.out.println(e.toString() + "****1****");
			}

			Class myClass = null;
			try {
				myClass = loader.loadClass(servletName);
			} catch (ClassNotFoundException e) {
				System.out.println(e.toString());
			}

			Servlet servlet = null;
			try {
				servlet = (Servlet) myClass.newInstance();
				servlet.service((ServletRequest) request, (ServletResponse) response);
			} catch (Exception e) {
				System.out.println(e.toString() + "****2****");
			} catch (Throwable e) {
				System.out.println(e.toString() + "****3****");
			}

		}
	}
}