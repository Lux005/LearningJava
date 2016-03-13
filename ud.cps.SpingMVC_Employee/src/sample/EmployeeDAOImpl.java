package sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDAOImpl implements EmployeeDAO {
	//private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
    public EmployeeDAOImpl(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
	
	//public void create(String name, Integer age);
	
    public void saveOrUpdate (Employee emp){
    	
    	
		if (emp.getID() > 0) {
            // update
            String sql = "UPDATE employees SET EmployeeID=?, FirstName=?, LastName=?, DoB=?, "
                        + "Department=?, Gender=? WHERE ID=?";
            jdbcTemplateObject.update(sql, emp.getEmployeeID(), emp.getFirstName(), emp.getLastName(),
                    emp.getDoB(), emp.getDepartment(), emp.getGender(),emp.getID());
        } else {
            // insert
            String sql = "INSERT INTO employees (ID, EmployeeID, FirstName, LastName, DoB, Gender, Department)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplateObject.update(sql,null,emp.getEmployeeID(), emp.getFirstName(), emp.getLastName(),
                    emp.getDoB(), emp.getGender(), emp.getDepartment());
        }
    	
    }
	
	
	public void delete(Integer id){
		String sql = "DELETE FROM employees WHERE ID=?";
	    jdbcTemplateObject.update(sql, id);
	
	}
	
    public List<Employee> list(){
    	
    	String SQL = "select * from employees";
        List <Employee> employees = jdbcTemplateObject.query(SQL, new RowMapper<Employee>(){
        	@Override
        	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        		
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
        });
        return employees;
		
    }
	
	public Employee get(Integer id){
		String SQL = "select * from employees where ID=?";
        Employee employee = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new EmployeeMapper());
        return employee;
		
	}
	
}	
	
