package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.Entity.MyOrder;
import com.example.demo.Exceptions.MyOrderNotFoundException;
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
	
	
	 @Test
	 public void deleteMyOrderById() {
		int id = 1;
		MyOrder order = MyOrder.builder().Id(id).price(10).build();
        when(repo.findById(id)).thenReturn(Optional.of(order));
        orderServiceUnderTest.deleteMyOrderById(id);
	    verify(repo, timeout(1)).deleteById(id);
	 }
	
	 
	 @Test
	 public void deleteMyOrderById_MyOrderNotFound() {
		 int id = 1;
		 when(repo.findById(id)).thenReturn(Optional.empty());
		 assertThrows(MyOrderNotFoundException.class, ()->{
			 orderServiceUnderTest.deleteMyOrderById(id);
		 });
		 verify(repo, never()).deleteById(id);
	 }
	 
	
}
