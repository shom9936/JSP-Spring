package ex01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * # Servlet
 * - 자바 언어를 기반으로 하는 웹 프로그래밍 기술입니다.
 * - 자바 class 안에 HTML 태그를 포함 할 수 있습니다.
 * 
 * # tomcat의 servlet-api.jar 설정
 * - 서블릿 API는 톰캣의 servlet-api.jar 라이브러리로 제공되므로 클래스 패스를 설정해야 사용 할 수 있습니다.
 * - tomcat 폴더-> lib -> servlet-api.jar
 * 
 * # Servlet
 * - 초기화 init()
 *   > 서블릿 요청시 맨 처음 한번만 호출됩니다.
 *   
 * - 작업 수행 : doGet(), doPost()
 *   > 서블릿 요청시 매번 호출됩니다.
 *     실제로 클라이언트가 요청하는 작업을 수행합니다.
 * 
 * - 종료 : destroy()
 *   > java 코드가 수정이 되었을 때 서블릿의 마무리 작업을 수행합니다.
 *   
 * - init(), destroy() 메서드는 생략 가능하나 doGet() 또는 doPost() 메서드는 반드시 구현해야 합니다.
 * 
 * # 서블릿 생성 과정
 * 1. 사용자 정의 서블릿 클래스 만들기
 * 2. 서블릿 생명주기 메서드 구현
 * 3. 서블릿 맵핑 작업
 * 4. 웹 브라우저에서 서블릿 맵핑 이름으로 요청하기
 * 
 * # 서블릿 맵핑 작업
 * - 프로젝트의 web.xml 에서 설정
 * - <servlet> 태그와 <servlet-mapping> 태그를 이용
 * 
 * # 서블릿 실행
 * 1. 서버 실행
 * 2. 브라우저에 url 추가 후 확인
 * 	- http://주소:port/프로젝트명/서블릿 맵핑 url
 *    Ex ) http://localhost:8080/P06_Servlet/life
 * 
 */



public class LifeCycle extends HttpServlet {
	
	// 최초 요청시 한번만 실행
	public void init(ServletConfig config) throws SecurityException{
		System.out.println("- init() run -");
	}
	
	// 파일이 수정되면 실행하고, 다시 처음부터 동작
	public void destroy() {
		System.out.println("- destroy() run -");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- doGet() run -");
		
	}
	
	
}
