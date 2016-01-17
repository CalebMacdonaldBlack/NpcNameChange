package com.gigabytedx.rename.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gigabytedx.namechange.Main;

public class SetNpcName implements CommandExecutor {

	private Main plugin;

	public SetNpcName(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (!player.hasPermission("gigabytedx.setnpcname")) {
				return false;
			}
			if (args.length == 1) {
				plugin.nameSetting.put(player, args[0]);
				player.sendMessage(ChatColor.GREEN + plugin.getDescription().getName() + ChatColor.BLUE
						+ "Right click an npc to change their name");
			} else {
				player.sendMessage(ChatColor.RED + "Syntax: /setnpcname <name of npc>");
			}
		}
		return false;
	}
}
