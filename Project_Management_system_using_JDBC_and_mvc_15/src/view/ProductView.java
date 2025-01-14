package view;

import java.sql.SQLException;
import java.util.Scanner;
import Controller.ProductController;

public class ProductView {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		ProductController pc = new ProductController();
		ProductController.Connection();
		while (true) {
			System.out.println("welcome to product management system");
			System.out.println("\t\t\tMENUS");
			System.out.println("1 )ADD PRODUCT");
			System.out.println("2 )VIEW ALL PRODUCT");
			System.out.println("3 )UPDATE PRODUCT");
			System.out.println("4 )DELET PRODUCT");
			System.out.println("5 )EXITE......");

			System.out.println("ENTER YOUR CHOICE");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				pc.AddProduct();
				break;

			case 2:
				pc.ViewProduct();
				break;

			case 3:
				pc.UpdateProduct();
				break;

			case 4:
				pc.DeletProduct();
				break;

			default:
				System.out.println("ENter valid details otherwise exist");
				break;

			}
		}
	}

}
