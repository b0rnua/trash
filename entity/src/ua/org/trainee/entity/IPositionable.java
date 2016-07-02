package ua.org.trainee.entity;

public interface IPositionable<T> extends IEntity<T>
{
	Location getLocation();
	Workstation getWorkstation();
	String getURN();
}
