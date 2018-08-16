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
		String word = (request.getParameter("a") == null)? "" : request.getParameter("a");
		ImageBean pf = null;
		if(!word.equals("")) {
			request.setAttribute("user", MemberServiceImpl.getInstance().retrieve(word));
			pf = ImageServiceImpl.getInstance().searchOne(word);
		}else {
			pf = ImageServiceImpl.getInstance().searchOne(
					((MemberBean)request.getSession().getAttribute("user")).getMemberId());
		}
		request.setAttribute("profile",
				(pf == null) ?
					"/mypage/vanilla.jpg"	:
						String.format("/upload/%s.%s", pf.getImgName(), pf.getExtension()));
		request.setAttribute("word", word);
		super.execute();
	}
}
