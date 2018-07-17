package service;
import java.util.List;
import domain.*;

public interface ProjectTeamService {
	public void createProjectTeam(ProjectTeamBean projectTeam);
	public List<ProjectTeamBean> list();
	public List<ProjectTeamBean> searchSome(String word);
	public ProjectTeamBean searchOne(ProjectTeamBean projectTeam);
	public String projectTeamCount();
	public void modifyProjectTeam(ProjectTeamBean projectTeam);
	public void removeProjectTeam(ProjectTeamBean projectTeam);
}
