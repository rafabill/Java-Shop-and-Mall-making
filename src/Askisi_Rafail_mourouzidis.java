/**
 * 
 */
/**
 * @author rafas
 *
 */
import java.util.Scanner;


class Shop{
	//properties of shop Class
	public String name;
	public int years;
	public int revenue;
	public boolean eshop = false;
	private int numOfEmployee = 0;
	public String[] employee;
	//Simple Constructor 
	public Shop (String name, int years) {
		this.name = name;
		this.years = years;
	}
	//Complex Constructor
	public Shop (String name, int years, int revenue, boolean eshop) {
		this.name = name;
		this.years = years;
		this.revenue = revenue;
		this.eshop = eshop;
	}
	//get name of shop
	public void getName () {
		System.out.println("to onoma tou magaziou einai " + this.name);
	}
	//set name of shop
	public void setName(String name) {
		this.name = name;
	}
	//get years of shop
	public void getYears () {
		System.out.println("to magazi leitoyrgei  " + this.years + " xronia");
	}
	//set years of shop
	public void setYears(int years) {
		this.years = years;
	}
	//get revenue of shop
	public void getRevenue () {
		System.out.println("to magazi exei eisodima" + this.revenue + " eyrw");
	}
	//set revenue of shop
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	//get Eshop of shop
	public void getEshop () {
		if (this.eshop) {
			System.out.println("to magazi exei eshop");
		} else {
			System.out.println("to magazi den exei eshop");
		}
	}
	//set Eshop of shop
	public void setEshop(boolean shop) {
		this.eshop = shop;
	}
	//add an employee
	public void addEmployee(String employee) {
		this.employee[this.numOfEmployee] = employee;
		this.numOfEmployee++;
	}
	//Get Array of employees
	public String[] getEmployees() {
		for(int i = 0; i<=this.numOfEmployee; i++) {
			System.out.println(this.employee[i]);
		}
	}
	//print all properties
	public void show() {
		System.out.println("to onoma tou magaziou einai " + this.name);
		System.out.println("to magazi leitoyrgei  " + this.years + " xronia");
		System.out.println("to magazi exei eisodima" + this.revenue + " eyrw");
		if (this.eshop) {
			System.out.println("to magazi exei eshop");
		} else {
			System.out.println("to magazi den exei eshop");
		}
		System.out.println("To magazi exei tous parakatw ypallhlous:");
		for(int i = 0; i<this.numOfEmployee; i++) {
			System.out.println(this.employee[i]);
		}
	}
}
//mall class that inherits properties from Shop class
class Mall extends Shop{
	//properties of Mall class
	public int numOfShops = 0;
	public String[] shops;
	public Shop[] shop;
	//Super Constructor
	public Mall(String name, int years) {
		super(name, years);
	}
	public Mall(String name, int years, int revenue, boolean eshop) {
		super(name, years, revenue, eshop);
	}
	//return number of Shops
	public int getShopsNum() {
		return this.shops.length;	
	}
	//set a shop object
	public void addShop(Shop newShop) {
		this.shop[this.numOfShops] = newShop;
		this.numOfShops++;
	}
	//get the oldest working shop of the Mall
	public int getOldestShopYears() {
		int max = this.shop[0].years;
		for(int i = 0; i<this.shop.length; i++) {
			if (max < this.shop[i].years) {
				max = this.shop[i].years;
			}
		}
		return max;
	}
	//Show Mall info
	public void show() {
		System.out.println("To mall onomazetai "+ this.name);
		System.out.println("To mall leitoyrgei "+ this.years);
		System.out.println("to mall exei eisodima " + this.revenue);
		if (this.eshop) {
			System.out.println("to mall exei eshop");
		} else {
			System.out.println("to mall den exei eshop");
		}
		this.shops = new String[this.shop.length];
		System.out.println("To polykatasthma exei ta parakatw katasthmata : ");
		for(int i = 0; i<shop.length; i++) {
			this.shops[i] =  this.shop[i].name;
			System.out.println(this.shops[i]);
		}
	}
}
class ShopProgram{
	public static void main(String[] args) {
	//Declaring variables
		try (var input = new Scanner(System.in)) {
		
			String name, employee;
			
			int years, revenue, numOfEmployee;
			boolean eshop;
			//asking user the number of shops
			System.out.println("Dwse ari8mo katasthmatwn\n");
			int numOfShops = input.nextInt();
			Shop[] shops = new Shop[numOfShops];
			//creating shops equal to the number given by the user
			for(int i = 0; i<numOfShops; i++) {
			//asking the user if they want to make a partial or full registeration
				System.out.println("epimerhs h plhrh egkrafh magaziou (True = epimerhs False = plhrh)\n");
				boolean register = input.nextBoolean();
				if(register) {
					System.out.println("Dwse onoma magaziou ");
					name = input.next();
					System.out.println("Dwse eth leitoyrgeiaw");
					years = input.nextInt();
					shops[i] = new Shop(name, years);
				} else if(!register) {
					System.out.println("Dwse onoma magaziou ");
					name = input.next();
					System.out.println("Dwse eth leitoyrgeiaw");
					years = input.nextInt();
					System.out.println("Dwse eisodhma magaziou ");
					revenue = input.nextInt();
					System.out.println("Exei to magazi Eshop? (True = exei, False = den exei");
					eshop = input.nextBoolean();
					shops[i] = new Shop(name, years, revenue, eshop);
				}
				else
					break;
				System.out.println("Posous ypallhlous 8a kataxwrhseis gia to magazi?");
				numOfEmployee = input.nextInt();
				shops[i].employee = new String[numOfEmployee];
					for(int j = 0; j<numOfEmployee; j++) {
						System.out.println("Dwse onoma ypallhlou");
						name = input.next();
						shops[i].addEmployee(name);
					}
				
			}
			for(int i = 0; i<numOfShops; i++) {
				shops[i].show();
			}
		}
    }
}
class MallProgram {
	public static void main(String[] args) {
		
		try (var input = new Scanner(System.in)) {
			
			String name, employee;
			
			int years, revenue, numOfEmployee;
			boolean eshop;
			System.out.println("Dwse ari8mo polykatasthmatwn\n");
			int numOfMalls = input.nextInt();
			int numOfShops;
			Mall[] malls = new Mall[numOfMalls];
			for(int i = 0; i<numOfMalls; i++) {
				//asking the user if they want to make a partial or full registeration
				System.out.println("epimerhs h plhrh egkrafh magaziou (True = epimerhs False = plhrh)\n");
				boolean register = input.nextBoolean();
				if(register) {
					System.out.println("Dwse onoma mall ");
					name = input.next();
					System.out.println("Dwse eth leitoyrgeiaw");
					years = input.nextInt();
					malls[i] = new Mall(name, years);
				} else if(!register) {
					System.out.println("Dwse onoma mall ");
					name = input.next();
					System.out.println("Dwse eth leitoyrgeiaw");
					years = input.nextInt();
					System.out.println("Dwse eisodhma mall ");
					revenue = input.nextInt();
					System.out.println("Exei to mall Eshop? (True = exei, False = den exei");
					eshop = input.nextBoolean();
					malls[i] = new Mall(name, years, revenue, eshop);
				}
				else
					break;
				//asking the number of shops the Mall has
				System.out.println("Posa magazia exei to polykatasthma?");
				numOfShops = input.nextInt();
				malls[i].shop = new Shop[numOfShops]; 
				for(int l = 0; l<numOfShops; l++) {
					//asking the user if they want to make a partial or full registeration
					System.out.println("epimerhs h plhrh egkrafh magaziou (True = epimerhs False = plhrh)\n");
					register = input.nextBoolean();
					if(register) {
						System.out.println("Dwse onoma magaziou ");
						name = input.next();
						System.out.println("Dwse eth leitoyrgeiaw");
						years = input.nextInt();
						malls[i].shop[l] = new Shop(name, years);
					} else if(!register) {
						System.out.println("Dwse onoma magaziou ");
						name = input.next();
						System.out.println("Dwse eth leitoyrgeiaw");
						years = input.nextInt();
						System.out.println("Dwse eisodhma magaziou ");
						revenue = input.nextInt();
						System.out.println("Exei to magazi Eshop? (True = exei, False = den exei");
						eshop = input.nextBoolean();
						malls[i].shop[l] = new Shop(name, years, revenue, eshop);
					}
					else
						break;
					//asking the number of employees per shop
					System.out.println("Posous ypallhlous 8a kataxwrhseis gia to magazi?");
					numOfEmployee = input.nextInt();
					malls[i].shop[l].employee = new String[numOfEmployee];
						for(int j = 0; j<numOfEmployee; j++) {
							//adding employees
							System.out.println("Dwse onoma ypallhlou");
							name = input.next();
							malls[i].shop[l].addEmployee(name);
						}
					
				}
				
			}
			//showing the Malls information
			for(int i = 0; i<numOfMalls; i++) {
				malls[i].show();
				malls[i].shop[i].show();
			}
		}
	}
}