package study0521;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack extends Vector {
	/**
	 * 
	 * @param item 스택에 저장할 객체.
	 * @return item 반환한다.
	 */
	public Object push(Object item) {
		addElement(item);
		return item;
	}
	/**
	 * 
	 * @return 스택에서 마지막 객체를 꺼내고 반환한다. 반환된 객체는 스택에서 삭제된다.
	 */
	public Object pop() {
		Object obj = peek(); //스택이 비어있으면 peek()메서드가 EmptyStackException을 발생시킨다.
		removeElementAt(size() - 1);	//인덱스는 0부터시작이니까 -1 해준다.
		return obj;
	}
	/**
	 * 
	 * @return 스택에서 마지막 객체를 꺼내고 반환한다.
	 */
	public Object peek() {
		int len = size();
		if ( len == 0) {
			throw new EmptyStackException();
		}
		
		return elementAt(len - 1);	//마지막 요소를 반환한다. 인덱스는 0부터 시작.
	}
	/**
	 * 
	 * @return size()가 0이면 트루, 아니면 펄스 반환.
	 */
	
	public boolean empty() {
		return size() == 0;
	}
	/**
	 * 
	 * @param o  이것과 동일한 객체가 있는 지 비교할 객체. 
	 * @return	저장된 위치를 리턴해준다. 발견못했을 시 -1리턴.
	 */
	public int search(Object o) {
		int i = lastIndexOf(o);		//끝에서부터 객체를 찾는다.
		if(i >= 0) {
			return size() - i;	//스택은 맨 위에 저장된 객체의 index를 1로 정의하기 때문에 계산을 통해 구한다.
		}
		return -1;
	}
}
