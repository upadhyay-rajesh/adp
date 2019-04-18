package com.rkcpinfo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rkcpinfo.model.Employee;
import com.rkcpinfo.model.Todo;
import com.rkcpinfo.repositories.TodoRepository;

@RestController
public class TestController {
	@Autowired
    TodoRepository todoRepository;

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
    public List<Todo> getAllTodos() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return todoRepository.findAll(sortByCreatedAtDesc);
    }
	@RequestMapping(value = "/employee1", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);

		return emp;
	}

}
