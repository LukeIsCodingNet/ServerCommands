package net.lukeiscoding.minecraft.spigot.servercommands.events;
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
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EventDestroyItems implements Listener {

    private static final CommandDestroyItems commandDestroyItems = new CommandDestroyItems();

    private static final Inventory destroyItemsGui = commandDestroyItems.getDestroyItemsGUI();

    @EventHandler
    public void onInventoryClose(final InventoryCloseEvent event) {
        Player p = (Player) event.getPlayer();

        if (p.getOpenInventory().equals(destroyItemsGui)) {
            for (ItemStack s : destroyItemsGui.getContents()) {
                if (s.getAmount() >= 1) {
                    if (!p.getOpenInventory().equals(destroyItemsGui)) {
                        destroyItemsGui.clear();
                        p.sendMessage(ChatColor.AQUA + "You have just destroyed + " + ChatColor.GOLD + String.valueOf(s.getAmount()) + ChatColor.AQUA + " items!");
                    }
                }
            }
        }
    }
}
