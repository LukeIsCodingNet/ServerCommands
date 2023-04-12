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
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class CommandDestroyItems implements CommandExecutor {

    private static final ServerCommands plugin = ServerCommands.getPlugin(ServerCommands.class);

    private Inventory destroyItemsGUI;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // cast sender to player
        Player p = (Player) sender;

        destroyItemsGUI = Bukkit.createInventory(null, InventoryType.CHEST, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("destroy-items-gui-title")));

        // check if the sender is a player
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "You need to be a player to use this command!");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("destroyitems") && p.hasPermission(PluginPermissions.COMMAND_DESTROY_ITEMS_NODE.getPermissionNode())) {
            p.openInventory(destroyItemsGUI);
        }

        return false;
    }

    public Inventory getDestroyItemsGUI() {
        return destroyItemsGUI;
    }
}
