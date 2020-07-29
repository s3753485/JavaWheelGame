package model.wheel;

import java.util.Objects;

public class SlotImpl implements Slot {

	private int position;
	private int slotNumber;
	private SlotColor color;

	public SlotImpl(int position, SlotColor color, int number) {

		super();
		this.position = position;
		this.color = color;
		this.slotNumber = number;

	}

	@Override
	public boolean equals(Object obj) {

		// if this is an object return true
		if (this == obj)
			return true;

		// if this is not null return true
		if (obj == null)
			return false;

		// if this is not an instance of Slot, return false
		if (!(obj instanceof Slot))
			return false;

		SlotImpl s = (SlotImpl) obj;

		return this.position == s.getPosition() && this.getColor().equals(s.getColor())
				&& this.getNumber() == s.getNumber();

	}

	public int getPosition() {

		// return the slots position
		return this.position;
	}

	@Override
	public SlotColor getColor() {

		// return the color
		return this.color;
	}

	@Override
	public int getNumber() {

		// return the slotNumber
		return this.slotNumber;
	}

	@Override
	public int hashCode() {

		return Objects.hash(position, color, slotNumber);
	}

	@Override
	public String toString() {

		if (this.position < 10 && this.position != 1) {
			return String.format("Slot position=0%d, color=%s, number=%d", position, color, slotNumber);

		} else if (this.position == 1) {
			return String.format("Slot position=0%d, color=%s, number=0%d", position, color, slotNumber);
		} else {
			return String.format("Slot position=%d, color=%s, number=%d", position, color, slotNumber);
		}
	}

}