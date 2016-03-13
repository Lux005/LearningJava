package sample;

import java.util.List;

public interface EmployeeDAO {

	
	public void saveOrUpdate (Employee emp); 
	
	public void delete(Integer id); 
	
	public List<Employee> list();
	
	public Employee get(Integer id);
	


}
