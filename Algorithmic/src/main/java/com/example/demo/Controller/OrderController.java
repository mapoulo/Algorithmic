package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.MyOrder;
import com.example.demo.Service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	
	@Autowired
	private OrderService service;
	
	@PostMapping("/save")
	public MyOrder saveMyOrder(@Validated @RequestBody MyOrder MyOrder) {
		return service.saveMyOrder(MyOrder);
	}
	
	@GetMapping("/all")
	public List<MyOrder> getAllOders(){
		return service.getAllMyOrders();
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteMyOrder(@Validated @PathVariable int id) {
		return service.deleteMyOrderById(id);
	}
	
	@PutMapping("/update/{id}/{quantity}")
	public MyOrder updateMyOrder(@Validated @PathVariable int id, @Validated @PathVariable int quantity) {
		return service.updateMyOrder(id, quantity);
	}

}
