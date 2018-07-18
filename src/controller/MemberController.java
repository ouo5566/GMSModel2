package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Sentry;
import domain.*;
import enums.Action;
import service.*;

// @ annotation
/*"/member/join-form.do","/member/join-result.do","/member/delete-form.do","/member/delete-result.do","/member/member-list.do",
	"/member/search-id-form.do","/member/search-id-result.do","/member/search-team-form.do","/member/search-team-result.do",
	"/member/update-form.do","/member/update-result.do","/member/user-login-form.do","/member/user-login-result.do","/index.do"*/

@WebServlet({"/member.do"}) // URLmapping
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--MemberController--");
		Sentry.init(request);

		//String action = request.getParameter("action"); // DB접근방식에 대해 제한을 둘 수 있다. 인터페이스에 정의되어있는 메소드 수 + move = case 가짓 수
		//String page = request.getParameter("page");
		List<MemberBean> list = null;
		MemberBean member = null;
		System.out.println(Sentry.cmd.getAction().toUpperCase());
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())) { 
			case MOVE : 
				System.out.println("--Controller_move--");
				try {Carrier.send(request, response); // 이동시켜주는 Carrier
				} catch (Exception e) {e.printStackTrace();}
				break;
			case JOIN:
				System.out.println("--Controller_join--");
				member = new MemberBean();
				member.setMemberId(request.getParameter("userid"));
				member.setName(request.getParameter("username"));
				member.setPassword(request.getParameter("password"));
				member.setSsn(request.getParameter("userssn"));
				response.sendRedirect(request.getContextPath()+"/member.do?action=move&page=user-login-form");
				System.out.println("-- login form 이동--");
				//response 응답 sendRedirect 다이렉트로 다시 보낸다. /member.do? 를 통해 request를 가지고 다시 서블릿으로 들어온다.
				//ContextPath = domain ex_www.naver.com
				//ServletPath = domain 뒤의 주소 /member.do?action&page
				//ContextPath + ServletPath = URL
				//request 를 쓰지 않고 response 를 쓰는 이유는, request 는 스크립틀릿에서 출발하였으니, 끝에는 스크립틀릿으로 돌아간다.
				//response 는 서블릿 안에서 생겨나 서블릿으로 돌아간다.
				//=> 서블릿 안에서 돈다면 response를 쓰고, 스크립틀릿에서 가져올 값이 있다면 request를 쓴다.
				
				/*if(!MemberServiceImpl.getInstance().findByUser(member)) {
					System.out.println("가입된 계정이 있습니다.");
				}else if(!MemberServiceImpl.getInstance().findByOverlabId(member.getMemberId())) {
					System.out.println("줃복되는 아이디 입니다.");
				}else {
					System.out.println("환영합니다.");
					MemberServiceImpl.getInstance().createMember(member);
				}*/
				break;
			case LIST:
				System.out.println("--Controller_list--");
				list = MemberServiceImpl.getInstance().list();
				System.out.println("member-list-size : "+list.size());
				break;
			case SEARCH:
				System.out.println("--Controller_search--");
				/*list = MemberServiceImpl.getInstance().findByTeamId(request.getParameter("team-id"));
				System.out.println("team-list-size : "+list.size());*/
				break;
			case RETRIEVE:
				System.out.println("--Controller_retrieve--");
				/*member = MemberServiceImpl.getInstance().findById(request.getParameter("member-id"));
				System.out.println("member-name : "+member.getName());*/
				break;
			case COUNT:
				System.out.println("--Controller_count--");
				/*String count = MemberServiceImpl.getInstance().memberCount();
				System.out.println("member-count : " + count);*/
				break;
			case UPDATE:
				System.out.println("--Controller_update--");
				String pw = request.getParameter("userpw");
				String newPW = request.getParameter("new-userpw");
				member = new MemberBean();
				member.setMemberId(request.getParameter("userid"));
				member.setPassword(pw);
				response.sendRedirect(request.getContextPath());
				/*if(!pw.equals(newPW) && MemberServiceImpl.getInstance().login(member)) {
					member.setPassword(pw+"/"+newPW);
					MemberServiceImpl.getInstance().modifyMember(member);
					System.out.println("비밀번호가 변경되었습니다.");
				}*/
				break;
			case DELETE:
				System.out.println("--Controller_delete--");
				String userPW = request.getParameter("userpw");
				String confirmPW = request.getParameter("confirm-pw");
				member = new MemberBean();
				member.setMemberId(request.getParameter("userid"));
				member.setPassword(userPW);
				response.sendRedirect(request.getContextPath());
				/*if(userPW.equals(confirmPW) && MemberServiceImpl.getInstance().login(member)) {
					MemberServiceImpl.getInstance().removeMember(member);
					System.out.println("계정이 삭제되었습니다.");
				}*/
				break;
			case LOGIN:
				System.out.println("--Controller_login--");
				member = new MemberBean();
				member.setMemberId(request.getParameter("userid"));
				member.setName(request.getParameter("username"));
				member.setPassword(request.getParameter("password"));
				member.setSsn(request.getParameter("userssn"));
				response.sendRedirect(request.getContextPath());
				/*if(MemberServiceImpl.getInstance().login(member)) {
					System.out.println("어서오세요");
				}else {
					System.out.println("아이디 혹은 비밀번호가 정확하지 않습니다.");
				}*/
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
