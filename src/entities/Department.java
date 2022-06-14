package entities;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private Address address;
	private String name;
	private Integer payDay;

	public List<Employee> emp = new ArrayList<>();

	public Department(String name, int payDay, Address address) {
		this.name = name;
		this.payDay = payDay;
		this.address = address;
	}

	public Department() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPayDay() {
		return payDay;
	}

	public void setPayDay(int payDay) {
		this.payDay = payDay;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Employee> getEmp() {
		return emp;
	}

	public void addEmp(Employee emps) {
		emp.add(emps);
	}

	public void removeEmp(Employee emps) {
		emp.remove(emps);
	}

	public double payRoll() {
		double sum = 0.0;

		for (Employee emps : emp) {
			sum += emps.getSalary();
		}
		return sum;
	}

	@Override
	public String toString() {

		return String.format("%.2f", payRoll());
	}
}
