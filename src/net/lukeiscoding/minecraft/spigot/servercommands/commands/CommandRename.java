package net.lukeiscoding.minecraft.spigot.servercommands.commands;
/*
Copyright (C) 2023  Luke Is Coding
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import net.lukeiscoding.minecraft.spigot.servercommands.ServerCommands;
import net.lukeiscoding.minecraft.spigot.servercommands.util.PluginPermissions;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandRename implements CommandExecutor {

    private static final ServerCommands plugin = ServerCommands.getPlugin(ServerCommands.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // cast player to sender
        Player p = (Player) sender;

        // check if sender is a player
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "You need to be a player to use this command!");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("rename") && p.hasPermission(PluginPermissions.COMMAND_RENAME_NODE.getPermissionNode())) {
            // check if the player is not holding anything
            if (p.getMainHand().equals(Material.AIR)) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("rename-not-holding-item")));
            }

            // get the item in main hand
            ItemStack itemStack = p.getInventory().getItemInMainHand();
            ItemMeta itemMeta = itemStack.getItemMeta();

            // create string builder
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                builder.append(args[i] + " ");
            }

            itemMeta.setDisplayName(builder.toString().replaceAll("&", String.valueOf(ChatColor.COLOR_CHAR)));
            itemStack.setItemMeta(itemMeta);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("rename-success")));
        }

        return false;
    }
}
