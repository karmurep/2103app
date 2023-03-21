package in.yash.dailystatusupdateapp.modal;

public class Task {
	private int id;
	private String task;
	private String duedate;
	private int userid;
	private String status;
		
	@Override
	public String toString() {
		return "Task [id=" + id + ", task=" + task + ", duedate=" + duedate + ", userid=" + userid + ", status="
				+ status + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
