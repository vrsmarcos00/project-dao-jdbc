package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		//System.out.println("\n=== TEST 1: Department Insert ===");
		//Department newDepartment = new Department(null, "Vestuario");
		//departmentDao.insert(newDepartment);
		//System.out.println("Inserted! New Id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 2: Department Update ===");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update Complete");
		
		System.out.println("\n=== TEST 3: Department Delete ===");
		System.out.print("Enter the department id to be deleted: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted Completed");
		
		System.out.println("\n=== TEST 4: Department findById ===");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 5: Department findAll ===");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for(Department depart : list) {
			System.out.println(depart);
		}
		sc.close();

	}

}
