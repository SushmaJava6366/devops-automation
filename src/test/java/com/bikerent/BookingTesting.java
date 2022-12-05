package com.bikerent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bikerent.dao.BookingRepository;
import com.bikerent.entities.Booking;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookingTesting {

	@Autowired
	public BookingRepository repo;

	@Test

	@Order(1)
	public void testCreateBooking() {
		Booking bk = new Booking();
		bk.setId(7);
		bk.setBikename("Honda");
		bk.setBikenum("KA-11 HU 9233");
		bk.setFromdate("2022-11-03");
		bk.setTodate("2022-11-04");
		bk.setUname("Priya");
		bk.setPhone("9956473322");
		bk.setGender("female");
		bk.setAdvanceamount(2000);
		Booking save = repo.save(bk);
		assertNotNull(save);

	}

	@Test

	@Order(2)
	public void testReadAll() {
		List<Booking> list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test

	@Order(3)
	public void getSinglebk() {
		Booking list = repo.findById(7).get();
		assertEquals("Honda", list.getBikename());

	}

	@Test
	@Order(4)
	public void testUpdate() {
		Booking bk = repo.findById(7).get();
		bk.setBikename("Hero");
		repo.save(bk);
		assertNotEquals("Honda", repo.findById(7).get().getBikename());
	}

	@Test

	@Order(5)
	public void testDelete() {
		repo.deleteById(7);
		assertThat(repo.existsById(7)).isFalse();
	}

}
