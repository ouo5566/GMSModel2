package domain;

import lombok.Data;

@Data
public class ProjectTeamBean {
	private String teamId, teamName;

	@Override
	public String toString() {
		return "ProjectTeamBean"
				+ "\n teamId=" + teamId
				+ "\n teamName=" + teamName;
	}
}
