
public class Product {
	
	private int ProdId;
	private String ProdName;
	private int Quant;
	private float Price;


	public Product(int prodId, String prodName, int quant, float price) {
		ProdId = prodId;
		ProdName = prodName;
		Quant = quant;
		Price = price;
	}


	public int getProdId() {
		return ProdId;
	}


	public void setProdId(int prodId) {
		ProdId = prodId;
	}


	public String getProdName() {
		return ProdName;
	}


	public void setProdName(String prodName) {
		ProdName = prodName;
	}


	public int getQuant() {
		return Quant;
	}


	public void setQuant(int quant) {
		Quant = quant;
	}


	public float getPrice() {
		return Price;
	}


	public void setPrice(float price) {
		Price = price;
	}
	
	
	
	
	
}
