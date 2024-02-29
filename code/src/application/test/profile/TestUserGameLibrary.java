package application.test.profile;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.model.profile.UserGameLibrary;
import application.model.profile.UserProfile;

class TestUserGameLibrary {

	@Test
	void testInvalidConstruction() {
		assertThrows(IllegalArgumentException.class, () -> new UserGameLibrary(null));
	}
	
	@Test
	void testValidConstrution() {
		UserProfile user = new UserProfile();
		UserGameLibrary gameLibrary = new UserGameLibrary(user);
		
		assertEquals(user, gameLibrary.getUser());
		assertEquals(user.getAllOwnedGames(), gameLibrary.getGameLibrary());
	}

}