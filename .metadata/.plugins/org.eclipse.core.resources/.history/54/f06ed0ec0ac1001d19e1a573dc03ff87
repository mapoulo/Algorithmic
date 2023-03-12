package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.Entity.MyOrder;
import com.example.demo.Repository.OrderRepo;
import com.example.demo.Service.OrderService;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

	
	@Mock private OrderRepo repo;
	private OrderService orderServiceUnderTest;
	
	
	@BeforeEach
	void setUp() {
		orderServiceUnderTest = new OrderService(repo);
	}
	
	
	@Test
	public void getAllOrders() {
		//When
		orderServiceUnderTest.getAllMyOrders();
		//Then
		verify(repo).findAll();
	}
	
	
	@Test
	public void saveOrderTest() {
		//Give
		MyOrder order = MyOrder.builder().quantity(1).side("Buy").price(100).build();
		//when
		orderServiceUnderTest.saveMyOrder(order);
		//Then
		ArgumentCaptor<MyOrder> argumentCaptor = ArgumentCaptor.forClass(MyOrder.class);
		verify(repo).save(argumentCaptor.capture());
		
		MyOrder capturedValue = argumentCaptor.getValue();
		
		assertThat(capturedValue).isEqualTo(order);
	}
	
	
}
