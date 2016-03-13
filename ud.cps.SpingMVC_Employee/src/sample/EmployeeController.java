package sample;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	  @Autowired
	  private EmployeeDAOImpl employeeDAOImpl;
	  
	  @InitBinder  
	  public void initBinder(WebDataBinder binder) {  
	      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	      dateFormat.setLenient(false);  
	      binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false)); 
	  }
	  @RequestMapping(value="/")
	  public String listEmployee(ModelMap model) throws IOException{
	      List<Employee> listEmployee = employeeDAOImpl.list();
	      model.addAttribute("listEmployee", listEmployee);
	      return "index";
	  }
	 
	  
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public String saveContact(@ModelAttribute("SpringWeb") Employee emp) {
		  employeeDAOImpl.saveOrUpdate(emp);
	      return "redirect:/";
	  }
	  
	  @RequestMapping(value = "/delete", method = RequestMethod.GET)
	  public String deleteEmployee(HttpServletRequest request) {
	      int employeeid = Integer.parseInt(request.getParameter("id"));
	      employeeDAOImpl.delete(employeeid);
	      return "redirect:/";
	  }
	  
	  @RequestMapping(value = "/newEmployee")
	   public ModelAndView student() {
		  Employee emp=new Employee();
		  emp.setID(-1);
		  return new ModelAndView("add_edit", "command", emp);
	  
	   }
	  
	  @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	  public ModelAndView editEmployee(HttpServletRequest request,ModelAndView model) {
	      int employeeid = Integer.parseInt(request.getParameter("id"));
	      Employee emp = employeeDAOImpl.get(employeeid);
	      return new ModelAndView("add_edit", "command", emp);
	  }
}
