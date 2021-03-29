package jsp_bean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/beanTest")
public class beanTest extends HttpServlet {
   	private String name = "honggildong";
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    
}
