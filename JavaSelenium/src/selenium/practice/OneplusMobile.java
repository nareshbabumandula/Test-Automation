package selenium.practice;

public class OneplusMobile extends Mobile{

	public static void main(String[] args) {
		OneplusMobile om = new OneplusMobile();
		System.out.println("Common Features For All The Mobiles :\n");
		om.Network();
		om.Display();
		om.Battery();
		System.out.println("\nOneplus Mobile Features :\n");
		om.Camera();
		om.FastCharging();
		om.Processor();
	}

	@Override
	public void FastCharging() {
		System.out.println("It Contains 60W Fast Charging Technology.");
	}

	@Override
	public void Camera() {
		System.out.println("It Conntains 64MP Front and 32MP Rear Camera.");
	}

	@Override
	public void Processor() {
		System.out.println("It Contains Snapdragon 8Gen1 Processor.");
		
	}

}
