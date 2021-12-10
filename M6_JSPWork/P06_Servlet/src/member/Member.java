package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet mapping 대신에 어노테이션을 사용해서 servlet을 실행할 수 있다.
@WebServlet("/memberServlet")
public class Member extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String[] aHobby = request.getParameterValues("hobby");
		// 전달받는 값이 어려개일 경우 getParameterValues 메소드를 사용해서 배열로 전달받는다.
		String[] aSubject = request.getParameterValues("subject");
		String color = request.getParameter("color");
		
		String hobby = "";
		if(aHobby != null) {
			for(int i=0; i<aHobby.length; i++) {
				if(aHobby[i] != null) hobby += aHobby[i] + " ";
			}
		}
		
		String subject = "";
		if(aSubject != null) {
			for(int i =0; i<aSubject.length; i++) {
				if(aSubject[i] != null) subject += aSubject[i] + " ";
			}
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title> member </title>");
		out.print("</head");
		out.print("<body>");
		out.print("<ul>");
		out.print("<li> 이 름 : " + name + "</li>");
		out.print("<li> 성 별 : " + gender + "</li>");
		out.print("<li> 취 미 : " + hobby + "</li>");
		out.print("<li> 과 목 : " + subject + "</li>");
		out.print("<li> 색 상 : " + color + "</li>");
		out.print("</ul>");
		out.print("<a href='javascript:history.back();'> 뒤로 </a>");
		out.print("</body>");
		out.print("</html>");
		
		
	}

}
