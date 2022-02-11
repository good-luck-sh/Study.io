package test;

import java.util.ArrayList;
import java.util.List;

public class Dto {

	private int no;
	private String name;
	private String showDate;
	private int hallNo;
	private String hallName;
	private List<TimeTable> timeTables = new ArrayList<TimeTable>();
	
	public Dto() {}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShowDate() {
		return showDate;
	}
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
	public int getHallNo() {
		return hallNo;
	}
	public void setHallNo(int hallNo) {
		this.hallNo = hallNo;
	}
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	public List<TimeTable> getTimeTables() {
		return timeTables;
	}

	@Override
	public String toString() {
		return "Dto [name=" + name + ", showDate=" + showDate + ", hallName="
				+ hallName + timeTables + "]";
	}
	
}
