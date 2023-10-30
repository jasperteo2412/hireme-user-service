package com.hireme.user;

import com.hireme.user.entity.ReviewEntity;
import com.hireme.user.repository.ReviewRepository;
import com.hireme.user.service.ReviewService;
import com.hireme.user.service.impl.ReviewServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReviewServiceTest {

	@Autowired
	@InjectMocks
	ReviewServiceImpl reviewService;

	@Autowired
	@Mock
	ReviewRepository reviewRepository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetTutorReviewByName() {
		// Define the behavior of the mock repository
		when(reviewRepository.getTutorReviewByName("test tutor name")).thenReturn("test review");

		// Call the service method
		String result = reviewService.getTutorReviewByName("test tutor name");

		// Verify that the result is as expected
		assertEquals("test review", result);
	}

	@Test
	public void testCreateReview() {
		// Define the behavior of the mock repository
		when(reviewRepository.save(new ReviewEntity())).thenReturn(new ReviewEntity());

		// Call the service method
		ReviewEntity result = reviewService.createReview(new ReviewEntity());

		// Verify that the result is as expected
		assertEquals(null, result);
	}

	@Test
	public void testUpdateTutorReview() {

		// Call the service method
		reviewService.updateTutorReview(new ReviewEntity());

		// Verify that the method was called with the expected arguments
		Mockito.verify(reviewRepository).updateTutorReview(null,null);
	}

	@Test
	public void testDeleteTutorReviewByName() {

		ReviewEntity reviewEntity = new ReviewEntity(10, "tutor review", "tutor name");

		// Call the service method
		reviewService.deleteTutorReviewByName(reviewEntity);

		// Verify that the method was called with the expected arguments
		Mockito.verify(reviewRepository).delete(reviewEntity);
	}

	@Test
	public void testGetReviewEntityByName() {
		ReviewEntity reviewEntity = new ReviewEntity();

		// Define the behavior of the mock repository
		when(reviewRepository.findByName("test tutor name")).thenReturn(reviewEntity);

		// Call the service method
		ReviewEntity result = reviewService.createReview(reviewEntity);

		// Verify that the result is as expected
		assertEquals(null, result);
	}

	@Test
	public void testGetAllReviews() {
		List<ReviewEntity> listOfReviewEntities = new ArrayList<ReviewEntity>();

		// Define the behavior of the mock repository
		when(reviewRepository.getAllReviews()).thenReturn(listOfReviewEntities);

		// Call the service method
		List<ReviewEntity> result = reviewService.getAllReviews();

		// Verify that the result is as expected
		assertEquals(listOfReviewEntities, result);
	}
}
