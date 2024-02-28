package neew.example.newproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Department")
@Entity
public class Department {

	@SuppressWarnings("deprecation")
	@Id
	
	private long id;
	
	
	private String deptName;

//	@OneToOne
//	@PrimaryKeyJoinColumn()
//	private Empoyee employee;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

//	public Empoyee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Empoyee employee) {
//		this.employee = employee;
//	}

}
