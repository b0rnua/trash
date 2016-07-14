package ua.name.trainee.persistent;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ua.org.trainee.exception.EntityNotFoundException;

public final class InMemoryEntityManager<T> implements IEntityManager<T>
{

	private Map<Class<?>, Set<? extends T>> tables;

	public InMemoryEntityManager(IConfig config)
	{
		ThrowingFunction<String, Class<?>> function = Class::forName;
		tables = config.getEntities().stream()
				.collect(Collectors.toMap(function, useless -> ConcurrentHashMap.newKeySet()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E extends T> void persist(E entity)
	{
		((Set<E>) tables.get(entity.getClass())).add(entity);
	}

	@Override
	public <E extends T> void merge(E entity)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public <I, E extends T> T find(Class<E> clazz, Predicate<T> p)
			throws EntityNotFoundException
	{
		try
		{
			return tables.get(clazz).stream()
					.filter(p)
					.findAny()
					.get();
		} catch (NoSuchElementException e)
		{
			throw new EntityNotFoundException(
					clazz + " is not found");
		}
	}

	@Override
	public <I, E extends T> void remove(Class<E> clazz, Predicate<T> p)
	{
		throw new UnsupportedOperationException();
	}

}
