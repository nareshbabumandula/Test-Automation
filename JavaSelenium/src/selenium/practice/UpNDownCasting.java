package selenium.practice;

public class UpNDownCasting {
	String apn = "Whatsapp";
	String browser = "Safari";
	public void Browser() {
		System.out.println("The app " + apn + " can be used in " + browser);
	}
	public void Applications() {
		String appNames = "Whatsapp, Facebook, Amazon, Flipkart, Phonepay, Googlepay.";
		System.out.println("Frequently using apps are :" + appNames);
	}
	public  void SpecificApp(String app) {
		System.out.println("App that commonly used is " + app);
	}

}
