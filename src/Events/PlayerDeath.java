package Events;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.norska.DC.Main;

public class PlayerDeath implements Listener{
	
	private Main plugin;
	public PlayerDeath(Main plugin) {
	this.plugin = plugin;
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if(e.getEntity().getKiller() instanceof Player) {
			
			Date now = new Date();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			
			plugin.cert = new ItemStack(Material.getMaterial(plugin.getConfigC().getString("Item.Material")));
			ItemMeta cm = plugin.cert.getItemMeta();
			cm.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfigC().getString("Item.Name")));
			ArrayList<String> lore = new ArrayList<String>();
			for (String line : plugin.getConfigC().getStringList("Item.Lore")) {
				lore.add(ChatColor.translateAlternateColorCodes('&', line).replace("%killer", e.getEntity().getKiller().getName()).replace("%killed", e.getEntity().getName()).replace("%date", format.format(now)));
			}
			cm.setLore(lore);
			if(plugin.getConfigC().getBoolean("Item.Glow")) {
				cm.addEnchant(Enchantment.DURABILITY, 1, true);
				cm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}
			plugin.cert.setItemMeta(cm);
		     e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), plugin.cert);
		}
	}
	
}
