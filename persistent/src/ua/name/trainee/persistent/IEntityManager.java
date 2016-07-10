package ua.name.trainee.persistent;

import ua.org.trainee.entity.IEntity;
import ua.org.trainee.exception.EntityNotFoundException;

public interface IEntityManager
{
	<E extends IEntity<?>> void persist(E entity);
	<E extends IEntity<?>> void merge(E entity);
	<I, E extends IEntity<I>> IEntity<I> find(Class<E> clazz, I id) throws EntityNotFoundException;
	<I, E extends IEntity<I>> void remove(Class<E> clazz, I id);
}
