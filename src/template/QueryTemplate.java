package template;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import enums.Vendor;
import lombok.Data;
import pool.DBConstants;

@Data
public abstract class QueryTemplate {
	HashMap<String, Object> map;
	List<Object> list;
	PreparedStatement pstmt;
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();

   //template method
	public final void play(HashMap<String, Object> map){ // 상속받는 클래스가 변경할 수 없음
		// play()를 호출하면 밑에 메소드들이 절로 실행된다. Hook...계속 play만 쓰는 것...
		this.pstmt = null;
		this.list = new ArrayList<>();
		this.map = map;
		this.map.put("vendor", Vendor.ORACLE);
		this.map.put("username", DBConstants.USERNAME);
		this.map.put("password", DBConstants.PASSWORD);
		initialize();
		startPlay();
		endPlay();
	}
}
// interface 와의 큰 차이점은 class라 객체라는 점