package model.wheel;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public interface Wheel {

	public static final int[] SLOT_NUMBERS = new int[] { 0, 27, 10, 25, 29, 12, 8, 19, 31, 18, 6, 21, 33, 16, 4, 23, 35,
			14, 2, 0, 28, 9, 26, 30, 11, 7, 20, 32, 17, 5, 22, 34, 15, 3, 24, 36, 13, 1 };

	public static final int NUMBER_OF_SLOTS = SLOT_NUMBERS.length;

	public static final int LARGEST_SLOT_NUMBER = Collections
			.max(Arrays.stream(SLOT_NUMBERS).boxed().collect(Collectors.toList()));

	public int generateRandomPosition();

	public Slot moveToPosition(int position) throws IllegalArgumentException;

	public Slot nextSlot();

	public Collection<Slot> generateWheel();
}
