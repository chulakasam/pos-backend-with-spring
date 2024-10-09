package com.example.pos_backend.Dao;

import com.example.pos_backend.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao  extends JpaRepository<CustomerEntity,String> {
}
