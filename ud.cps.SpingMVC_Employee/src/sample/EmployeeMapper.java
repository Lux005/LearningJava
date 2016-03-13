package sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;



public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setID(rs.getInt("ID"));
		employee.setFirstName(rs.getString("FirstName"));
		employee.setLastName(rs.getString("LastName"));
		employee.setDoB(rs.getDate("DoB"));
		employee.setGender(rs.getString("Gender"));
		employee.setDepartment(rs.getString("Department"));
		employee.setEmployeeID(rs.getInt("EmployeeID"));
		
		return employee;
	}

}
