package strategyPattern;

public class Main {
	public static void main(String[] args) {
		Player player = new Player();
		
		player.setStrategy(new PowerShoot());
		player.shootBall();// 강하게 슛!!
		
		player.setStrategy(new LongShoot());
		player.shootBall();// 멀리서 슛!
		
		player.setStrategy(new ChipShoot());
		player.shootBall();// 골기퍼 넘기는 칩슛!
	}
}
