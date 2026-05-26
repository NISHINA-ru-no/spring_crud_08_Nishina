package jp.co.sss.crud.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.crud.entity.Department;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.EmployeeForm;
import jp.co.sss.crud.repository.EmployeeRepository;

@Controller
public class RegistrationController {
	
	@RequestMapping("/regist/regist/input")
	public String createInput() {
		return "regist/regist_input";
	}
	
	@RequestMapping(path = "/regist/regist/complete",method = RequestMethod.POST)
	public String registComplete(EmployeeForm form,Model model) {
	Employee emp = new Employee();
	BeanUtils.copyProperties(form,emp);
	Department department = new Department();
	department.setDeptId(form.getDeptId());
	emp.setDepartment(department);
	emp=EmployeeRepository.save(emp);
	model.addAttribute("emp",emp);
	return "/list/list";
	

	}
}
