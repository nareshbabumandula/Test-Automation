package practice;

   public class GenericDemo {
		
	    void browser() {
	        System.out.println("Opened chrome browser");
		}
	   
		void accessSite() {
		    System.out.println("Accessed flipcart Site");
		}
		
	    void signin1(String phonenumber) {
			System.out.println("Successfully signin1 with the phone number : " + phonenumber );
		}
	    
		void searchProduct(String product) {
			System.out.println("Searched the product : " + product);
		}
		
		void pricefliter ()  {
		    System.out.println("Applied the pricefliter: high to low");
		}
		
	    void wishlist() {
			System.out.println("Added the products to the wishlist");
	    }
	    
	    void addToCart() {
			System.out.println("Added the products to the cart");
	    }
	    
		void quantity() {
			System.out.println("Select quantity : 2");
	    }
		 
		void address() {
		    System.out.println("Select the address : hyderabad");
		}
		
		void coupon()  {
			System.out.println("Apply the coupon : FLIPCART300");
		}
		
	    void order() {
			System.out.println("Successfully placed the order");
		}
	    
	    void payment() {
			System.out.println("Payment type : cash on delivery");
		}
	    
	    void Deliverydate() {
	    	System.out.println("Deliverydate : Within 3 days");
	    }
	    
	    void logout() {
			System.out.println("Successfully logged out from the flipcart site");
	    }
	    	    
	    public static void main(String[] args){
			GenericDemo gen = new GenericDemo();
			gen.browser();
			gen.accessSite();
			gen.signin1("985698569");
			gen.searchProduct("watch");
			gen.pricefliter();
	        gen.wishlist();
	        gen.addToCart();
	        gen.quantity();
	        gen.address();
	        gen.coupon();
			gen.order();
	        gen.payment();
	        gen.Deliverydate();
			gen.logout();
						
		}
	    
	}

