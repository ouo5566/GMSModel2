package domain;

import lombok.Data;

@Data
public class MemberBean {
	private String memberId, teamId, name, ssn, roll, password, age, gender, subject;

	/*@Override
	public String toString() {
		return "{memberId : \""+memberId+"\", teamId : \""+ teamId + "\", name : \"" + name + "\", ssn : \"" + ssn + "\", roll : \""
				+ roll + "\", password : \"" + password + "\", age : \"" + age + "\", gender : \"" + gender + "\", subject : \"" + subject
				+ "\"}";
	}*/
	
}


