package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== TEST 1: seller findById === ");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println("\n=== TEST 2: seller findByDepartment === ");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartmet(department);
		for(Seller obj: list) {
			System.out.println(obj);
		}
		System.out.println("\n=== TEST 3: seller findByAll === ");
		list = sellerDao.findAll();
		for(Seller obj: list) {
			System.out.println(obj);
		}
		System.out.println("\n=== TEST 4: seller Insert === ");
		Seller newSeller = new Seller(null,"gref", "@gmail",new Date(), 4.000,department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted: " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller Update === ");
		seller = sellerDao.findById(1);
		seller.setName("João Gabriel");
		sellerDao.update(seller);
		System.out.println("Updated completed");
		
		System.out.println("\n=== TEST 6: seller Delete === ");
		System.out.println("Enter id for delet test");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		sc.close();
	}
}	
