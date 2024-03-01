package neew.example.newproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neew.example.newproject.entity.Department;
import neew.example.newproject.repository.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department updateDepartment(Long id, Department departmentDetails) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            department.setDeptName(departmentDetails.getDeptName());
            // Optionally, update the associated employee
//            department.setEmployee(departmentDetails.getEmployee());
            return departmentRepository.save(department);
        } else {
           
            return null;
        }
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

}
