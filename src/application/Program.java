package application;

import java.util.Date;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		Department dep = new Department(1, "Livros");
		System.out.println(dep);

		SellerDAO sellerDAO = DAOFactory.createSellerDAO();

		Seller seller = new Seller(21, "Bob", "bob@email.com", new Date(), 3000.0, dep);
		System.out.println(seller);
	}
}
