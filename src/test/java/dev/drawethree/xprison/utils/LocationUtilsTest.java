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
		this.mockWorld = mock(World.class);
	}

	@Test
	public void test_success_toXYZW_0_0_0_world() {
		when(mockWorld.getName()).thenReturn("world");

		this.location = new Location(mockWorld, 0, 0, 0);

		String expected = "X: 0, Y: 0, Z: 0, World: world";
		String actual = toXYZW(location);

		assertEquals(expected, actual);
	}

	@Test
	public void test_success_toXYZW_null() {
		this.location = null;

		String actual = toXYZW(location);

		assertEquals(INVALID_LOCATION, actual);
	}
}
