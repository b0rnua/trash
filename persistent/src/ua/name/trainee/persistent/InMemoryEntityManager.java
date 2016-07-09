package ua.name.trainee.persistent;

import java.util.List;
import java.util.Map;

import ua.org.trainee.entity.IEntity;

public final class InMemoryEntityManager implements IEntityManager
{

	@SuppressWarnings("rawtypes")
	Map<Class<? extends IEntity<?>>, List<? extends IEntity>> tables;
	
	public InMemoryEntityManager(Storage storage)
	{
		this.tables = Storage.INSTANCE.tables;
	}
	
	@Override
	public <T> void persist(IEntity<T> entity)
	{
//		this.tables.get(entity.getClass()).add(entity);
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> void merge(IEntity<T> entity)
	{
		throw new UnsupportedOperationException();
	}


	@SuppressWarnings("unchecked")
	@Override
	public <T> IEntity<T> find(Class<? extends IEntity<T>> clazz, final T id)
	{
		return tables.get(clazz).stream()
				.filter(e -> e.getIdentifier().equals(id))
				.findFirst()
				.get();
	 
	}
	
	@Override
	public <T> void remove(Class<? extends IEntity<T>> clazz, T id)
	{
		throw new UnsupportedOperationException();
	}

}
