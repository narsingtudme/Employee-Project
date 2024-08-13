package comm.qsp.view;

import java.util.List;
import java.util.Scanner;

import comm.qsp.controller.EmployeeController;
import comm.qsp.model.Employee;

public class EmployeeView {
	public static void main(String[] args) {
//		Employee e=new Employee();
//		e.setId(102);
//		e.setName("Narsing");
//		e.setSal(9999);
//		EmployeeController.insert(e);
//		System.out.println("Inserted");
//		Employee e=EmployeeController.fetchById(101);
//		System.out.println(e.getName());
//		boolean b=EmployeeController.updateNameById(102,"nars");
//		System.out.println(b);
//		boolean b=EmployeeController.deleteById(101);
//		System.out.println(b);
//		List<Employee> li=EmployeeController.fetchAll();
//		for(Employee e:li) {
//			System.out.print(e);
//		}
		Scanner sc=new Scanner(System.in);
		System.out.println("*********WELCOME**********");
		do
		{	
			System.out.println("1 > Inserted Employee");
			System.out.println("2 > Update Employee name By ID");
			System.out.println("3 > Fetch EMployee by ID");
			System.out.println("4 > delete Employee buy ID");
			System.out.println("5 > Fetch All Employee");
		switch (sc.nextInt())
		{
		case 1: {
			Employee e=new Employee();
			System.out.println("Enter id");
			e.setId(sc.nextInt());
			System.out.println("Enter name");
			e.setName(sc.next());
			System.out.println("Enter salary");
			e.setSal(sc.nextDouble());
			EmployeeController.insert(e);
			System.out.println("Inserted---------");
			
		}
		break ;
		case 2: {
			System.out.println("Enter id");
			int id=sc.nextInt();
			System.out.println("Enter a new Name");
			String newName=sc.next();
			boolean b=EmployeeController.updateNameById(id, newName);
			if(b)
			{
				System.out.println("Updated-----");
			}
			else {
				System.out.println("Id is not present------");
			}
			
		}
		break;
		case 3: {
			System.out.println("Enter id");
			Employee e=EmployeeController.fetchById(sc.nextInt());
			System.out.println(e);
			
			
		}break;
		case 4: {
			System.out.println("Enter id");
			boolean b=EmployeeController.deleteById(sc.nextInt());
			if(b) {
				System.out.println("deleted-----");
			}
			else {
				System.out.println("id is not present");
			}
		}
		break;
		case 5: {
			List<Employee> li=EmployeeController.fetchAll();
			for(Employee e : li) {
				System.out.println(e);
			}
			
		}
		break;
		default:
			System.out.println("Wrong info");
		
		}
		System.out.println("Enter y to continue");
	}while("Y".equalsIgnoreCase(sc.next()));
		
	}

}
