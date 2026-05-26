package jp.co.sss.crud.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.crud.entity.Department;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.EmployeeForm;
import jp.co.sss.crud.repository.EmployeeRepository;

@Controller
public class RegistrationController {
	@Autowired
	EmployeeRepository repository;
	@RequestMapping(path="/regist/input2", method = RequestMethod.POST)
	public String createInput2(@ModelAttribute EmployeeForm form, Model model) {
		model.addAttribute("employeeForm", form);
		return "regist/regist_input";
	}

	@RequestMapping("/regist/input")
	public String createInput(@ModelAttribute EmployeeForm form, Model model) {
		model.addAttribute("employeeForm", form);
		return "regist/regist_input";
	}

	@RequestMapping(path = "/regist/check", method = RequestMethod.POST)
	public String registComplete(@ModelAttribute EmployeeForm form, Model model) {
		//model.addAttribute("employeeForm", form);
		return "regist/regist_check";

	}

	@RequestMapping(path = "/regist/complete", method = RequestMethod.POST)
	public String Complete(EmployeeForm form, Model model) {
		Employee emp = new Employee();
		BeanUtils.copyProperties(form, emp);
		Department department = new Department();
		department.setDeptId(form.getDeptId());
		emp.setDepartment(department);
		emp = repository.save(emp);

		return "regist/regist_complete";
	}

}
