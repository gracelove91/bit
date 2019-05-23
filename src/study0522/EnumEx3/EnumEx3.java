package study0522.EnumEx3;

enum Transportation{
	BUS(100){
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	},
	TRAIN(150){
		int fare(int distance) {
			
		}
	},
	SHIP(100){
		
	},
	AIRPLANE(300){
		
	}
	
	protercted final int BASIC_FARE;
	
	Transportation(int basicFare){
		BASIC_FARE = basicFare;
	}
	
	public int getBasicFare() {
		return BASIC_FARE;
	}
	abstract int fare(int distance);
	
	
}
public class EnumEx3 {

}
