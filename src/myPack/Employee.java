package myPack;
public class Employee {
	//Declare DataMemebers to achieve Encapsulation
	private int eid;
	private String ename;
	private String emailid;
	private long phno;
	//Getters & Setters
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	//Constructor
	public Employee(int eid, String ename, String emailid, long phno) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.emailid = emailid;
		this.phno = phno;
	}
	//toString() :-Converts object to readable text
	//overRide-polymorphism concept
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", emailid=" + emailid + ", phno=" + phno + "]";
	}
}
