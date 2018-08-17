package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.*;
import enums.Action;

@WebServlet({"/member.do","/admin.do"}) // URLmapping
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Member Controller");
		System.out.println(request.getParameter("action")+"/"+request.getParameter("page"));
		Receiver.init(request);
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())) { 
			case ADD:
				Carrier.redirect(request, response,"/member.do?action=move&page=login");
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
				if(request.getSession().getAttribute("match").equals("TRUE")) {
					Carrier.forward(request, response);
				}else {
					Carrier.redirect(request, response,
							(request.getParameter("log").equals("logout"))?
									"" : "/member.do?action=move&page=login");
				}
				break;
			case MOVE :
				Carrier.forward(request, response); // JSP에서 request를 통해 데이터를 유지한 채 페이지 이동한다.
				break;
			case FILEUPLOAD :
				System.out.println("File Upload");
				Carrier.redirect(request, response, "/member.do?action=retrieve&page=retrieve");
				break;
			default:
				break;
		}
	}
}
