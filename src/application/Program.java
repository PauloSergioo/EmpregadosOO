package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Nome do departamento: ");
		String department = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		sc.nextLine();
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String number = sc.nextLine();

		Department depart = new Department(department, payDay, new Address(email, number));

		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.printf("Dados do funcionário %d%n", i);
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();

			Employee emp = new Employee(name, salary);
			depart.addEmp(emp);
		}

		showReport(depart);

		sc.close();

	}

	private static void showReport(Department dept) {

		System.out.println();
		System.out.println("FOLHA DE PAGAMENTO: ");
		System.out.printf("Depatamento Vendas = R$ %.2f%n", dept.payRoll());
		System.out.printf("Pagamento realizado no dia %d%n", dept.getPayDay());
		System.out.println("Funcionários:");

		for (Employee emps : dept.getEmp()) {
			System.out.println(emps.getName());
		}

		System.out.printf("Para dúvidas favor entrar em contato: %s", dept.getAddress().getEmail());

	}

}
