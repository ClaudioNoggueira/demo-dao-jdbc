package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class AnotherProgram{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		DepartmentDAO depDAO = DAOFactory.createDepartmentDAO();
		
		System.out.println("=== TEST 1: department findById ===");
		Department dep = depDAO.findById(2);
		System.out.println(dep);
		
		System.out.println("=== TEST 2: department findAll ===");
		List<Department> list = depDAO.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 3: department insert ===");
		dep.setName("Brinquedos");
		depDAO.insert(dep);
		System.out.println("Novo departamento inserido. " + dep.getName());
		
		System.out.println("=== TEST 4: department update ===");
		dep = depDAO.findById(1);
		dep.setName("Produtos esportivos");
		depDAO.update(dep);
		System.out.println("Atualização de departmento efetuada.");
		
		System.out.println("=== TEST 5: department delete ===");
		System.out.println("Entre com o ID do departamento a ser excluído.");
		int id = input.nextInt();
		depDAO.deleteById(id);
		System.out.println("Departamento excluído com sucesso.");
		
		input.close();
	}
}
