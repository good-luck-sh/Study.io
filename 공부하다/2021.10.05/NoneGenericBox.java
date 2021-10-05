package example_10_05_1_generic;


/**
 * 제네릭을 사용하지 않는 Box 클래스다</br>
 * 모든 종류의 객체를 저장할 수 있다.</br>
 * 타입 안정성이 보장되지 않는다. </br>
 * 저장된 객체를 가져올 때 형변환 코드가 필요하다
 * @author 김승희
 *
 */
public class NoneGenericBox {

	private Object[] items = new Object[100];
	private int position = 0;
	
	
	/**
	 *객체를 전달받아서 박스의 배열에 저장한다. 
	 * @param item 저장할 객체
	 */
	public void addItem(Object item) {
		items[position] = item;
		position++;
	}
	
	/**
	 * 배열에서 지정된 인뎃그에 저장된 객체를 반환한다. 
	 * @param index 배열의 인덱스
	 * @return 저장된 객체 
	 */
	public Object getItem(int index) {
		return items[index];
	}
}
