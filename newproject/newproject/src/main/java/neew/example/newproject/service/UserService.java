package neew.example.newproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import neew.example.newproject.entity.Empoyee;
import neew.example.newproject.repository.UseRepository;

@Component
public class UserService {
	@Autowired
	private UseRepository employeeRepository;

	public Empoyee createEmployee(Empoyee employee) {
		return employeeRepository.save(employee);
	}

	public Empoyee getUserById(int id) {
		return employeeRepository.findById((long) id).orElse(null);
	}

	public List<Empoyee> getAllUsers() {
		return employeeRepository.findAll();
	}
	 public List<Empoyee> getEmployeesByName(String firstName) {
	        return employeeRepository.findByName(firstName);
	    }

	public Empoyee updateEmployee(Long id, Empoyee employeeDetails) {
		Optional<Empoyee> optionalEmployee = employeeRepository.findById(id);
		if (optionalEmployee.isPresent()) {
			Empoyee employee = optionalEmployee.get();
			employee.setFirstName(employeeDetails.getFirstName());
			employee.setMiddleName(employeeDetails.getMiddleName());
			employee.setLastName(employeeDetails.getLastName());
			employee.setGender(employeeDetails.getGender());
			employee.setMobile(employeeDetails.getMobile());
			employee.setEmail(employeeDetails.getEmail());
			employee.setPanCard(employeeDetails.getPanCard());
			employee.setAdharCard(employeeDetails.getAdharCard());
			employee.setAddress(employeeDetails.getAddress());
			employee.setDob(employeeDetails.getDob());
			employee.setSalary(employeeDetails.getSalary());
			employee.setDepositId(employeeDetails.getDepositId());
			return employeeRepository.save(employee);
		} else {
			// Handle error: Employee with given id not found
			return null;
		}
	}



	public String deleteUserById(int id) {
		employeeRepository.deleteById((long) id);
		return "user got deleted";
	}
}
