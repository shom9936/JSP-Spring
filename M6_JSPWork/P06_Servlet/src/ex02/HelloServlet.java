package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// setContentType() 메서드를 사용해서 응답할 데이터 종류가 html임을 지정
		response.setContentType("text/html; charset=utf-8");
		
		// HttpServletResponse 객체의 getWriter() 를 사용해서 출력 스티림 PrintWriter 객체를 가져옵니다.
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> HelloServlet </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("HelloServlet <br>");
		out.println("안녕하세요 서블릿 ^^");
		out.println("</body>");
		out.println("</html>");
		
	}
}
