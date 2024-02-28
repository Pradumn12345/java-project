package neew.example.newproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import neew.example.newproject.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
