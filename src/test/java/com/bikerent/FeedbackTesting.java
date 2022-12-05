package com.bikerent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bikerent.dao.FeedbackRepository;
import com.bikerent.entities.Feedback;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FeedbackTesting {

	@Autowired
	public FeedbackRepository prepo;

	@Test
	@Order(1)
	public void testCreatefeedback() {
		Feedback fb = new Feedback();
		fb.setId(1);
		fb.setName("vikas");
		fb.setBikeName("Honda");
		fb.setBikeNum("KA-03-1234");
		fb.setRatings(5);
		fb.setReviews("good");
		Feedback save = prepo.save(fb);
		assertNotNull(save);

	}

	@Test
	@Order(2)
	public void testReadAll() {
		List<Feedback> list = prepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void getfeedback() {
		Feedback list = prepo.findById(1).get();
		assertEquals("vikas", list.getName());

	}

}
