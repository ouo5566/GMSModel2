package domain;

import lombok.Data;

@Data
public class MemberBean {
	private String memberId, teamId, name, ssn, roll, password, age, gender, subject;

	@Override
	public String toString() {
		return "Member"
				+ "\n memberId=" + memberId
				+ "\n teamId=" + teamId
				+ "\n name=" + name
				+ "\n ssn=" + ssn
				+ "\n roll="+ roll
				+ "\n password=" + password
				+ "\n age=" + age
				+ "\n gender=" + gender
				;
	}
}


