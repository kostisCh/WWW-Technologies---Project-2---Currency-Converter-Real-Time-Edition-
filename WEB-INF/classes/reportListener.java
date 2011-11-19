import javax.servlet.*;

public class reportListener implements ServletContextListener {

	public void contextInitialized (ServletContextEvent event){
		ServletContext sc = event.getServletContext();
		String link = sc.getInitParameter("reportLink");
		ReportLink r = new ReportLink(link);
		sc.setAttribute("link",r);
	}
	
	public void contextDestroyed (ServletContextEvent event){
	
	}
}