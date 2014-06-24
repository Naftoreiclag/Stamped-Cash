package naftoreiclag.stampedcash;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MainCommand implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args)
	{
		if(!(sender instanceof Player))
		{
			sender.sendMessage(ChatColor.RED + "Only players have inventories, so only players can use money.");
			return true;
		}
		
		Player player = (Player) sender;
		
		String subCommand = args[0];
		if(subCommand.equalsIgnoreCase("mint"))
		{
			if(args.length < 2)
			{
				player.sendMessage(ChatColor.RED + "Specify an amount.");
				return true;
			}
			
			try
			{
				double amount = Double.parseDouble(args[1]);
				
				if(amount <= 0.0d)
				{
					player.sendMessage(ChatColor.RED + "We cannot print worthless money.");
					return true;
				}
			}
			catch(NumberFormatException e)
			{
				player.sendMessage(ChatColor.RED + args[1] + " is not a valid number.");
				return true;
			}
			
			return true;
		}
		
		ItemStack item = new ItemStack(Material.GOLD_NUGGET);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(Config.moneyPrefix + "8.23" + Config.moneySuffix);
		itemmeta.setLore(new ArrayList<String>(Arrays.asList(Config.serialPrefix + "34291" + Config.serialSuffix)));
		item.setItemMeta(itemmeta);
		player.getInventory().addItem(item);

		return true;
	}

}
