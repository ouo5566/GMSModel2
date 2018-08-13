package pool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileDemo {
	// inner class 1회용 클래스로 메모리 최소화, lombok 은 오류가 있기 때문에 걸지 않는다. 
	// inner class 는 사용되는 class 내부에서만 사용되기 때문에 public 을 갖지 않는다. 만약 다른 곳에서 계속 사용하고자 한다면 독립.
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final String PATH = "C:\\Users\\1027\\Documents\\sample.txt"; // 업로드 할 파일의 위치값 + 파일명 + 확장자(파일의 처리방법을 구분)
		try {
			File file = new File(PATH); // Class.forName 과 같다. 메모리상이 아닌 다른세계
			FileWriter fw = new FileWriter(file, true); // append가 true일 때 이어쓰기를 가능하게 해준다. false는 덮어쓴다.
			FileReader fr = new FileReader(file);
			BufferedWriter writer = new BufferedWriter(fw); // 값을 임시로 유지해준다.
			BufferedReader reader = new BufferedReader(fr);
			while(true) {
				System.out.println("[ MENU ]\n 1. 전송 2. 읽기 0.종료");
				switch (s.next()) {
				case "0":
					return;
				case "1":
					System.out.println("[ 메시지 입력 ]");
					writer.write(s.next());
					writer.newLine();
					writer.flush(); // 전송해주는 역할
					break;
				case "2":
					System.out.println("[ 메시지 보기 ]");
					String msg = "";
					while((msg = reader.readLine()) != null) {
						System.out.println("MSG : " + msg);
					}
					reader.close();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		FileName fn = new FileName(PATH);
		System.out.println("File Name : " + fn.getFilename());
		System.out.println("File extension : " + fn.getExt());
	}
}

class FileName{ 
	private String path, sep, ext, filename;
	public FileName(String path) { // 특수한 기능은 생성자를 디폴트로 쓰지 않는다.
		this.path = path;
		this.sep = File.separator;
		this.ext = path.substring(path.lastIndexOf(".") + 1); // substring 사용, indexOf 를 사용하지 않는 것은 방어운전 개념이다.
		this.filename = path.substring(
				path.lastIndexOf(sep) + 1, path.lastIndexOf(".")); // lastIndexOf(), substring() 사용
	}
	public String getPath() {
		return path;
	}
	public String getSep() {
		return sep;
	}
	public String getExt() {
		return ext;
	}
	public String getFilename() {
		return filename;
	}
}