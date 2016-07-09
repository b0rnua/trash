package ua.name.trainee.persistent;

import java.util.List;
import java.util.Map;

import ua.org.trainee.entity.IEntity;
public enum Storage
{ 
	INSTANCE;

	@SuppressWarnings("rawtypes")
	Map<Class<? extends IEntity<?>>, List<? extends IEntity>> tables;
}
