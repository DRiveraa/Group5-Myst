/*
 * 
 */
package application.test.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.model.game.Game;
import application.model.game.Genre;
import application.model.profile.UserProfile;

public class TestUserProfile {

	private UserProfile userProfile;
	private static final String GAMEONE = "Game1";
	private static final String GAMETWO = "Game2";

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		this.userProfile = new UserProfile();
	}

	/**
	 * Test default constructor.
	 */
	@Test
	public void testDefaultConstructor() {
		assertNotNull(this.userProfile.getAllOwnedGames());
		assertNotNull(this.userProfile.getAllLikedGames());
		assertNotNull(this.userProfile.getAllDislikedGames());
		assertTrue(this.userProfile.getAllOwnedGames().isEmpty());
		assertTrue(this.userProfile.getAllLikedGames().isEmpty());
		assertTrue(this.userProfile.getAllDislikedGames().isEmpty());
		assertTrue(this.userProfile.getPreferredGenres().isEmpty());
	}

	/**
	 * Test parameterized constructor.
	 */
	@Test
	public void testParameterizedConstructor() {
		var name = "testUser";
		var password = "testPassword";

		var userProfile = new UserProfile(name, password);

		assertEquals(name, userProfile.getUsername());
		assertEquals(password, userProfile.getPassword());
	}

	/**
	 * Test set all owned games.
	 */
	@Test
	public void testSetAllOwnedGames() {
		var ownedGames = new ArrayList<Game>();
		var genreList = new ArrayList<Genre>();
		genreList.add(Genre.ACTION);
		genreList.add(Genre.ADVENTURE);
		var gameOne = new Game(GAMEONE, genreList, 001);
		var gameTwo = new Game(GAMETWO, genreList, 003);
		ownedGames.add(gameOne);
		ownedGames.add(gameTwo);

		this.userProfile.setAllOwnedGames(ownedGames);

		assertEquals(ownedGames, this.userProfile.getAllOwnedGames());

	}

	/**
	 * Test all liked games.
	 */
	@Test
	public void testSetAllLikedGames() {
		var likedGames = new ArrayList<Game>();
		var genreList = new ArrayList<Genre>();
		genreList.add(Genre.ACTION);
		genreList.add(Genre.ADVENTURE);
		var gameOne = new Game(GAMEONE, genreList, 001);
		var gameTwo = new Game(GAMETWO, genreList, 003);
		likedGames.add(gameOne);
		likedGames.add(gameTwo);

		this.userProfile.setAllLikedGames(likedGames);

		assertEquals(likedGames, this.userProfile.getAllLikedGames());
	}

	/**
	 * Test set all disliked games.
	 */
	@Test
	public void testSetAllDislikedGames() {
		var disLikedGames = new ArrayList<Game>();
		var genreList = new ArrayList<Genre>();
		genreList.add(Genre.ACTION);
		genreList.add(Genre.ADVENTURE);
		var gameOne = new Game(GAMEONE, genreList, 001);
		var gameTwo = new Game(GAMETWO, genreList, 003);
		disLikedGames.add(gameOne);
		disLikedGames.add(gameTwo);

		this.userProfile.setAllDislikedGames(disLikedGames);

		assertEquals(disLikedGames, this.userProfile.getAllDislikedGames());
	}

	/**
	 * Test set username.
	 */
	@Test
	public void testSetUsername() {
		var username = "user1";
		this.userProfile.setUsername(username);

		assertEquals(username, this.userProfile.getUsername());
	}

	/**
	 * Test set password.
	 */
	@Test
	public void testSetPassword() {
		var password = "password1";
		this.userProfile.setPassword(password);

		assertEquals(password, this.userProfile.getPassword());
	}

	/**
	 * Test set all owned games null list.
	 */
	@Test
	public void testSetAllOwnedGamesNullList() {
		assertThrows(NullPointerException.class, () -> this.userProfile.setAllOwnedGames(null));
	}

	/**
	 * Test set all liked games null list.
	 */
	@Test
	public void testSetAllLikedGamesNullList() {
		assertThrows(NullPointerException.class, () -> this.userProfile.setAllLikedGames(null));
	}

	/**
	 * Test set all disliked games null list.
	 */
	@Test
	public void testSetAllDislikedGamesNullList() {
		assertThrows(NullPointerException.class, () -> this.userProfile.setAllDislikedGames(null));
	}

	/**
	 * Test set username null.
	 */
	@Test
	public void testSetUsernameNull() {
		assertThrows(NullPointerException.class, () -> this.userProfile.setUsername(null));
	}

	/**
	 * Test set username blank.
	 */
	@Test
	public void testSetUsernameBlank() {
		assertThrows(IllegalArgumentException.class, () -> this.userProfile.setUsername(""));
	}

	/**
	 * Test set password null.
	 */
	@Test
	public void testSetPasswordNull() {
		assertThrows(NullPointerException.class, () -> this.userProfile.setPassword(null));
	}

	/**
	 * Test set password blank.
	 */
	@Test
	public void testSetPasswordBlank() {
		assertThrows(IllegalArgumentException.class, () -> this.userProfile.setPassword(""));
	}

	/**
	 * Test constructor with null username.
	 */
	@Test
	public void testConstructorWithNullUsername() {
		assertThrows(NullPointerException.class, () -> new UserProfile(null, "testPassword"));
	}

	/**
	 * Test constructor with blank username.
	 */
	@Test
	public void testConstructorWithBlankUsername() {
		assertThrows(IllegalArgumentException.class, () -> new UserProfile("", "testPassword"));
	}

	/**
	 * Test constructor with null password.
	 */
	@Test
	public void testConstructorWithNullPassword() {
		assertThrows(NullPointerException.class, () -> new UserProfile("testUser", null));
	}

	/**
	 * Test constructor with blank password.
	 */
	@Test
	public void testConstructorWithBlankPassword() {
		assertThrows(IllegalArgumentException.class, () -> new UserProfile("testUser", ""));
	}
	
	/**
	 * test the set preferred genres method
	 */
	@Test
	public void testSetPreferredGenresIsNull() {
		UserProfile user = new UserProfile();
		assertThrows(IllegalArgumentException.class, () -> user.setPreferredGenres(null));
	}
	
	/**
	 * Test preferred genres.
	 */
	@Test
	public void testSetPreferredGenres() {
		var preferredGenres = new ArrayList<Genre>();
		preferredGenres.add(Genre.ACTION);
		preferredGenres.add(Genre.ADVENTURE);

		this.userProfile.setPreferredGenres(preferredGenres);

		assertEquals(preferredGenres, this.userProfile.getPreferredGenres());
	}

}
