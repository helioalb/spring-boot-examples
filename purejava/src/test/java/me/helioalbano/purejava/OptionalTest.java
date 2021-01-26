package me.helioalbano.purejava;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class OptionalTest {

	@Test
	void whenOptionalReturnsEmpty() {
		Optional<User> emptyUser = Optional.empty();
		
		assertThrows(NoSuchElementException.class, () -> {
			emptyUser.get();
		});
	}
	
	@Test
	void whenOptionReturnNullFor_Of() {
		Optional<User> nullUser = Optional.of(null);
		
		assertThrows(NullPointerException.class, () -> {
			nullUser.get();
		});
	}

	@Test
	void returningAObjectUsignOfNullableAsNull() {
		Optional<User> obj = Optional.ofNullable(null);
		
		assertTrue(obj.isEmpty());
	}
	
	@Test
	void returningAObjectUsingOfNullableWithAValidObject() {
		User john = new User("John Doe");
		
		Optional<User> user = Optional.ofNullable(john);
		
		assertTrue(user.isPresent());
		assertEquals("John Doe", user.get().getName());
	}
	
	@Test
	void usingLambda_ifPresent() {
		User john = new User("John Doe");
		
		Optional<User> user = Optional.ofNullable(john);
		
		user.ifPresent(u -> assertEquals("John Doe", u.getName()));
	}
	
	@Test
	void returningADefaultValue() {
		User nullUser = null;
		User john = new User("John Doe");
		
		User user = Optional.ofNullable(nullUser).orElse(john);
		
		assertEquals("John Doe", user.getName());
	}
	
	@Test
	void whenOriginalExistsReturnIt() {
		User helio = new User("Helio");
		User john = new User("John Doe");
		
		User user = Optional.ofNullable(helio).orElse(john);
		
		assertEquals("Helio", user.getName());
	}
}

class User {
	private String name;
	
	public User(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
