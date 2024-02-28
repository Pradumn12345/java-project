package neew.example.newproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import neew.example.newproject.entity.Empoyee;
@Repository
public interface UseRepository extends JpaRepository<Empoyee,Long> {

}
