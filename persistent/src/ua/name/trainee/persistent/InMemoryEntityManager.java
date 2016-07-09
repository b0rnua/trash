package ua.name.trainee.persistent;

import java.util.List;
import java.util.Map;

import ua.org.trainee.entity.IEntity;

public final class InMemoryEntityManager implements IEntityManager
{

	Map<Class<? extends IEntity<?>>, List<? extends IEntity<?>>> tables;
	
	public InMemoryEntityManager(Storage storage)
	{
		this.tables = Storage.INSTANCE.tables;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <E extends IEntity<?>> void persist(E entity)
	{
		((List<E>) this.tables.get(entity.getClass())).add(entity);
	}

	@Override
	public <E extends IEntity<?>> void merge(E entity)
	{
		throw new UnsupportedOperationException();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <I, E extends IEntity<I>> IEntity<I> find(Class<E> clazz, I id)
	{
		return (IEntity<I>) tables.get(clazz).stream()
				.filter(e -> e.getIdentifier().equals(id))
				.findAny()
				.get();
	}
	
	@Override
	public <I, E extends IEntity<I>> void remove(Class<E> clazz, I id)
	{
		throw new UnsupportedOperationException();
	}

}
