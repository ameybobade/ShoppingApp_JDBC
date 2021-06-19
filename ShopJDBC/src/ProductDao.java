import java.sql.*;
import java.util.*;

public class ProductDao {
	
	Connection con = null;
	MyConnection mycon = new MyConnection();
	PreparedStatement pstate;
	Statement state;
	int i;
	
	public void addProduct(Product prod)
	{
		con = mycon.getConnection();
		
		try {
			pstate = con.prepareStatement("insert into product values(?,?,?,?)");
			
			pstate.setInt(1, prod.getProdId());
			pstate.setString(2, prod.getProdName());
			pstate.setInt(3, prod.getQuant());
			pstate.setFloat(4, prod.getPrice());
			
			i = pstate.executeUpdate();
			if(i>0)
			{
				System.out.println("Record Added!!");
			}
			else
			{
				System.out.println("Record not saved!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateProduct(Product prod)
	{
		con = mycon.getConnection();
		
		try {
			pstate = con.prepareStatement("Update Product set ProdName=?,Quantity=?,price=? where ProdID=?");
			
			pstate.setInt(4, prod.getProdId());
			pstate.setString(1, prod.getProdName());
			pstate.setInt(2, prod.getQuant());
			pstate.setFloat(3, prod.getPrice());
			
			i = pstate.executeUpdate();
			if(i>0)
			{
				System.out.println("Record Updated!!");
			}
			else {
				System.out.println("Record not updated. Please check Product Id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteProduct(int prodId) {
		// TODO Auto-generated method stub
		
		con=mycon.getConnection();
		
		try {
			pstate = con.prepareStatement("delete from product where ProdId = ?");
			
			pstate.setInt(1, prodId);
			
			i=pstate.executeUpdate();
			if(i>0)
			{
				System.out.println("REcord Deleted!!");
			}
			else
			{
				System.out.println("Record not deleted. Please check product id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Product searchProduct(int prodId) {
		// TODO Auto-generated method stub
		
		con = mycon.getConnection();
		Product prod = null;
		
		try {
			pstate=con.prepareStatement("select * from product where ProdId = ?");
			pstate.setInt(1, prodId);
			
			ResultSet rs = pstate.executeQuery();
			
			if(rs.next())
			{
				prod = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prod;
		
	}

	public List<Product> displayProduct() {
		// TODO Auto-generated method stub
		
		LinkedList<Product> lstprod = new LinkedList<Product>();
		con = mycon.getConnection();
		
		String str = "select * from product";
		
		try {
			state = con.createStatement();
			ResultSet rs = state.executeQuery(str);
			
			while(rs.next())
			{
				Product prod = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4));
				lstprod.add(prod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lstprod;
	}
	
	
	public List<Product> custdisplayProduct() {
		// TODO Auto-generated method stub
		
		LinkedList<Product> lstprod = new LinkedList<Product>();
		con = mycon.getConnection();
		
		String str = "select * from product where quantity!=0";
		
		try {
			state = con.createStatement();
			ResultSet rs = state.executeQuery(str);
			
			while(rs.next())
			{
				Product prod = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4));
				lstprod.add(prod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lstprod;
	}
	
	
	//;
//	List<Product> prodcart = null;
	//new LinkedList<Product>();
	public List<Product> buyProduct(String pname, int quant,List<Product> prodcart ) {
		// TODO Auto-generated method stub
		
		try {
			pstate=con.prepareStatement("select * from product where prodname=?");
			pstate.setString(1, pname);
			
			i=pstate.executeUpdate();
			ResultSet rs = pstate.executeQuery();
			
			if(rs.next())
			{
				
				int q = rs.getInt(3);
				int newquant = q-quant;
				if(q>quant && newquant>=0) {
					
					pstate = con.prepareStatement("Update Product set Quantity=? where ProdID=?");
					
					pstate.setInt(2, rs.getInt(1));
					pstate.setInt(1, newquant);
					
					pstate.executeUpdate();
					
					Product prod = new Product(rs.getInt(1),rs.getString(2),quant,rs.getFloat(4));
					prodcart.add(prod);
					
					
					System.out.println("Product Found Adding into cart!!");
					
					for(Product p:prodcart) {
						System.out.println(i+"\t"+p.getProdName()+"\t"+p.getQuant());
						i++;
					}
				}
				else {
					System.out.println("We dont have products right now for the quantity you require");
				}
				
				
			}
			else {
				System.out.println("No such product available!! Please try later");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prodcart;
	}

//	public void custCart(List<Product> prodcart) {
//		// TODO Auto-generated method stub
//		
//		
//	}

//	public void custBill() {
//		// TODO Auto-generated method stub
//		
//	}
	
	
		
		
	
}
