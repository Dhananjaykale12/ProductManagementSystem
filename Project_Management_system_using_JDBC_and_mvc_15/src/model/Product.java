package model;

public class Product {
	private int Id;
	private String Name;
	private double Price;
	private int Quantity;
	private String Catogiri;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantaty) {
		Quantity = quantaty;
	}
	public String getCatogiri() {
		return Catogiri;
	}
	public void setCatogiri(String catogiri) {
		Catogiri = catogiri;
	}
	@Override
	public String toString() {
		return "Product [Id=" + Id + ", Name=" + Name + ", Price=" + Price + ", Quantity=" + Quantity + ", Catogiri="
				+ Catogiri + "]";
	}
	


}
