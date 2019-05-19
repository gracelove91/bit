package day07;

public class FighterTest {
	public static void main(String[] args) {
		Fighter f = new Fighter();
	
		if(f instanceof Unit2) {
			System.out.println("해당 참조변수는 Unit을 상속받았습니다.");
		}
		
		if(f instanceof Fightable) {
			System.out.println("해당 참조변수는 Fightable을 구현했습니다.");
		}
		
		if(f instanceof Moveable) {
			System.out.println("해당 참조변수는 Moveable을 구현했습니다.");
		}
		
		if(f instanceof Attackable) {
			System.out.println("해당 참조변수는 Attackable을 구현했습니다.");
		}
	}
}
class Fighter extends Unit2 implements Fightable{
	@Override
	public void attack(Unit2 u) {
		
	}
	@Override
	public void move(int x, int y) {
		
	}
}
class Unit2{
	int currentHP;
	int x;
	int y;
	
}
interface Fightable extends Moveable, Attackable{}

interface Moveable{ 
	void move(int x, int y); 
}

interface Attackable{ 
	void attack(Unit2 u); 
}
