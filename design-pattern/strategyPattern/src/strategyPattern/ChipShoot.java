package strategyPattern;

public class ChipShoot implements ShootStrategy{

	@Override
	public void shoot() {
		System.out.println("골기퍼 넘기는 칩슛!!!");
	}
}
