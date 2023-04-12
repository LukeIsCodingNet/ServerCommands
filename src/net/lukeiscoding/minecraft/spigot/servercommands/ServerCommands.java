package net.lukeiscoding.minecraft.spigot.servercommands;
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

import net.lukeiscoding.minecraft.spigot.servercommands.commands.CommandDestroyItems;
import net.lukeiscoding.minecraft.spigot.servercommands.commands.CommandFeed;
import net.lukeiscoding.minecraft.spigot.servercommands.commands.CommandHeal;
import net.lukeiscoding.minecraft.spigot.servercommands.commands.CommandRename;
import net.lukeiscoding.minecraft.spigot.servercommands.events.EventDestroyItems;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();

        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
    }

    private void registerCommands() {
        this.getCommand("heal").setExecutor(new CommandHeal());
        this.getCommand("feed").setExecutor(new CommandFeed());
        this.getCommand("destroyitems").setExecutor(new CommandDestroyItems());
        this.getCommand("rename").setExecutor(new CommandRename());
    }

    private void registerEvents() {
        Bukkit.getServer().getPluginManager().registerEvents(new EventDestroyItems(), this);
    }
}
