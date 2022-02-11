package test;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<MovieShowSchedule> list = new ArrayList<MovieShowSchedule>();
		list.add(new MovieShowSchedule(100, "스파이더맨", "2월 10일", 1, "1관", "11시 00분", "13시 10분"));
		list.add(new MovieShowSchedule(100, "스파이더맨", "2월 10일", 1, "1관", "14시 00분", "16시 10분"));
		list.add(new MovieShowSchedule(100, "스파이더맨", "2월 10일", 1, "1관", "20시 00분", "22시 10분"));
		list.add(new MovieShowSchedule(100, "스파이더맨", "2월 10일", 2, "2관", "11시 00분", "13시 10분"));
		list.add(new MovieShowSchedule(100, "스파이더맨", "2월 10일", 2, "2관", "14시 00분", "16시 10분"));
		list.add(new MovieShowSchedule(100, "스파이더맨", "2월 10일", 3, "3관", "20시 00분", "12시 10분"));
		list.add(new MovieShowSchedule(101, "해적:도깨비 깃발", "2월 10일", 4, "4관", "9시 00분", "10시 40분"));
		list.add(new MovieShowSchedule(101, "해적:도깨비 깃발", "2월 10일", 4, "4관", "11시 10분", "12시 50분"));
		list.add(new MovieShowSchedule(101, "해적:도깨비 깃발", "2월 10일", 4, "4관", "13시 30분", "14시 10분"));
		list.add(new MovieShowSchedule(100, "스파이더맨", "2월 12일", 1, "1관", "10시 00분", "12시 10분"));
		list.add(new MovieShowSchedule(100, "스파이더맨", "2월 12일", 1, "1관", "17시 00분", "19시 10분"));
		list.add(new MovieShowSchedule(100, "스파이더맨", "2월 12일", 2, "2관", "22시 00분", "24시 10분"));
		
		
		List<Dto> result = new ArrayList<Dto>();
		
		for (MovieShowSchedule schedule : list) {
			System.out.println(result);
			Dto dto = getDto(result, schedule.getMovieNo(), schedule.getShowDate(), schedule.getHallNo());
			
			if (dto == null) {
				dto = new Dto();
				dto.setNo(schedule.getMovieNo());
				dto.setName(schedule.getMovieName());
				dto.setShowDate(schedule.getShowDate());
				dto.setHallNo(schedule.getHallNo());
				dto.setHallName(schedule.getHallName());
				
				result.add(dto);
			}
			TimeTable timeTable = new TimeTable(schedule.getStartTime(), schedule.getEndTime());
			dto.getTimeTables().add(timeTable);
		}
		
	}
	
	private static Dto getDto(List<Dto> result, int movieNo, String showDate, int hallNo) {
		for (Dto dto : result) {
			if (dto.getNo() == movieNo && dto.getHallNo() == hallNo && dto.getShowDate().equals(showDate)) {
				return dto;
			}
		}
		return null;
	}
}
