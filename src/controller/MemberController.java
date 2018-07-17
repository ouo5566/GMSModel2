package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @ annotation
/*"/member/join-form.do","/member/join-result.do","/member/delete-form.do","/member/delete-result.do","/member/member-list.do",
	"/member/search-id-form.do","/member/search-id-result.do","/member/search-team-form.do","/member/search-team-result.do",
	"/member/update-form.do","/member/update-result.do","/member/user-login-form.do","/member/user-login-result.do","/index.do"*/

@WebServlet({"/member.do"}) // URLmapping
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--MemberController--");
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		switch(action) {
			case "move" : 
				request.getRequestDispatcher("/WEB-INF/view/member/"+ page +".jsp").forward(request, response);
				break;
		}
		//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/join-form.jsp");
		//rd.forward(request, response);
		//request.getServletPath() > {"/member/join-form.do","/member/join-result.do"}
		//request.getContextPath() > GMS-Model2 > domain(주소)
		
		/*switch(request.getServletPath()) {
		case "/member/join-form.do":
			request.getRequestDispatcher("/WEB-INF/view/member/join-form.jsp").forward(request, response);
			break;
		case "/member/join-result.do":
			request.getRequestDispatcher("/WEB-INF/view/member/join-result.jsp").forward(request, response);
			break;
		case "/member/delete-form.do":
			request.getRequestDispatcher("/WEB-INF/view/member/delete-form.jsp").forward(request, response);
			break;
		case "/member/delete-result.do":
			request.getRequestDispatcher("/WEB-INF/view/member/delete-result.jsp").forward(request, response);
			break;
		case "/member/member-list.do":
			request.getRequestDispatcher("/WEB-INF/view/member/member-list.jsp").forward(request, response);
			break;
		case "/member/search-id-form.do":
			request.getRequestDispatcher("/WEB-INF/view/member/search-id-form.jsp").forward(request, response);
			break;
		case "/member/search-id-result.do":
			request.getRequestDispatcher("/WEB-INF/view/member/search-id-result.jsp").forward(request, response);
			break;
		case "/member/search-team-form.do":
			request.getRequestDispatcher("/WEB-INF/view/member/search-team-form.jsp").forward(request, response);
			break;
		case "/member/search-team-result.do":
			request.getRequestDispatcher("/WEB-INF/view/member/search-team-result.jsp").forward(request, response);
			break;
		case "/member/update-form.do":
			request.getRequestDispatcher("/WEB-INF/view/member/update-form.jsp").forward(request, response);
			break;
		case "/member/update-result.do":
			request.getRequestDispatcher("/WEB-INF/view/member/update-result.jsp").forward(request, response);
			break;
		case "/member/user-login-form.do":
			request.getRequestDispatcher("/WEB-INF/view/member/user-login-form.jsp").forward(request, response);
			break;
		case "/member/user-login-result.do":
			request.getRequestDispatcher("/WEB-INF/view/member/user-login-result.jsp").forward(request, response);
			break;
		case "/index.do":
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			break;
		
		}*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
