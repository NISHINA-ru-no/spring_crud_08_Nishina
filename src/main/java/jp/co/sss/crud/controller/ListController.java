package jp.co.sss.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.crud.repository.EmployeeRepository;

@Controller
public class ListController {
	@Autowired
	EmployeeRepository repository;
	
	@RequestMapping("/list")
	public String showList(Model model) {
		model.addAttribute("emps", repository.findAll());
		return "/list/list";
	}
	
	@RequestMapping("/list/empName")
	public String showListByEmpName(String empName, Model model) {
		model.addAttribute("emps",repository.findByEmpNameContaining(empName));
		return "/list/list";
	}

}
