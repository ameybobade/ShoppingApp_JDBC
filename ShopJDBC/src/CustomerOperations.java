import java.util.*;

public class CustomerOperations {
	
	Product prod = null;
	ProductDao ProdDao = new ProductDao();
	Scanner sc = new Scanner(System.in);
	int i;
	
	public void Display()
	{
		System.out.println("Display here");
		
		List<Product> lstprod = ProdDao.custdisplayProduct();
		i=1;
		System.out.println("Sr no.\tProduct Name\tPrice");
		for(Product p:lstprod) {
			System.out.println(i+"\t"+p.getProdName()+"\t\t"+p.getPrice());
			i++;
		}
	}
	
	
	public List<Product> Buy(List<Product> prodcart)
	{
		System.out.println("Buy products");
		
		List<Product> lstprod = ProdDao.custdisplayProduct();
		i=1;
		System.out.println("Sr no.\tProduct Name\tPrice");
		for(Product p:lstprod) {
			System.out.println(i+"\t"+p.getProdName()+"\t\t"+p.getPrice());
			i++;
		}
		
		System.out.println("Enter Product Name you want to buy - ");
		String pname = sc.next();
		System.out.println("Enter how many product do want to buy?");
		int Quant = sc.nextInt();
		
		prodcart = ProdDao.buyProduct(pname,Quant,prodcart);
		return prodcart;
	}
	
	public void Cart(List<Product> prodcart)
	{
		System.out.println("Cart Here");
		int i=1;
		
		System.out.println("Sr No.\tProduct Name\tQuantity");
		
		for(Product prod:prodcart) {
			System.out.println(i+"\t"+prod.getProdName()+"\t\t"+prod.getQuant());
			i++;
		}
		
		
		
		
	}
	public List<Product> Bill(List<Product> prodcart)
	{
		System.out.println("Bill here");
		float total=0;
		int i=1;
		
		System.out.println("Sr No.\tProduct Name\tQuantity\tPrice");
		
		for(Product prod:prodcart) {
			float price = prod.getPrice()*prod.getQuant();
			System.out.println(i+"\t"+prod.getProdName()+"\t\t"+prod.getQuant()+"\t\t"+price);
			i++;
			total+=price;
		}
		System.out.println("Total - \t\t\t\tRs."+total);
		
		System.out.println("Do you want to pay bill?");
		String ch=sc.next();
		if(ch.equals("yes")) {
			System.out.println("Bill paid!!");
			prodcart.clear();
		}
		
		return prodcart;
	}
}
