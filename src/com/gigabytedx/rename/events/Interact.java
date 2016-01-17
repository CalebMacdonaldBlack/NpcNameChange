package com.gigabytedx.rename.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import com.gigabytedx.namechange.Main;
public class Interact implements Listener {

	Main plugin;

	public Interact(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onClick(PlayerInteractAtEntityEvent event){
		Player player = (Player) event.getPlayer();
		Entity entity = event.getRightClicked();
		
		if(plugin.nameSetting.containsKey(player) && entity instanceof LivingEntity){
			entity.setCustomName(ChatColor.GOLD + plugin.nameSetting.get(player));
			entity.setCustomNameVisible(true);
			plugin.nameSetting.remove(player);
			player.sendMessage(ChatColor.GREEN + plugin.getDescription().getName() + ChatColor.BLUE + "Name change successful");
		}
		
	}
}
