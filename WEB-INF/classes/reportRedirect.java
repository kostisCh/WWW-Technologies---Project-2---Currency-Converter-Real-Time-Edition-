import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class reportRedirect extends HttpServlet{

	public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
                    throws IOException,ServletException {
		
		ReportLink link = (ReportLink)getServletContext().getAttribute("link");
		response.sendRedirect(link.getLink());
	}
}