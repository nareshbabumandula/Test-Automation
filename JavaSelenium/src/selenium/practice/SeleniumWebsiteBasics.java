package selenium.practice;

public class SeleniumWebsiteBasics {
	
	void openBrowser() {
		
		System.out.println("Opened Chrome Browser.");
		
	}
	
	void accessingSite() {
		
		System.out.println("Accessed Amazon Site.");
		
	}
	
	void searchProduct(String name) {
		
		System.out.println("Searched 'TV' Product in the search bar." + name);
		
	}
	
	void selectProduct() {
		
		System.out.println("Selected a Model/Company.");
		
	}
	
	void closeBrowser() {
		
		System.out.println("closed Chrome Browser");
		
	}

	public static void main(String[] args) {
		SeleniumWebsiteBasics web = new SeleniumWebsiteBasics();
		web.openBrowser();
		web.accessingSite();
		web.searchProduct("TV");
		web.selectProduct();
		web.closeBrowser();
		

	}

}
