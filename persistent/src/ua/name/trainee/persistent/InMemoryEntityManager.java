package ua.name.trainee.persistent;

import java.util.List;
import java.util.Map;

import ua.org.trainee.entity.IEntity;

public final class InMemoryEntityManager implements IEntityManager
{

	private final Map<Class<? extends IEntity<?>>, List<IEntity<?>>> tables;
	
	public InMemoryEntityManager(Storage storage)
	{
		this.tables = Storage.INSTANCE.tables;
	}
	
	@Override
	public void persist(IEntity<?> entity)
	{
		this.tables.get(entity.getClass()).add(entity);
	}

	@Override
	public void merge(IEntity<?> entity)
	{
		throw new UnsupportedOperationException();
	}


	@Override
	public <T> IEntity<T> find(Class<? extends IEntity<T>> clazz, T id)
	{
		IEntity<?> res;
		for (IEntity<?> entity : this.tables.get(clazz))
		{
			if(entity.getIdentifier() == id) {
				return (IEntity<T>) entity;
			}
			
		}
		return null;
		 
	}
	
	@Override
	public <T> void remove(Class<? extends IEntity<T>> clazz, T id)
	{
		throw new UnsupportedOperationException();
	}

}
