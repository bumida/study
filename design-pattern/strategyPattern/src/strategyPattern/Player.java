package strategyPattern;

public class Player {
	private ShootStrategy strategy;

	public void setStrategy(ShootStrategy strategy) {
		this.strategy = strategy;
	}	
	public void shootBall() {
		strategy.shoot();
	}
}
