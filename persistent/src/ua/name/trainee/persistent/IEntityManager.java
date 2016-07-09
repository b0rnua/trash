package ua.name.trainee.persistent;

import ua.org.trainee.entity.IEntity;

public interface IEntityManager
{
	<T> void persist(IEntity<T> entity);
	<T> void merge(IEntity<T> entity);
	<T> IEntity<T> find(Class<? extends IEntity<T>> clazz, T id);
	<T> void remove(Class<? extends IEntity<T>> clazz, T id);
}
