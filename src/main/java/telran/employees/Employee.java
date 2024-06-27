package telran.employees;

import java.util.Objects;

public class Employee implements Comparable<Employee>{
	private long id;
	private int basicSalary;
	private String deepartment;
	
	public Employee(long id, int basicSalary, String deepartment) {
		super();
		this.id = id;
		this.basicSalary = basicSalary;
		this.deepartment = deepartment;
	}
	@Override
	public int compareTo(Employee o) {
	
		//comparing according to id
		return   Long.compare(this.id, o.id);
	}
	public long getId() {
		return id;
	}
	public int getBasicSalary() {
		return basicSalary;
	}
	public String getDepartment() {
		return deepartment;
	}
	public int computeSalary() {
		return basicSalary;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id;
	}
	
	
}
