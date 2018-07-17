package service;
import java.util.ArrayList;
import java.util.List;
import domain.*;

public class ProjectTeamServiceImpl implements ProjectTeamService{
	private static ProjectTeamService instance = new ProjectTeamServiceImpl();
	public static ProjectTeamService getInstance() {return instance;}
	private ProjectTeamServiceImpl() {}
	@Override
	public void createProjectTeam(ProjectTeamBean projectTeam) {
		
	}

	@Override
	public List<ProjectTeamBean> list() {
		List<ProjectTeamBean> list = new ArrayList<>();
		return list;
	}

	@Override
	public List<ProjectTeamBean> searchSome(String word) {
		List<ProjectTeamBean> result = new ArrayList<>();
		return result;
	}

	@Override
	public ProjectTeamBean searchOne(ProjectTeamBean projectTeam) {
		ProjectTeamBean result = new ProjectTeamBean();
		return result;
	}

	@Override
	public String projectTeamCount() {
		String result = "";
		return result;
	}

	@Override
	public void modifyProjectTeam(ProjectTeamBean projectTeam) {
		
	}

	@Override
	public void removeProjectTeam(ProjectTeamBean projectTeam) {
		
	}

}
