package com.hireme.user;

import com.hireme.user.entity.RatingEntity;
import com.hireme.user.entity.ReviewEntity;
import com.hireme.user.repository.RatingRepository;
import com.hireme.user.repository.ReviewRepository;
import com.hireme.user.service.impl.RatingServiceImpl;
import com.hireme.user.service.impl.ReviewServiceImpl;
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
class RatingServiceTest {

	@Autowired
	@InjectMocks
	RatingServiceImpl ratingService;

	@Autowired
	@Mock
	RatingRepository ratingRepository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetTutorRatingByName() {
		// Define the behavior of the mock repository
		when(ratingRepository.getTutorRatingByName("test tutor name")).thenReturn(4.0F);

		// Call the service method
		Float result = ratingService.getTutorRatingByName("test tutor name");

		// Verify that the result is as expected
		assertEquals(4.0F, result);
	}

	@Test
	public void testDeleteTutorReviewByName() {

		RatingEntity ratingEntity = new RatingEntity(10, 3.5F, "tutor name");

		// Call the service method
		ratingService.deleteTutorRatingByName(ratingEntity);

		// Verify that the method was called with the expected arguments
		Mockito.verify(ratingRepository).delete(ratingEntity);
	}


	@Test
	public void testGetAllRatings() {
		List<RatingEntity> listOfRatingEntities = new ArrayList<RatingEntity>();

		// Define the behavior of the mock repository
		when(ratingRepository.getAllRatings()).thenReturn(listOfRatingEntities);

		// Call the service method
		List<RatingEntity> result = ratingService.getAllRatings();

		// Verify that the result is as expected
		assertEquals(listOfRatingEntities, result);
	}
}
