package kr.co.jhta.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import kr.co.jhta.vo.Board;

public class BoardDao {

	List<Board> db = List.of(new Board(new Date().getTime(), "연습10", "홍길동","연습5입니다.", new Date()),
			new Board(new Date().getTime(), "연습9", "홍길동", "연습9입니다.", new Date()),
			new Board(new Date().getTime(), "연습8", "김유신", "연습8입니다.", new Date()),
			new Board(new Date().getTime(), "연습7", "강감찬", "연습7입니다.", new Date()),
			new Board(new Date().getTime(), "연습6", "이순신", "연습6입니다.", new Date()),
			new Board(new Date().getTime(), "연습5", "류관순", "연습5입니다.", new Date()),
			new Board(new Date().getTime(), "연습4", "강감찬", "연습4입니다.", new Date()),
			new Board(new Date().getTime(), "연습3", "이순신", "연습3입니다.", new Date()),
			new Board(new Date().getTime(), "연습2", "김유신", "연습2입니다.", new Date()),
			new Board(new Date().getTime(), "연습1", "홍길동", "연습1입니다.", new Date()));
		
	public void inser(Board board) {
			db.add(board);
	}
	
	public List<Board> findAll(){
		return db;
	}
	public Board findByNo(long no) {
		for(Board board : db) {
			if(board.getNo() == no) {
				return board;
			}
		}
		return null;
	}
	
	public void deleteByNo(long no) {
		Iterator<Board> iter = db.iterator();
		//지우는 iterate를 사용한다. 
		while(iter.hasNext()) {
			Board board = iter.next();
			if(board.getNo() == no) {
				iter.remove();
				break;
			}
		}
	}
}
