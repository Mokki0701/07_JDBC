package pracice.dept.model.dto;

public class Person {
	
	private String empId;
	private String empName;
	private String phone;
	private String deptTitle;
	private String locationId;
	
	public Person() {}
	
	public Person(String empId, String empName, String phone, String deptTitle, String locationId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.phone = phone;
		this.deptTitle = deptTitle;
		this.locationId = locationId;
	}
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeptTitle() {
		return deptTitle;
	}

	public void setDeptTitle(String deptTitle) {
		this.deptTitle = deptTitle;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "Person [empId=" + empId + ", empName=" + empName + ", phone=" + phone + ", deptTitle=" + deptTitle
				+ ", locationId=" + locationId + "]";
	}
	
	
	
}
