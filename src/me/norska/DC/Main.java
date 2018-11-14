package me.norska.DC;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import Events.PlayerDeath;

public class Main extends JavaPlugin {
	
	Listener listener = new PlayerDeath(this);
	
	public String v = "1.0.0";
	public ItemStack cert;
	
	public File config = null;
	public YamlConfiguration configC = new YamlConfiguration();
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§7===================================================================");
		Bukkit.getConsoleSender().sendMessage(" ");
		Bukkit.getConsoleSender().sendMessage(" §6DeathCertificates §7// §6VERSION 1.0.0 (1.8x - 1.13x) §7// §6STATUS: §fRUNNING!§r");
		Bukkit.getConsoleSender().sendMessage(" ");
		Bukkit.getConsoleSender().sendMessage("§7===================================================================");
		
		config = new File(getDataFolder(), "config.yml");
		mkdir();
		loadYamlulus();
		Bukkit.getPluginManager().registerEvents(new PlayerDeath(this), this);
		
	}
	
	public void mkdir() {
		if(!config.exists()) {
			saveResource("config.yml", false);
			Bukkit.getConsoleSender().sendMessage(" ");
			Bukkit.getConsoleSender().sendMessage("§cDeathCertificates: §fYAML §7> §f[§aconfig.yml§f] generated!");
			Bukkit.getConsoleSender().sendMessage(" "); 
		}
	}
	
	public void loadConfig() {
		saveDefaultConfig();
	}
	
	public void loadYamlulus() {
		try {
			configC.load(config);
		} catch (IOException | InvalidConfigurationException e) {
			Bukkit.getConsoleSender().sendMessage(" ");
			Bukkit.getConsoleSender().sendMessage("§cDeathCertificates §fYAML §7> §f[§cconfig.yml§f] failed to load!");
			Bukkit.getConsoleSender().sendMessage(" ");
			e.printStackTrace();
		}
	}
	
	public YamlConfiguration getConfigC(){
		return configC;
	}
	
	public void saveConfigC() {
		try {
			configC.save(config);
		} catch (IOException e) {
			Bukkit.getConsoleSender().sendMessage(" ");
			Bukkit.getConsoleSender().sendMessage("§cDeathCertificates §fYAML §7> §f[§cconfig.yml§f] failed to save!");
			Bukkit.getConsoleSender().sendMessage(" ");
			e.printStackTrace();
		}
	}
	
	public void reloadConfigC() {
		configC = YamlConfiguration.loadConfiguration(config);
	}

}
