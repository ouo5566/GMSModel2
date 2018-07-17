package dao;

import java.util.ArrayList;
import java.util.List;
import domain.*;

public class ProjectTeamDAOImpl implements ProjectTeamDAO{
	private static ProjectTeamDAO instance = new ProjectTeamDAOImpl();
	public static ProjectTeamDAO getInstance() {return instance;}
	private ProjectTeamDAOImpl() {}
	@Override
	public void insertProjectTeam(ProjectTeamBean projectTeam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ProjectTeamBean> selectProjectTeamAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProjectTeamBean> selectByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProjectTeamBean selectById(ProjectTeamBean projectTeam) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String selectProjectTeamCount() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateProjectTeam(ProjectTeamBean projectTeam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteProjectTeam(ProjectTeamBean projectTeam) {
		// TODO Auto-generated method stub
		
	}

}
