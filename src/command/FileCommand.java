package command;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import domain.ImageBean;
import domain.MemberBean;
import enums.Term;
import service.ImageServiceImpl;

public class FileCommand extends Command {
	public FileCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	
	@Override
	public void execute() {
		System.out.println("== 1. FILE UPLOAD START ==");
		if(!ServletFileUpload.isMultipartContent(request)) {
			System.out.println("업로드 파일이 없습니다.");
			return;
		}
		System.out.println("== 2. UPLOAD FILE 존재 ==");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax( 1024 * 1024 * 40 ); // 40MB
		upload.setSizeMax( 1024 * 1024 * 50 ); // 50MB
		List<FileItem> items = null;
		
		try {
			System.out.println("== 3. TRY IN ==");
			File file = null; // Class.forName 과 같다. 메모리상이 아닌 다른세계
			items = upload.parseRequest( new ServletRequestContext(request) );
			System.out.println("== 4. ITEMS 생성 ==");
			Iterator<FileItem> iter = items.iterator();
			while(iter.hasNext()) {
				System.out.println("== 5. WHILE IN ==");
				FileItem item = iter.next();
				if(!item.isFormField()) {
					System.out.println("== 6. IF IN ==");
					String fileName = item.getName();
					file = new File(Term.UPLOAD_PATH+fileName);
					item.write(file);
					System.out.println("== 7. SUCCESS ==");
					// IMAGE TABLE 에 ID, NAME, EXT 저장
					ImageBean image = new ImageBean();
					image.setExtension(fileName.substring(fileName.lastIndexOf(".")+1));
					image.setImgName(fileName.substring(0,fileName.lastIndexOf(".")));
					image.setMemberId(((MemberBean)request.getSession().getAttribute("user")).getMemberId());
					ImageServiceImpl.getInstance().addImage(image);
				}else {
					System.out.println("== 8. FAIL ==");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("== 10. FILE UPLOAD ==");
	}
}
