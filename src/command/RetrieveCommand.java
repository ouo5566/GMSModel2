package command;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command{
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		System.out.println("==Retrieve Command==");
		String word = request.getParameter("a");
		if(word != null) {
			request.setAttribute("user", MemberServiceImpl.getInstance().retrieve(word));
		}
		
		ImageBean pf = ImageServiceImpl.getInstance().searchOne(
													((MemberBean)request.getSession().getAttribute("user")).getMemberId());
		System.out.println(pf);
		request.setAttribute("profile",
				(pf == null) ?
					"/mypage/vanilla.jpg"	:
						String.format("/upload/%s.%s", pf.getImgName(), pf.getExtension()));
		super.execute();
	}
}
