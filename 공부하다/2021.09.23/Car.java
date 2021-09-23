package example_09_23_interface;
/**
 * 모든 자동차 객체가 반드시 포함할 기능을 정의하는 인터페이스다 <br/>
 * 모든 자동차는 출발, 정지, 속도변경, 속도조회 기능이 있어야한다.
 * @author 김승희
 *
 */
public interface Car { //모든자동차객체가 반드시 포함할 기능을 작성해 놓음, 이 기능이 없는건 자동차가 아님
	
	//상수 정의하기 
	//*상수는 변하지 않는 값의 저장소다.  
	//*상수는 public static final키워드를 포함한다. 
	//*상수의 이름은 전부 대문자로 쓰고, 두 단엉 이상일 때는 _를 중간에 삽입한다. 
	//*인터페이스에서는 public static final를 생략할 수 있다. 
	//최저속도는 0과 최고속도는 200으로 차량속도가 정해져있다고 할 떄,static과 final로 구현함, 자바 8이전에는 정의할 수 없었다. 
	//public static final은 꼭 안붙여도 됨. 자동으로 붙는것. 
	/*public static final */int MIN_SPEED = 0;
	public static final int MAX_SPEED = 200;
	//공개되어 있는 공통의 클래식 변수면서 상수다. 

	//구현부가 없는 추상메소드 정의하기 
	//*추상메소드는 구현부가 없는 메소드이다. 
	//*추상메소드는 abstract키워드를 포함해야한다. 
	//*인터페이스에서는 public abstract를 생략할 수 있다.
	 // 이 인터페이스를 구현하는 구현클래스가 반드시 재정의할 기능을 추상메소드로 정의한다. 
	public abstract void start();//이게 추상메소드, 출발
	public abstract void stop();//정지
	/*public abstract*/ void speedUp(); //스피드 올림
	public abstract void speedDown(); //스피드내림
	public abstract int getCurrentSpeed(); //현재속도조회
	//인터페이스는 전부다 추상메소드이기 때문에 public abstract를 생략할 수 있다. 

}
