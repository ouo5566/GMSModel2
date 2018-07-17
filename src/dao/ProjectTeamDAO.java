package dao;
import java.util.List;
import domain.*;

public interface ProjectTeamDAO {
	public void insertProjectTeam(ProjectTeamBean projectTeam);
	public List<ProjectTeamBean> selectProjectTeamAll();
	public List<ProjectTeamBean> selectByWord(String word);
	public ProjectTeamBean selectById(ProjectTeamBean projectTeam);
	public String selectProjectTeamCount();
	public void updateProjectTeam(ProjectTeamBean projectTeam);
	public void deleteProjectTeam(ProjectTeamBean projectTeam);
}
