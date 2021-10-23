package example_10_23_board.service;

import java.sql.SQLException;
import java.util.List;

import example_10_23_board.dao.BoardDao;
import example_10_23_board.dao.BoardJdbcDao;
import example_10_23_board.exception.BoardException;
import example_10_23_board.vo.Board;


public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao = new BoardJdbcDao();

	@Override
	public List<Board> getAllPrint() throws SQLException {
		List<Board> boards = boardDao.getAllPrint();
		if(boards.isEmpty()) {
			throw new BoardException("[### 오류] 게시물의 입력값이 존재하지 않습니다.");
		} else {
			return boards;
		}
		
	}

	@Override
	public void addBord(String title, String writer, String content, int password) throws SQLException {
		boardDao.insertBoard(title, writer, content, password);
	}


	@Override
	public void reviseBoard(int no, String title, String content, int password) throws SQLException {
		Board findBoard = boardDao.getDetailPrintByNo(no);
		System.out.println(findBoard.getNo());
			System.out.println(password);
			System.out.println(findBoard.getPassword());
			if(findBoard.getPassword() == password) {
				findBoard.setTitle(title);
				findBoard.setContent(content);
				boardDao.updateBoard(findBoard);
			} else {
				throw new BoardException("[오류]");
		}
		}


	@Override
	public void removeBoard(int no, int password) throws SQLException {
		boardDao.removeBoard(no, password);
		
	}

	@Override
	public List<Board> getDetatilPrintByTitle(String title,int likeCount, int disLikeCount) throws SQLException {
		List<Board> boards = boardDao.getDetailPrintByTitle(title);
			for(Board board : boards) {
				goodOrBadCount(board.getNo(), likeCount, disLikeCount);
			
		}
			return boards;
	}


	@Override
	public Board getDetatilPrintByNo(int no,int likeCount, int disLikeCount) throws SQLException {
		Board board = boardDao.getDetailPrintByNo(no);
		goodOrBadCount(no, likeCount, disLikeCount);
		System.out.println(board.getPassword());
		return board;
		}

	@Override
	public void goodOrBadCount(int no, int likeCount, int disLikeCount) throws SQLException{
		Board findBoard = boardDao.getDetailPrintByNo(no);


		int goodCount= findBoard.getLikeCount() + likeCount;
		int unlikeCount = findBoard.getDisLikeCount() + disLikeCount;
		
		findBoard.setLikeCount(goodCount);

		
		findBoard.setDisLikeCount(unlikeCount);
		boardDao.updateBoard(findBoard);
	

		if(unlikeCount >= 5) {
			findBoard.setTitle("*************************");
			boardDao.updateBoard(findBoard);
		}
		
	} 


}
