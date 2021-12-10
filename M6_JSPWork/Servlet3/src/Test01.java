

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test01
 */

// URLMapping - URL과 클래스 파일을 연결시키는 것
// 어노테이션 - 바로 아래에 있는 영역에 강제적인 의미를 부여하는 클래스
// - 주석형
// - @키워드
@WebServlet("/Test01")
public class Test01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("--- init 실행 ---");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("--- destroy 실행 ---");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("--- service 실행 ---");
		if(request.getMethod().equals("GET")) {
			this.doGet(request, response);
		}
		else if(request.getMethod().equals("POST")) {
			this.doPost(request, response);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("--- doGet 실행 ---");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html; charset=UTF-8");
        
        PrintWriter out = response.getWriter();//out객체 값 받기..
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Test</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div align='center'>");
        out.println("Servlet Test01<br>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("--- doPost 실행 ---");
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
