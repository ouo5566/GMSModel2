package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		MemberBean member = new MemberBean();
		member.setMemberId(request.getParameter("userid"));
		member.setPassword(request.getParameter("password"));
		if(MemberServiceImpl.getInstance().loginFlag(member)) {
			// Attribute 는 key와 value로 처리를 하며, 이 것을 mapping이라고 한다. 사상구조로 내부는 무한하다. (extends HashMap)
			// key값만 unique하면 무한대로(메모리용량) 값을 적재할 수 있다.
			// JSP -> request(action="*.do":주소지, parameter:값) -> Servlet
			// JSP <- request(Attribute) <- Servlet
			request.setAttribute("match", "TRUE");
			request.getSession().setAttribute("user", MemberServiceImpl.getInstance().login(member));
			setPage("mypage");
			// 로그인 성공 -> 마이페이지로 이동과 함께 사용자 스펙 랜더링
			// 그럼 화면에서 다시 정보를 조회해야 한다. => login을 반복하지 않아야한다.
			// 단, 로그아웃시에는 개인정보를 제거하며 로그인이 유지되는 동안만 개인정보를 가지고 있는 한 객체가 필요하다.
			// 이 객체의 스콥(컨텍스트 = 설정값)은 로그인과 로그아웃사이 시간차에서만 유효하다. = 시간에 따른 스콥
			// 시간은 이벤트에 따른 상대적인 시간을 말한다.
		}else {
			
			request.setAttribute("match", "FALSE");
		}
		super.execute();
	}
}
