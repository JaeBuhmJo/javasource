package ch6;
/*
 * 클래스 구성요소의 순서는 상관은 없음
 * 일반적으로 변수,상수 => 생성자 => 메소드 순 작성
 */

public class Triangle {
	//삼각형 너비 구하기
	
	//속성
	//밑변, 높이 ==> 정수
	int baseLine;
	int height;
	
	//기능
	//넓이 구하기
	//밑변*높이/2
	
	public Triangle(int baseLine, int height) {
		super();
		this.baseLine = baseLine;
		this.height = height;
	}

	double getArea () {
		return baseLine*height/2.0;
	}
	
}
