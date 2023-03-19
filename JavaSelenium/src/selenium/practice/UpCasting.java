package selenium.practice;

public class UpCasting extends UpNDownCasting {
	String apn = "Facebook";
	String browser = "Chrome";
	public void Browser() {
		System.out.println("The app " + apn + " can be used in " + browser);
	}
	public void Applications() {
		String appNames = "Twitter, Instagram, Snapchat, TikTok, ShareChat.\n";
		System.out.println("The Social Media Apps are :" + appNames);
	}

	public static void main(String[] args) {
	//Creating an Object for DownCastng Class
		UpCasting c = new UpCasting();
		System.out.println(c.apn);
		System.out.println(c.browser);
		c.Browser();
		c.Applications();
		
		UpNDownCasting up = new UpCasting();
		System.out.println(up.apn);
		System.out.println(up.browser);
		up.Browser();
		up.Applications();
		up.SpecificApp(" Whatsapp");
	}

}
