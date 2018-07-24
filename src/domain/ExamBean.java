package domain;

import lombok.Data;

@Data
public class ExamBean {
	private String examSeq, memberId, subjectSeq, month, score, recordSeq;

	@Override
	public String toString() {
		return "ExamBean"
				+ "\n examSeq=" + examSeq
				+ "\n memberId=" + memberId
				+ "\n subjectSeq=" + subjectSeq
				+ "\n month=" + month
				+ "\n score=" + score
				+ "\n recordSeq=" + recordSeq;
	}

}
