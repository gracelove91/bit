package study0528.ch7;
interface EE{}
public class InnerEx2 {
	class InstanceInner implements EE{}			//인스턴스 내부 클래스.
	static class StaticInner implements EE{}		//스태틱 내부 클래스.
	
	//인스턴스멤버 간에는 서로 직접 접근이 가능하다.
	InstanceInner iv = new InstanceInner();
	
	//static 멤버 간에는 서로 직접 접근이 가능하다.
	static StaticInner cv = new StaticInner();
	
	EE ee1 = cv;
	EE ee2 = iv;
}
