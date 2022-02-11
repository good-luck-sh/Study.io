package test;

public class TimeTable {

	private String startTime;
	private String endTime;
	
	public TimeTable() {}
	
	public TimeTable(String startTime, String endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "[startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
}
