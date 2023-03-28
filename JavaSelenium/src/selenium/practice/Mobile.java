package selenium.practice;

public abstract class Mobile {
	
	public void Network() {
		System.out.println("This Mobile Should Have 5G Network.");
	}
	
	public void Display() {
		System.out.println("This Mobile Should Contain AMOLED Display.");
	}
	
	public void Battery() {
		System.out.println("This Mobile Should Contain 5000mah Battery Capacity.");
	}
	
	public abstract void FastCharging();
	
	public abstract void Camera();
	
	public abstract void Processor();

}
