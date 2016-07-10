package ua.name.trainee.persistent;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import ua.org.trainee.entity.Contract;
import ua.org.trainee.entity.Customer;
import ua.org.trainee.entity.IEntity;
import ua.org.trainee.entity.Location;
import ua.org.trainee.entity.Workstation;
import ua.org.trainee.exception.EntityNotFoundException;

public final class InMemoryEntityManager implements IEntityManager
{

	private static 
		Map<Class<? extends IEntity<?>>, Set<? extends IEntity<?>>> tables = new HashMap<>();

	static
	{
		tables.put(Location.class, ConcurrentHashMap.<Location> newKeySet());
		tables.put(Workstation.class, ConcurrentHashMap.<Workstation> newKeySet());
		tables.put(Customer.class, ConcurrentHashMap.<Customer> newKeySet());
		tables.put(Contract.class, ConcurrentHashMap.<Contract> newKeySet());
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E extends IEntity<?>> void persist(E entity)
	{
		((Set<E>) tables.get(entity.getClass())).add(entity);
	}

	@Override
	public <E extends IEntity<?>> void merge(E entity)
	{
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <I, E extends IEntity<I>> IEntity<I> find(Class<E> clazz, I id)
			throws EntityNotFoundException
	{
		try
		{
			return (IEntity<I>) tables.get(clazz).stream()
					.filter(e -> e.getIdentifier().equals(id))
					.findAny()
					.get();
		} catch (NoSuchElementException e)
		{
			throw new EntityNotFoundException(
					clazz + " with ID " + id + "is not found");
		}
	}

	@Override
	public <I, E extends IEntity<I>> void remove(Class<E> clazz, I id)
	{
		throw new UnsupportedOperationException();
	}

}
