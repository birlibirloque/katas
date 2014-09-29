package com.birlibirloque.katas.java.tripservicekata.trip;

import java.util.List;

import com.birlibirloque.katas.java.tripservicekata.exception.DependendClassCallDuringUnitTestException;
import com.birlibirloque.katas.java.tripservicekata.user.User;

public class TripDAO {

	public static List<Trip> findTripsByUser(User user) {
		throw new DependendClassCallDuringUnitTestException(
				"TripDAO should not be invoked on an unit test.");
	}
	
}
