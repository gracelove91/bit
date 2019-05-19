package day06;

class Product{
	int price;
	int bonusPoint;
	
	Product(int price){
		this.price = price;
		this.bonusPoint = (int)(price / 10);
	}
}
class Tv extends Product{
	Tv(){
		super(100);
	}
	public String toString() {
		return "Tv";
	}
}
class Computer extends Product{
	Computer(){
		super(200);
	}
	public String toString() {
		return "Computer";
	}
}
class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	Product[] item = new Product[10];
	int i = 0;
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println(p+"를 살 잔고가 부족합니다.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item[i++] = p;
	}
	
	void info() {
		int sum = 0;
		String itemList = "";
		for(int i = 0; i < item.length; i++) {
			if(item[i] == null) break;
			
			sum += item[i].price;
			itemList += item[i].toString() + ", ";
			
		}
		System.out.println("잔고 : "+money);
		System.out.println("보너스포인트  : "+bonusPoint);
		System.out.println("구매목록 : " +itemList);
		System.out.println("총 금액 : "+sum);
	}
}
public class PolyArgumentTest {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		b.info();
	}
}

