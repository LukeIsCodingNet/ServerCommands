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

public class CommandClearChat implements CommandExecutor {

    private static final ServerCommands plugin = ServerCommands.getPlugin(ServerCommands.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // cast player to sender
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("clearchat") && sender.hasPermission(PluginPermissions.COMMAND_CLEAR_CHAT_NODE.getPermissionNode()) || p.hasPermission(PluginPermissions.COMMAND_CLEAR_CHAT_NODE.getPermissionNode())) {
            for (int i = 0; i < 1000; i++) {
                sender.sendMessage("");

                if (i <= 1000) {
                    break;
                }
            }

            if (sender instanceof Player) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("clear-chat-by-player-message")));
            } else if (!(sender instanceof Player)) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("clear-chat-by-console-message")));
            }
        }

        return false;
    }
}
