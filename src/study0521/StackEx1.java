package study0521;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 
 * @author govlmo91
 *	인터넷브라우져의 뒤로가기, 앞으로가기 구현.
 */
public class StackEx1 {
	public static Stack back = new Stack();
	public static Stack forward = new Stack();

	public static void main(String[] args) {
		
		List list = new ArrayList();
//		list.add(new Point(1,2));
//		list.add(new Point(2,3));
//		list.add(new Point(4,5));
		
		System.out.println(list);
	}
	//현재 back, forward 스택에 저장되어있는 객체를 출력해준다.
	public static void printStatus() {
		System.out.println("back : "+back);
		System.out.println("forward : "+forward);
		System.out.println("현재 화면은 '"+back.peek()+"' 입니다.");
		System.out.println();
	}
	//현재 사이트를 나타내는 건 back 스택의 맨 위. 그러니까 back 스택에 url을 넣어준다.
	//url을 입력해서 사이트를 이동하면, forward 스택은 비워준다.
	public static void goURL(String url) {
		back.push(url);
		if(!forward.empty()) forward.clear();
	}
	//앞으로 가기 구현.
	//forward가 비어져있지 않아야한다.
	//forward의 맨 위에 있는 값을 back스택으로 가져온다.
	
	public static void goForward() {
//		if(forward.empty()) throw new EmptyStackException();
		if(!forward.empty())
		back.push(forward.pop());
	}
	// 뒤로가기 구현.
	// 현재페이지는 back 스택의 맨 위다.
	// 뒤로 간 뒤 보여지는 페이지는 맨위에서 -1에 위치한다.
	// 그러므로 back 스택의 맨 위 요소를 forward로 push해준다.
	public static void goBack() {
//		if(back.empty()) throw new EmptyStackException();
		if(!back.empty())
		forward.push(back.pop());
	}
}
class Point{
	int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}