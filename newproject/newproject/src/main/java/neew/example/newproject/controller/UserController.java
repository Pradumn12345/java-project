package neew.example.newproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import neew.example.newproject.entity.Empoyee;
import neew.example.newproject.service.UserService;
@RestController

public class UserController {
	  @Autowired
	    private UserService employeeService;

		@PostMapping("/addUser")
		public Empoyee addUser(@RequestBody Empoyee user) {
			return employeeService.createEmployee(user);
		}

//		@PostMapping("/addUsers")
//		public List<Empoyee> addUser(@RequestBody List<Empoyee> users) {
//			return employeeService.createUsers(users);

//		}
	    @GetMapping("/{firstName}")
	    public ResponseEntity<List<Empoyee>> getEmployeesByName(@PathVariable String firstName) {
	        List<Empoyee> employees = employeeService.getEmployeesByName(firstName);
	        if (!employees.isEmpty()) {
	            return new ResponseEntity<>(employees, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

		@GetMapping("/user/{id}")
		public Empoyee getUserById(@PathVariable int id) {
			return employeeService.getUserById(id);
		}

		@GetMapping("/users")
		public List<Empoyee> getAllUsers() {
			return employeeService.getAllUsers();
		}
		@PutMapping("/updateuser")
		public Empoyee updateUser(@RequestBody Empoyee user) {
			return employeeService.updateEmployee(null, user);
		}
		@DeleteMapping("/user/{id}")
		public String deleteUser(@PathVariable int id) {
			return employeeService.deleteUserById(id);
		}
	}


