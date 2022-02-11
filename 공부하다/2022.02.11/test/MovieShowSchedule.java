package test;

public class MovieShowSchedule {

	private int movieNo;
	private String movieName;
	private String showDate;
	private int hallNo;
	private String hallName;
	private String startTime;
	private String endTime;
	
	public MovieShowSchedule() {}
	
	public MovieShowSchedule(int movieNo, String movieName, String showDate, int hallNo, String hallName, String startTime,
			String endTime) {
		super();
		this.movieNo = movieNo;
		this.movieName = movieName;
		this.showDate = showDate;
		this.hallNo = hallNo;
		this.hallName = hallName;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
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
	
}
