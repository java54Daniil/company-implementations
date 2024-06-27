package telran.employees;

import java.util.*;
import java.util.TreeMap;
//So far we do consider optimization
public class CompanyMapsImpl implements Company {
	TreeMap<Long,Employee> employees = new TreeMap<>();
	HashMap<String,List<Employee>> employeesDepartment= new HashMap<>();
	TreeMap<Float, List<Manager>> factorManagers = new TreeMap<>();
	@Override
	public Iterator<Employee> iterator() {
		// TODO Auto-generated method stub
		return employees.values().iterator();
	}

	@Override
	public void addEmployee(Employee empl) {
		// TODO Auto-generated method stub
		 long id = empl.getId();
		    if (!employees.containsKey(id)) {
		        throw new IllegalStateException("Employee with ID " + empl.getId() + " already exists");
		    }

		    // Add employee to employees map
		    employees.put(empl.getId(), empl);

		    // Get or create employee list for department
		    List<Employee> departmentEmployees = employeesDepartment.getOrDefault(empl.getDepartment(), new ArrayList<>());
		    departmentEmployees.add(empl);
		    employeesDepartment.put(empl.getDepartment(), departmentEmployees);
	}

	@Override
	public Employee getEmployee(long id) {
		Employee employee = employees.get(id);
		// TODO Auto-generated method stub
		return employee;
	}

	@Override
	public Employee removeEmployee(long id) {
		// TODO Auto-generated method stub
		 Employee removedEmployee = employees.remove(id);
	        if (removedEmployee != null) {
	            // Remove from department map
	            List<Employee> departmentEmployees = employeesDepartment.get(removedEmployee.getDepartment());
	            if (departmentEmployees != null) {
	                departmentEmployees.remove(removedEmployee);
	            }
	        }
		return removedEmployee;
	}

	@Override
	public int getDepartmentBudget(String department) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] getDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manager[] getManagersWithMostFactor() {
		// TODO Auto-generated method stub
		return null;
	}

}
