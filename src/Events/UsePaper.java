package Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import me.norska.DC.Main;

public class UsePaper implements Listener{
	
	private Main plugin;
	public UsePaper(Main plugin) {
	this.plugin = plugin;
	}
	
	@EventHandler @SuppressWarnings("deprecation")
	public void onUse(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getItemInHand().getType().equals(Material.getMaterial(plugin.getConfigC().getString("Item.Material"))) && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', plugin.getConfigC().getString("Item.Name")))) {
			
			
			
			
		}
	}
		
		
		
		

}
