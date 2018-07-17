package domain;

public class ExamBean {
	private String examSeq, memberId, subjectSeq, month, score, recordSeq;

	public String getExamSeq() {
		return examSeq;
	}

	public void setExamSeq(String examSeq) {
		this.examSeq = examSeq;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getSubjectSeq() {
		return subjectSeq;
	}

	public void setSubjectSeq(String subjectSeq) {
		this.subjectSeq = subjectSeq;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getRecordSeq() {
		return recordSeq;
	}

	public void setRecordSeq(String recordSeq) {
		this.recordSeq = recordSeq;
	}

	@Override
	public String toString() {
		return "[시험정보]\n"
				+ "examSeq = " + examSeq + "\n"
				+ "memberId = " + memberId + "\n"
				+ "subjectSeq = " + subjectSeq + "\n"
				+ "month = " + month + "\n"
				+ "score = " + score + "\n"
				+ "recordSeq = " + recordSeq + "\n";
	}

}
