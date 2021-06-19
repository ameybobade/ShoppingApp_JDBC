import java.util.*;

public class AdminOperations {
	
	private int ProdId;
	private String ProdName;
	private int Quant;
	private float Price;
	
	Scanner sc = new Scanner(System.in);
	ProductDao ProdDao=new ProductDao();
	
	public void Add() {
		// TODO Auto-generated method stub
		System.out.println("Add Product");
		
		System.out.println("Enter Product id - ");
		ProdId = sc.nextInt();
		System.out.println("Enter Product Name - ");
		ProdName = sc.next();
		System.out.println("Enter Product Quantity - ");
		Quant = sc.nextInt();
		System.out.println("Enter Product Price - ");
		Price = sc.nextFloat();
		
		Product prod = new Product(ProdId,ProdName,Quant,Price);
		
		ProdDao.addProduct(prod);
	}

	

	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("Update Product");
		
		System.out.println("Enter the product details which you want to update");
		
		System.out.println("Enter Product id of the product - ");
		ProdId = sc.nextInt();
		System.out.println("Enter the updated Product Name - ");
		ProdName = sc.next();
		System.out.println("Enter the updated Product Quantity - ");
		Quant = sc.nextInt();
		System.out.println("Enter the updated Product Price - ");
		Price = sc.nextFloat();
		
		Product prod = new Product(ProdId,ProdName,Quant,Price);
		
		ProdDao.updateProduct(prod);
		
	}

	public void Delete() {
			// TODO Auto-generated method stub
			System.out.println("Delete Product");
			
			System.out.println("Enter the product id which you want to delete - ");
			ProdId = sc.nextInt();
			
			ProdDao.deleteProduct(ProdId);
			
			
		}
	
	
	public void Search() {
			// TODO Auto-generated method stub
		
			System.out.println("Product Search");
			
			System.out.println("Enter the product id which you want to search - ");
			ProdId = sc.nextInt();
			
			Product prod = ProdDao.searchProduct(ProdId);
			
			if(prod!=null)
			{
				System.out.println("Product Id\tProduct Name\tQuantity\tPrice");
				System.out.println(prod.getProdId()+"\t\t"+prod.getProdName()+"\t\t"+prod.getQuant()+"pcs\t\t"+prod.getPrice());
			}
			else
			{
				System.out.println("No such Product in the DB. Please enter check product id");
			}
		}
	
	
	public void Display() {
		// TODO Auto-generated method stub
		System.out.println("Display Products");
		
		List<Product> lstprod = ProdDao.displayProduct();
		
		System.out.println("Product Id\tProduct Name\tQuantity\tPrice");
		for(Product prod : lstprod)
		{
			System.out.println(prod.getProdId()+"\t\t"+prod.getProdName()+"\t\t"+prod.getQuant()+"pcs\t\t"+prod.getPrice());
		}
		
	}



	



	

}
