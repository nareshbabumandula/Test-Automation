package selenium.practice;

public class SamsungMobile extends Mobile {
	public static void main(String args[]) {
		SamsungMobile sm = new SamsungMobile();
		System.out.println("Common Features For All The Mobiles. :\n");
		sm.Network();
		sm.Display();
		sm.Battery();
		System.out.println("\nSamsung Mobile Specifications :\n");
		sm.Camera();
		sm.FastCharging();
		sm.Processor();
	}

	@Override
	public void FastCharging() {
		System.out.println("This Mobile Having 25W Fast Charging technology.");
	}

	@Override
	public void Camera() {
		System.out.println("This Mobile Having 50MP Front and 20MP Rear Camera.");
	}

	@Override
	public void Processor() {
		System.out.println("This Mobile Having Qualcomm Snapdragon 870 Processor.");
	}
}
