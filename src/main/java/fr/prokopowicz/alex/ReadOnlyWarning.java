package fr.prokopowicz.alex;

import fr.prokopowicz.alex.commands.ReadOnlyCommand;
import fr.prokopowicz.alex.listeners.PlayerInteractionListener;
import fr.prokopowicz.alex.listeners.PlayerWarningListener;
import fr.prokopowicz.alex.managers.ReadOnlyPlayersManager;
import fr.zcraft.zlib.core.ZPlugin;

/**
 * Created by Alexandre on 03/06/2015.
 */
public class ReadOnlyWarning extends ZPlugin {

	private static ReadOnlyWarning instance;

	private ReadOnlyPlayersManager readOnlyPlayersManager;

	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(new PlayerWarningListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerInteractionListener(), this);
		getServer().getPluginCommand("ro").setExecutor(new ReadOnlyCommand());

		readOnlyPlayersManager = new ReadOnlyPlayersManager();
	}


	public ReadOnlyPlayersManager getReadOnlyPlayersManager() {
		return readOnlyPlayersManager;
	}

	public static ReadOnlyWarning getInstance() {
		return instance;
	}
}
