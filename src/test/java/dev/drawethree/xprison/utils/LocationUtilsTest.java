package dev.drawethree.xprison.utils;

import org.bukkit.Location;
import org.bukkit.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static dev.drawethree.xprison.utils.location.LocationUtils.INVALID_LOCATION;
import static dev.drawethree.xprison.utils.location.LocationUtils.toXYZW;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LocationUtilsTest {

	private Location location;
	private World mockWorld;

	@BeforeEach
	public void setUp() {
		// No need to mock the Location class anymore
		this.mockWorld = mock(World.class); // Still mock World
	}

	@Test
	public void test_success_toXYZW_0_0_0_world() {
		// Set up real Location object with mocked World
		when(mockWorld.getName()).thenReturn("world");

		// Create the real Location object
		this.location = new Location(mockWorld, 0, 0, 0);

		String expected = "X: 0, Y: 0, Z: 0, World: world";
		String actual = toXYZW(location);

		assertEquals(expected, actual);
	}

	@Test
	public void test_success_toXYZW_null() {
		// Test for null Location
		this.location = null;

		String actual = toXYZW(location);

		assertEquals(INVALID_LOCATION, actual);
	}
}
