package example_10_01_system;

import java.util.Arrays;

public class SystemApp5 {

	public static void main(String[] args) {
		
		//배열 복사하기 
		//원본 배열
		int[] src = {10, 20, 30, 40, 50};
		//60, 70, 80을 추가해야할 경우 
		//배열 10개짜리를 만들어서 복사해서 넣어두는 것 
		//데이터는 언제나 가변적임 10 -> 20 복사해서 20으로 이동
		//String Builder와 Bufferr Buffer 복사하는 것처럼 복사함
		//원본 배열을 복사할 배열
		int[] dest = new int[10];
		/*
		 * System.arraycopy(Object[] src, int srcPos, Object[] dest, int destPos, int length);
		 * 			src : 원본배열
		 * 			srcPos : 원본배열부터 복사 시작위치 : 대부분이 시작위치가 0임
		 * 			dest : 대상 배열
		 * 			destPos : 대상 배열에 원본 배열이 저장될 위치 
		 * 			length : 대상 배열에 저장할 원본 배열의 데이터 길이 
		 */
		
		System.out.println("복사 전 대상배열 : "+Arrays.toString(dest));
		//원본 배열(src)의 0번부터 대상배열(dest)의 0번째 칸에 복사한다. 
		// 복사할 총 데이터 갯수는 원본배열의 모든 데이터이다. 
		System.arraycopy(src, 0, dest, 3, src.length);
		
		System.out.println("복사 후 대상배열 : "+Arrays.toString(dest)); // [10, 20, 30, 40, 50, 0, 0, 0, 0, 0]
		//인덱스 3부터 [0, 0, 0, 10, 20, 30, 40, 50, 0, 0]
		
	}
}
