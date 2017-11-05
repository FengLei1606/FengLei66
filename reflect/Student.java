package fl.reflect;

public class Student {
	
	private String name;
	private int id;
	private String sex;
	private String professional;
	public Student() {
		super();
	}
	public Student(String name, int id, String sex, String professional) {
		super();
		this.name = name;
		this.id = id;
		this.sex = sex;
		this.professional = professional;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String toString() {
		return "Student [name=" + name + ", Id=" + id + ", sex=" + sex
				+ ", professional=" + professional + "]";
	}
	
	//靜態方法
	public static void printInfo(){
		System.out.print("這是一個靜態方法，用來模擬靜態方法被反射調用");
	}

	
}
