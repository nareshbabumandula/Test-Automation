package selenium.practice;

public class DownCasting extends UpNDownCasting {
	String apn = "Instagram";
	String browser = "Edge";
	public void Browser() {
		System.out.println("The app " + apn + " can be used in " + browser);
	}
	public void Applications() {
		System.out.println("Camera, Calculator, File Manager, Gallary, Youtube...");
	}
	public void BankingApps() {
		System.out.println("HDFC, SBI YONO, ICICI, BOB, AXIS...\n");
	}
	public static void main(String[] args) {
	//Creating an Object for DownCastng Class
		DownCasting c = new DownCasting();
		
		System.out.println(c.apn);
		System.out.println(c.browser);
		c.Browser();
		c.Applications();
		c.BankingApps();
	// DownCasting
		UpNDownCasting udc = new DownCasting();
		DownCasting dc = (DownCasting) udc;
		
		System.out.println(udc.apn);
		System.out.println(udc.browser);
		dc.Browser();
		dc.Applications();
		dc.BankingApps();
		dc.SpecificApp("AMAZON");
	}

}
