package ua.name.trainee.persistent;

import java.util.Arrays;
import java.util.List;

public class PersistentConfig implements IConfig
{
	private final static List<String> managedEntities = Arrays.asList(
			"ua.org.trainee.entity.Location",
			"ua.org.trainee.entity.Workstation",
			"ua.org.trainee.entity.Customer",
			"ua.org.trainee.entity.Contract");

	@Override
	public List<String> getEntities()
	{
		return managedEntities;
	}
}
