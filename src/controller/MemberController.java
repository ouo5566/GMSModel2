package controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import command.*;
import enums.Action;
import enums.Term;

// @ annotation

@WebServlet({"/member.do","/admin.do"}) // URLmapping
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// doGet, doPost를 service로 한 곳에 받을 수 있다.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Receiver.init(request); // Sentry.init()을 통해 Sentry.cmd 가 만들어졌다.
		//String action = request.getParameter("action"); // DB접근방식에 대해 제한을 둘 수 있다. 인터페이스에 정의되어있는 메소드 수 + move = case 가짓 수
		//String page = request.getParameter("page");
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())) { 
			case ADD:
				Carrier.redirect(request, response,"/member.do?action=move&page=login");
				//response.sendRedirect(request.getContextPath()+"/member.do?action=move&page=user-login-form");
				//response 응답 sendRedirect 다이렉트로 다시 보낸다. /member.do? 를 통해 request를 가지고 다시 서블릿으로 들어온다.
				//ContextPath = domain ex_www.naver.com
				//ServletPath = domain 뒤의 주소 /member.do?action&page
				//ContextPath + ServletPath = URL
				//request 를 쓰지 않고 response 를 쓰는 이유는, request 는 스크립틀릿에서 출발하였으니, 끝에는 스크립틀릿으로 돌아간다.
				//response 는 서블릿 안에서 생겨나 서블릿으로 돌아간다.
				//=> 서블릿 안에서 돈다면 response를 쓰고, 스크립틀릿에서 가져올 값이 있다면 request를 쓴다.
				break;
			case SEARCH:
			case RETRIEVE:
			case MODIFY:
				Carrier.forward(request, response);
				break;
			case REMOVE:
				Carrier.redirect(request, response, "");
				break;
			case LOGIN:
				if(request.getAttribute("match").equals("TRUE")) {
					Carrier.forward(request, response);
				}else {
					Carrier.redirect(request, response, "/member.do?action=move&page=login");
				}
				break;
			case MOVE :
				Carrier.forward(request, response); // JSP에서 request를 통해 데이터를 유지한 채 페이지 이동한다.
				break;
			case FILEUPLOAD :
				Carrier.redirect(request, response, "/member.do?action=retrieve&page=retrieve");
				break;
			default:
				break;
		}
	}
}
