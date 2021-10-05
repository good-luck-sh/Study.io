package example_10_05_2_generic;

/**
 * 제네릭 클래스다 <br/>
 * T의 자리에 지정할 수 있는 타입은 Phone과 Phone의 하위타입만 가능하다.<br/>
 * 타입파라미터의 타입은 특정타입으로 제한한다.
 * @author 김승희
 *
 * @param <T>
 */
public class PhoneGenericBox<T extends Phone> { //폰의 하위타입만 지정할 수 있음


	private T item;
	
	public void setItem(T item) {
		this.item = item;
	}

	public T gerItem() {
		return item;
	}
}
