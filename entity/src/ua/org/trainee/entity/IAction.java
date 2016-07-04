package ua.org.trainee.entity;

public interface IAction<T> extends IEntity<T>
{
	IEntity<?> getParent();
}
