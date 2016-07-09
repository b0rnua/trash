package ua.name.trainee.persistent;

import ua.org.trainee.entity.IEntity;

public interface IEntityManager
{
	void persist(IEntity<?> entity);
	void merge(IEntity<?> entity);
	<T> IEntity<T> find(Class<? extends IEntity<T>> clazz, T id);
	<T> void remove(Class<? extends IEntity<T>> clazz, T id);
}
