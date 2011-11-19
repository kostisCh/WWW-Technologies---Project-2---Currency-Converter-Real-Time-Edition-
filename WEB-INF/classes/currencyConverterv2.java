import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.lang.*;

public class currencyConverterv2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String poso = request.getParameter("poso");
               
                
		if(poso == null){
			out.println("Please Insert Amount");
		}
		try{  
			Float.parseFloat(poso);
		}catch(NumberFormatException nfe){  
			out.println("Please Insert A Valid Amount");
			out.close();
		}  
		String CUR1 = request.getParameter("CURRENCY1");
		String CUR2 = request.getParameter("CURRENCY2");
		String format="UTF-8";	
		try {
			URL convert = new URL("http://www.google.com/ig/calculator?hl=en&q="+ poso + CUR1 + "%3D%3F" + CUR2);
			BufferedReader in = new BufferedReader(new InputStreamReader(convert.openStream(),format));
			String answer = in.readLine();
			in.close();
			String[] str = answer.split("\"");	
			answer=str[3];
                        String[] str1 = answer.split(" ");
                        answer=str1[0];
                        answer=answer.replaceAll("�",",");
                        response.sendRedirect("index.jsp?answer="+answer);	  
                        
		}
		catch (IOException ioe) {
			System.exit(1);
		}
		out.close();
	}
}

