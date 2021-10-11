package homework;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class FileUtils {

	/**
	 * 지정된 일정정보들을 파일에 저장한다.
	 * @param todos 일정정보
	 */
	public static void save(Set<Todo> todos) {
		try (PrintWriter out = new PrintWriter(new File("todos.save"), "utf-8")){
			StringBuilder sb = new StringBuilder();
			for (Todo todo : todos) {
				sb.append(todo.getNo() + ":");
				sb.append(todo.getTitle() + ":");
				sb.append(todo.getWriter() + ":");
				sb.append(todo.getText() + ":");
				sb.append(DateUtils.dateToString(todo.getDueDate()) + ":");
				sb.append(todo.getStatus() + ":");
				sb.append(DateUtils.dateToString(todo.getCreatedDate()) + ":");
				sb.append(DateUtils.dateToString(todo.getCompletedDate()) + ":");
				sb.append(DateUtils.dateToString(todo.getUpdateDate()) + ":");
				sb.append(DateUtils.dateToString(todo.getDeletedDate()));
				
				out.println(sb.toString());
				sb.setLength(0);
			}
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}	
	}
	
	public static TreeSet<Todo> load() {
		TreeSet<Todo> todos = new TreeSet<>();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream("todos.save"), "utf-8"));
			String line = null;
			while ((line = in.readLine()) != null) {
				String[] items = line.split(":");
				
				int no = Integer.parseInt(items[0]);
				String title = items[1];
				String writer = items[2];
				String text = items[3];
				Date dueDate = new Date();
				String status = items[5];
				Date createdDate = new Date();
				Date completedDate = new Date();
				Date updatedDate = new Date();
				Date deletedDate = new Date();
				
				Todo todo = new Todo(no, title, writer, text, dueDate, status, createdDate, completedDate, updatedDate, deletedDate);
				todos.add(todo);
			}
			return todos;
		} catch (IOException ex) {
			throw new RuntimeException(ex);			
		} finally {
			try {
				in.close();
			} catch (IOException e) {
			}
		}
	}
}
