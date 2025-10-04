package strategyPattern;

public class LongShoot implements ShootStrategy{

	@Override
	public void shoot() {
		System.out.println("길게 슛!!!");
	}
}
