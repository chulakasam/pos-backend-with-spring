package com.example.pos_backend.Dao;

import com.example.pos_backend.Entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsDao extends JpaRepository<OrderDetailsEntity,String> {
}
