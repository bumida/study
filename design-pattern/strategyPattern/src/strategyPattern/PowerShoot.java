package strategyPattern;

public class PowerShoot implements ShootStrategy{

	@Override
	public void shoot() {
		System.out.println("강하게 슛!");
	}
}
