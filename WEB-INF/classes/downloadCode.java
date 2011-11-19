import javax.servlet.http.HttpServlet;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
 
 
public class downloadCode extends HttpServlet {
 
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException  {

 String filename = request.getParameter("filename");
 String file = "/"+"currencyConverterCode"+".zip";
 System.out.println(file);
 
 response.setContentType("application/zip");
 
 ServletContext ctx = getServletContext();
 InputStream is = ctx.getResourceAsStream(file);
 
 System.out.println(is.toString());
 int read =0;
 
 byte[] bytes = new byte[1024];
 OutputStream os = response.getOutputStream();
 
 while((read = is.read(bytes)) != -1)
 {
 
    os.write(bytes, 0, read);
  
 }
 System.out.println(read);
 os.flush();
 os.close();
 
 
}
}
  