package domain;

import lombok.Data;

@Data
public class RecordBean {
	private String recordSeq, average, grade;

	@Override
	public String toString() {
		return "RecordBean"
				+ "\n recordSeq=" + recordSeq
				+ "\n average=" + average
				+ "\n grade=" + grade;
	}
	
}
