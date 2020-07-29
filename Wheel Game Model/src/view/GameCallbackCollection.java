package view;


public interface GameCallbackCollection
{

	public void registerCallback(GameCallback callback);
	
	public void removeCallback(GameCallback callback);	
}
