package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionFactory;
import action.ActionForward;

@WebServlet("*.do") // Url mapping / *.do : 이름은 상관없으나 끝날때는 .do로 끝나야 함
public class PatternController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI();
		// 프로젝트 == context
		String contextPath = request.getContextPath();
		String cmd = requestURI.substring(contextPath.length());
		System.out.println("requestURI " + requestURI);
		System.out.println("contextPath " + contextPath);
		System.out.println("cmd " + cmd);

		//굳이 생성자를 private으로 막고 내부 메소드로 생성하는 이유 : 싱글톤 디자인 패턴
		ActionFactory actionFactory = ActionFactory.getInstance();
		
		// 어디서 요청이 왔는지에 따라 액션 생성
		Action action = actionFactory.action(cmd);
		
		// 생성된 액션에 일 시키기(메소드호출)
		ActionForward af = null;
		try {
			af = action.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (af.isRedirect()) {
			response.sendRedirect(af.getPath());
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
