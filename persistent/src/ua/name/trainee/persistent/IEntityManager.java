package ua.name.trainee.persistent;

import java.util.function.Predicate;

import ua.org.trainee.exception.EntityNotFoundException;

public interface IEntityManager<T>
{
	<E extends T> void persist(E entity);
	<E extends T> void merge(E entity);
	<I, E extends T> T find(Class<E> clazz, Predicate<T> p) 
			throws EntityNotFoundException;
	<I, E extends T> void remove(Class<E> clazz, Predicate<T> p);
}
