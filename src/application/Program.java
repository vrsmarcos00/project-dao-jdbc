package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: Seller findById ===");
		Seller seller = sellerDao.findById(7);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: Seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: Seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: Seller Insert ===");
		Seller newSeller = new Seller(null, "Maria Fernanda", "maria@gmail.com", new Date(), 5000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
	}

}
