package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.MyOrder;


public interface OrderRepo extends JpaRepository<MyOrder, Integer>{

}
