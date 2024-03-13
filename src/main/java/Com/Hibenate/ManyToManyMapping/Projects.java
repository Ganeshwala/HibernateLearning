package Com.Hibenate.ManyToManyMapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Projects {

	@Id
	private int projectId;

	private String prjectName;

	private double projectCost;

	@ManyToMany
	@JoinTable(
			name = "EmployeeProjectTable", 
			joinColumns = { @JoinColumn(name = "projectIds") }, 
			inverseJoinColumns = {@JoinColumn(name = "employeeId") }
			)
	private List<Employee> empl;

	public Projects() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Projects(int projectId, String prjectName, double projectCost, List<Employee> empl) {
		super();
		this.projectId = projectId;
		this.prjectName = prjectName;
		this.projectCost = projectCost;
		this.empl = empl;
	}

	public List<Employee> getEmpl() {
		return empl;
	}

	public void setEmpl(List<Employee> empl) {
		this.empl = empl;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getPrjectName() {
		return prjectName;
	}

	public void setPrjectName(String prjectName) {
		this.prjectName = prjectName;
	}

	public double getProjectCost() {
		return projectCost;
	}

	public void setProjectCost(double projectCost) {
		this.projectCost = projectCost;
	}

}
