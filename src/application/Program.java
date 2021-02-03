package application;

import java.util.Date;
import java.util.List;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {

		SellerDAO sellerDAO = DAOFactory.createSellerDAO();

		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDAO.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		List<Seller> list = sellerDAO.findByDepartment(new Department(2, null));
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		list = sellerDAO.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@email", new Date(), 4000.0, new Department(2, null));
		sellerDAO.insert(newSeller);
		System.out.println("Novo registro inserido! Identificador = " + 	newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerDAO.findById(1);
		seller.setName("Martha White");
		sellerDAO.update(seller);
		System.out.println("Atualização efetuada.");
	}
}