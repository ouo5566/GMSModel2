package domain;

import lombok.Data;

@Data
public class SubjectBean {
	private String subjectSeq, subjectName;

	@Override
	public String toString() {
		return "SubjectBean"
				+ "\n subjectSeq=" + subjectSeq
				+ "\n subjectName=" + subjectName;
	}
	
}
