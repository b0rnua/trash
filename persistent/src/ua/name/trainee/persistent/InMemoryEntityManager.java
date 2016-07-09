package ua.name.trainee.persistent;

import ua.org.trainee.entity.IEntity;

public class InMemoryEntityManager implements IEntityManager
{

	@Override
	public void persist(IEntity<?> entity)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public void merge(IEntity<?> entity)
	{
		throw new UnsupportedOperationException();
	}


	@Override
	public <T> IEntity<T> find(Class<? extends IEntity<T>> clazz, T id)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public <T> void remove(Class<? extends IEntity<T>> clazz, T id)
	{
		throw new UnsupportedOperationException();
	}

}
