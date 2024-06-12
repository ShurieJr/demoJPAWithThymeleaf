package com.exampleJPA.demoJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer> {
    @Query(value="SELECT * FROM customer WHERE name LIKE %?1%", nativeQuery = true)
    public List<Customer> search(@Param("keyword") String keyword);
}
