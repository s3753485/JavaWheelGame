package model.wheel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WheelImpl implements Wheel {
	public static final List<Slot> slots = new ArrayList<Slot>();

	private int position;

	public WheelImpl() {
		super();
	}

	@Override
	public int generateRandomPosition() {

		// generate a random number
		int randomNum = ThreadLocalRandom.current().nextInt(1, NUMBER_OF_SLOTS);
		return randomNum;
	}

	@Override
	public Slot moveToPosition(int position) throws IllegalArgumentException {
		Slot slot = null;
		int slotPosition = 0;

		try {
			// move to the requested position
			this.position = position;
			slotPosition = this.position - 1;
			slot = slots.get(slotPosition);

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return slot;
	}

	@Override
	public Slot nextSlot() {

		// initialize variables
		Slot slot = null;

		// increment the position
		this.position++;

		try {

			// if the position is equal to the number of slots, set position to 0
			if (position == NUMBER_OF_SLOTS)
				this.position = 0;

			// return the slots position.
			slot = slots.get(position);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return slot;

	}

	// Generate the wheel.

	@Override
	public Collection<Slot> generateWheel() {
		slots.add(new SlotImpl(1, SlotColor.GREEN00, 00));
		slots.add(new SlotImpl(2, SlotColor.RED, 27));
		slots.add(new SlotImpl(3, SlotColor.BLACK, 10));
		slots.add(new SlotImpl(4, SlotColor.RED, 25));
		slots.add(new SlotImpl(5, SlotColor.BLACK, 29));
		slots.add(new SlotImpl(6, SlotColor.RED, 12));
		slots.add(new SlotImpl(7, SlotColor.BLACK, 8));
		slots.add(new SlotImpl(8, SlotColor.RED, 19));
		slots.add(new SlotImpl(9, SlotColor.BLACK, 31));
		slots.add(new SlotImpl(10, SlotColor.RED, 18));
		slots.add(new SlotImpl(11, SlotColor.BLACK, 6));
		slots.add(new SlotImpl(12, SlotColor.RED, 21));
		slots.add(new SlotImpl(13, SlotColor.BLACK, 33));
		slots.add(new SlotImpl(14, SlotColor.RED, 16));
		slots.add(new SlotImpl(15, SlotColor.BLACK, 4));
		slots.add(new SlotImpl(16, SlotColor.RED, 23));
		slots.add(new SlotImpl(17, SlotColor.BLACK, 35));
		slots.add(new SlotImpl(18, SlotColor.RED, 14));
		slots.add(new SlotImpl(19, SlotColor.BLACK, 2));
		slots.add(new SlotImpl(20, SlotColor.GREEN0, 0));
		slots.add(new SlotImpl(21, SlotColor.BLACK, 28));
		slots.add(new SlotImpl(22, SlotColor.RED, 9));
		slots.add(new SlotImpl(23, SlotColor.BLACK, 26));
		slots.add(new SlotImpl(24, SlotColor.RED, 30));
		slots.add(new SlotImpl(25, SlotColor.BLACK, 11));
		slots.add(new SlotImpl(26, SlotColor.RED, 7));
		slots.add(new SlotImpl(27, SlotColor.BLACK, 20));
		slots.add(new SlotImpl(28, SlotColor.RED, 32));
		slots.add(new SlotImpl(29, SlotColor.BLACK, 17));
		slots.add(new SlotImpl(30, SlotColor.RED, 5));
		slots.add(new SlotImpl(31, SlotColor.BLACK, 22));
		slots.add(new SlotImpl(32, SlotColor.RED, 34));
		slots.add(new SlotImpl(33, SlotColor.BLACK, 15));
		slots.add(new SlotImpl(34, SlotColor.RED, 3));
		slots.add(new SlotImpl(35, SlotColor.BLACK, 24));
		slots.add(new SlotImpl(36, SlotColor.RED, 36));
		slots.add(new SlotImpl(37, SlotColor.BLACK, 13));
		slots.add(new SlotImpl(38, SlotColor.RED, 1));
		return slots;
	}
}
