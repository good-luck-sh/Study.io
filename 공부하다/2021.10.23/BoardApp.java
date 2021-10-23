package example_10_23_board.app;

import static utils.KeyboardUtil.*;

import java.sql.SQLException;
import java.util.List;

import example_10_23_board.exception.BoardException;
import example_10_23_board.service.BoardService;
import example_10_23_board.service.BoardServiceImpl;
import example_10_23_board.vo.Board;

public class BoardApp {

	private static BoardService boardService = new BoardServiceImpl();
	
	public void menuDisplay() {
		try{
			
			System.out.println("----------------------------------------------------------");
			System.out.println("1. 전체 조회  2.상세 조회 3. 등록하기 4. 수정하기  5. 삭제하기  0.종료");
			System.out.println("----------------------------------------------------------");
			System.out.println("메뉴 번호 입력 : ");
			int menuNumber = readInt();
			if(menuNumber == 1) {
				getAllPrint();
			} else if(menuNumber == 2) {
				getDetailPrint();
			} else if(menuNumber == 3) {
				addBoard();
			} else if(menuNumber == 4) {
				reviseBoard();
			} else if(menuNumber == 5) {
				removeBoard();
			} else if(menuNumber == 0) {
				systemClose();
			}
			
		} catch (SQLException ex) {
			System.out.println("[### 오류 ] 오류가 발생했습니다.");
			ex.printStackTrace();
		
		} catch (BoardException ex) {
			System.out.println("[### 오류 ] 입력상의 오류가 발생했습니다.");
			ex.printStackTrace();
		}
		menuDisplay();
	}
	public static void getAllPrint() throws SQLException {
		System.out.println("[전체 게시글 조회 기능]");
		System.out.println("전체 게시글을 조회합니다. ");
		List<Board> boaders = boardService.getAllPrint();
		BoardAllPrint(boaders);
		System.out.println( );
	}
	private static void BoardAllPrint(List<Board> boaders) {
		for(Board boader : boaders) {
			printconentBoard(boader);
		}
	}
	private static void printconentBoard(Board boader) {
		System.out.print("게시물 번호 : " + boader.getNo());
		System.out.print("게시물 제목 : " + boader.getTitle());
		System.out.print("게시물 작성자 : " + boader.getWriter());
		System.out.print("게시물 내용 : " + boader.getContent());
		System.out.print("게시물 좋아요 개수 : " + boader.getLikeCount() +" 게시물 싫어요 : " + boader.getDisLikeCount());
		System.out.println(" 게시물 입력일 : " + boader.getCreatedDate());
		System.out.println(" ---------------------------------------- ");
	}
	public static void getDetailPrint() throws SQLException {
		System.out.println("[상세정보 조회]");
		// 좋아요/ 싫어요 기능도 구현
		System.out.println("1. 게시물 번호로 검색 2. 게시물 제목으로 검색 ");
		int searchNumber = readInt();
		if(searchNumber == 1 ) {
			System.out.println("[게시물 번호로 검색]");
			System.out.println("[게시물 번호를 입력하세요]");
			int boardNo = readInt();
			System.out.println("[이 게시물의 평가를 원합니다.]");
			System.out.println("[1. 좋아요 2. 싫어요  ]");
			int likeUnLike = readInt(); 
			if(likeUnLike == 1) {
				int like = 1;
				int unLike = 0;
				Board board = boardService.getDetatilPrintByNo(boardNo,like,unLike);
				printconentBoard(board);
				System.out.println("좋아요가 1개가 추가 되었습니다. ");
			} else if(likeUnLike == 2) {
				int like = 0;
				int unLike = 1;
				Board board = boardService.getDetatilPrintByNo(boardNo,like,unLike);
				printconentBoard(board);
				System.out.println("싫어요가 1개가 추가 되었습니다. ");
			} 
		} else if(searchNumber == 2 ) {
			System.out.println("[게시물 제목로 검색]");
			System.out.println("[게시물 제목를 입력하세요]");
			String boardTitle = readString();
			System.out.println("[이 게시물의 평가를 원합니다.]");
			System.out.println("[1. 좋아요 2. 싫어요  ]");
			int likeUnLike = readInt(); 
			if(likeUnLike == 1) {
				int like = 1;
				int unLike = 0;
				List<Board> boaders = boardService.getDetatilPrintByTitle(boardTitle, like, unLike);
				BoardAllPrint(boaders);
			} else if(likeUnLike == 2) {
				int like = 0;
				int unLike = 1;
				List<Board> boaders = boardService.getDetatilPrintByTitle(boardTitle, like, unLike);
				BoardAllPrint(boaders);
			} 
			
		} else {
			new BoardApp().menuDisplay();
		}
		
	}
	public static void addBoard() throws SQLException {
		System.out.println("[게시물 등록 기능]");
		System.out.println("제목 입력 : ");
		String title = readString();
		
		System.out.println("작성자 이름 입력 : ");
		String writer = readString();

		System.out.println("내용 입력 : ");
		String content = readString();
		
		System.out.println("비밀 번호 입력 : ");
		int password = readInt();
		
		boardService.addBord(title, writer, content, password);
		System.out.println("등록이 완료되었습니다.");
	}
	public static void reviseBoard() throws SQLException {
		System.out.println("[게시물 수정 기능]");
		System.out.println("게시물의 번호 입력 :");
		int no = readInt();
		System.out.println("게시물의 비밀번호 입력 :");
		int password = readInt();
		System.out.println("수정할 제목 입력 :");
		String title = readString();
		System.out.println("수정할 내용 입력 :");
		String content = readString();
		
		boardService.reviseBoard(no, title, content, password);
		System.out.println("수정이 완료되었습니다. ");
		
	}
	public static void removeBoard() throws SQLException {
		System.out.println("[게시물 삭제 기능]");
		System.out.println("게시물의 번호 입력 : ");
		int no = readInt();
		System.out.println("비밀번호 입력 : ");
		int password = readInt();
		
		boardService.removeBoard(no, password);
		System.out.println("삭제 완료되었습니다.");
	}
	
	public static void systemClose() throws SQLException {
		System.out.println("[시스템 종료]");
		System.exit(0);
	}
	public static void main(String[] args) {
		new BoardApp().menuDisplay();
	}
}
