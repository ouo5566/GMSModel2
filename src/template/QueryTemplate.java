package template;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import domain.MemberBean;
import enums.Vendor;
import factory.DatabaseFactory;
import lombok.Data;
import pool.DBConstants;

@Data
public abstract class QueryTemplate {
	Map<String, Object> map;
	List<MemberBean> list;
	PreparedStatement pstmt;

	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
	
	public void pStmtInit() {
		try {
			this.pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String) map.get("sql"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public final void play(Map<?, ?> map){ // 상속받는 클래스가 변경할 수 없음
		// play()를 호출하면 밑에 메소드들이 절로 실행된다. Hook...계속 play만 쓰는 것...
		this.pstmt = null;
		this.list = new ArrayList<>();
		this.map = new HashMap<>();
		this.map.put("vendor", Vendor.ORACLE);
		this.map.put("username", DBConstants.USERNAME);
		this.map.put("password", DBConstants.PASSWORD);
		Iterator<?> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			String key = (String) keys.next();
			this.map.put(key, map.get(key));
		}
		initialize();
		pStmtInit();
		startPlay();
		endPlay();
	}
	
	
}
// interface 와의 큰 차이점은 class라 객체라는 점