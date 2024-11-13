package com.example.applications;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.entities.Product;
import com.example.services.ProductService;

@ExtendWith(MockitoExtension.class)
public class TestApplication {
	
	@InjectMocks
	private ProductApplication productApplication;
	
	@Mock
	private ProductService productService;
	
	@Mock
	private Product p1;
	
	@Test
	public void testSaveImage() {
		when(productService.save(p1)).thenReturn(true);
		productApplication.append(p1);
		verify(productService, times(1)).save(p1);
	}
	@Test
	public void testRemoveImage() {
		productApplication.remove(p1.getId());
		verify(productService, times(1)).remove(p1.getId());
	}
	@Test
	public void testUpdateImage() {
		productApplication.update(p1.getId(), p1);
		verify(productService, times(1)).update(p1);
	}
}
