package com.sample.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @Target : 어노테이션 적용대상 ElementType.PARAMETER은 메소드나 생성자의 매개변수에 부착할 수 있는 어노테이션임을 나타낸다. 
 * @Retention: 어노테이션 유지정책 RetentionPolicy.RUNTIME은 이어노테이션이 프로그램실행싯점까지 유지됨을 나타낸다. 
 */
@Target(ElementType.PARAMETER) //엘리먼트타입으로 매개변수에 붙일 수 있다. 현재는 구성요소가 없다. 
@Retention(RetentionPolicy.RUNTIME)//언제까지 유지될 것인지 작성해줘야한다.
public @interface LoginedUser {

}
