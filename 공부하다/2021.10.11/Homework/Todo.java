package homework;


import java.util.Date;

public class Todo implements Comparable<Todo> {
	private int no;					// 일정번호
	private String title;			// 일정제목
	private String writer;			// 작성자
	private String text;			// 내용
	private Date dueDate;			// 예정일자
	private String status;			// 일정상태(등록, 완료, 삭제 중 하나)
	private Date createdDate;		// 등록일자
	private Date completedDate;		// 완료일자
	private Date updateDate;		// 변경일자(일정정보가 마지막으로 변경된 날짜)
	private Date deletedDate;		// 삭제일자
	
	public Todo() {}
	
	/**
	 * 신규 일정을 생성한다.
	 * @param title 제목
	 * @param writer 작성자
	 * @param text 내용
	 * @param dueDate 예정일자
	 */
	public Todo(String title, String writer, String text, Date dueDate) {
		this.title = title;
		this.writer = writer;
		this.text = text;
		this.dueDate = dueDate;
		this.status = "등록";
		this.createdDate = new Date();
	}
	
	public Todo(int no, String title, String writer, String text, Date dueDate, String status, Date createdDate,
			Date completedDate, Date updateDate, Date deletedDate) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.text = text;
		this.dueDate = dueDate;
		this.status = status;
		this.createdDate = createdDate;
		this.completedDate = completedDate;
		this.updateDate = updateDate;
		this.deletedDate = deletedDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}
	
	public void printSimpleTodo() {
		System.out.print(no + "\t");
		System.out.print(writer + "\t");
		System.out.print("["+status+"]" + "\t");
		System.out.print(DateUtils.dateToString(dueDate) + "\t");
		System.out.println(title);
	}
	
	public void printTodo() {
		System.out.println("일정번호: " + no);
		System.out.println("제   목: " + title);
		System.out.println("작 성 자: " + writer);
		System.out.println("예 정 일: " + DateUtils.dateToString(dueDate));
		System.out.println("상   태: " + status);
		System.out.println("내   용: " + text);
		System.out.println("수 정 일: " + DateUtils.dateToString(updateDate));
		System.out.println("완 료 일: " + DateUtils.dateToString(completedDate));
		System.out.println("삭 제 일: " + DateUtils.dateToString(deletedDate));
	}
	
	@Override
	public int compareTo(Todo o) {
		return o.getNo() - this.no;
	}
	
}
