package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import model.Product;

public class ProductController {
	Scanner sc = new Scanner(System.in);

	public static Connection Connection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productmanagement", "root", "5009");
		return cn;
	}

	public void AddProduct() throws ClassNotFoundException, SQLException {
		Product p = new Product();
		System.out.println("enter product details ");
		System.out.println("enter id, Name, price, quantity, category");
		p.setId(sc.nextInt());
		p.setName(sc.next());
		p.setPrice(sc.nextDouble());
		p.setQuantity(sc.nextInt());
		p.setCatogiri(sc.next());

		int id = p.getId();
		String name = p.getName();
		double price = p.getPrice();
		int quantity = p.getQuantity();
		String category = p.getCatogiri();

		Statement smt = Connection().createStatement();
		String querry = " insert into products values('" + id + "','" + name + "','" + price + "','" + quantity + "','"
				+ category + "')";
		smt.execute(querry);
		System.out.println("data Added succesfully");

	}

	public void ViewProduct() throws ClassNotFoundException, SQLException {

		Connection conn = Connection();
		Statement smt = conn.createStatement();
		String query = "SELECT * FROM products";
		ResultSet rs = smt.executeQuery(query);

		System.out.println("Product Details:");
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			double price = rs.getDouble("price");
			int quantity = rs.getInt("quantity");
			String category = rs.getString("category");

			System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price + ", Quantity: " + quantity
					+ ", Category: " + category);
		}

	}

	public void UpdateProduct() throws ClassNotFoundException, SQLException {
		System.out.println("Avaiabale Product details:-");
		ViewProduct();

		System.out.println(" Select id to update related data for that id:-");
		int cid = sc.nextInt();

		Connection conn = Connection();
		Statement smt = conn.createStatement();
		String query = "SELECT * FROM products";
		
		ResultSet rs = smt.executeQuery(query);
		int id = 0;

		System.out.println("Product Details:");
		while (rs.next()) {
			id = rs.getInt("id");

			if (cid == id) {

				System.out.println("\t1) name \n\t2) price \n\t3) quantity \n3) category");
				int choice = sc.nextInt();
				String newField = "";
				String newValue = "";

				switch (choice) {
				case 1:
					newField = "name";
					System.out.println("Enter the new name:");
					newValue = sc.next();
					String query1 = "update products set name='" + newValue + "' where id='" + cid + "' ";
					smt.executeUpdate(query1);
					break;
				case 2:
					newField = "price";
					System.out.println("Enter the new price:");
					newValue = String.valueOf(sc.nextDouble());
					String query2 = "update products set price='" + newValue + "' where id='" + cid + "'";
					smt.executeUpdate(query2);
					break;
				case 3:
					newField = "quantity";
					System.out.println("Enter the new quantity:");
					newValue = String.valueOf(sc.nextInt());
					String query3 = "update products set quantity='" + newValue + "' where id='" + cid + "' ";
					smt.executeUpdate(query3);
					break;
				case 4:
					newField = "category";
					System.out.println("Enter the new category:");
					newValue = sc.next();
					String query4 = "update products set category='" + newValue + "' where id='" + cid + "' ";
					smt.executeUpdate(query4);
					break;
				default:
					System.out.println("Invalid choice.");
					break;

				}

				System.out.println("DATA update successfully");
				break;
			}
		}
	}

	public void DeletProduct() throws ClassNotFoundException, SQLException {

		System.out.println("Enter product ID to delete:");
		int id = sc.nextInt();

		Connection conn = Connection();
		Statement smt = conn.createStatement();
		String query = "DELETE FROM products WHERE id ='" + id + "' ";
		int delet = smt.executeUpdate(query);

		if (delet > 0) {
			System.out.println("Product deleted successfully.");
		} else {
			System.out.println("Product with ID " + id + " not found.");
		}

		System.out.println("Data deleted succcessfully");
	}

}
