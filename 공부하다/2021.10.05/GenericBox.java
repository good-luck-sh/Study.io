package example_10_05_1_generic;

/**
 * 제네릭이 적용된 클래스이다.</br>
 * T는 타입파라미터이다. </br>
 * 멤버메소드에서 구체적인 타입을 지정하지 않고, 대신 별칭(타입파라미터)을 사용했다.</br>
 * 
 * @author 김승희
 *
 * @param <T>
 */
public class GenericBox<T> {

	//T[] items = new T[100];//이렇게 만들수 없다. 
	private Object[] items = new Object[100];//담을때는 이렇게 작성해야함
	private int position = 0;
	
	/**
	 * 객체를 전달받아서 배열에 저장한다.
	 * @param item 객체생성할 때 지정한 타입의 객체를 전달받는다.
	 */
	public void addItem(T item) {//Object대신에 T를 작성함.
		items[position] = item;
		position++;
	}
	
	/**
	 * 배열에서 지정된 인덱스에 저장된 객체를 반환한다. 
	 * @param index 조회할 인덱스
	 * @return 저장된 객체
	 */
	@SuppressWarnings("unchecked")
	public T getItem(int index) { //Object대신에 T를 작성함
		Object obj = items[index]; //None에서는 items[index]를 return했지만, Object로 넣었다. 
		return(T)obj; //obj를 T로 형변환 했다.
	}
}
