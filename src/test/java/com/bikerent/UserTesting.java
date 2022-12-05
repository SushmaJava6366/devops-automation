package com.bikerent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bikerent.dao.Dao;
import com.bikerent.entities.UserLogin;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class UserTesting {
	@Autowired
	private Dao dao;

	@Test
	@Order(1)
	public void SavaData() {
		UserLogin user = new UserLogin();
		user.setId(1);
		user.setName("vikas");
		user.setGmail("vikas12@gmail.com");
		user.setPassword("vikas12");
		user.setPnumber("9855443985");
		dao.save(user);
		assertNotNull(dao.findById(1));
	}

	@Test
	@Order(2)
	public void getList() {
		List<UserLogin> obj = dao.findAll();
		assertThat(obj).size().isGreaterThan(0);
	}
}
