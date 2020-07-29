package model.wheel;

public interface Slot {

	public int getPosition();

	public SlotColor getColor();

	public int getNumber();

	@Override
	public boolean equals(Object obj);

	@Override
	public int hashCode();

	@Override
	public String toString();
}
