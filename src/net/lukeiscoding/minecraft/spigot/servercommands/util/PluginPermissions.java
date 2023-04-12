package net.lukeiscoding.minecraft.spigot.servercommands.util;
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

public enum PluginPermissions {

    COMMAND_HEAL_NODE("servercommands.heal"),
    COMMAND_HEAL_OTHERS_NODE("servercommands.heal.others"),
    COMMAND_FEED_NODE("servercommands.feed"),
    COMMAND_FEED_OTHERS_NODE("servercommands.feed"),
    COMMAND_DESTROY_ITEMS_NODE("servercommands.destroyitems"),
    COMMAND_CLEAR_CHAT_NODE("servercommands.clearchat"),
    COMMAND_RENAME_NODE("servercommands.rename");

    private String permissionNode;

    PluginPermissions(String permissionNode) {
        this.permissionNode = permissionNode;
    }

    public String getPermissionNode() {
        return permissionNode;
    }
}
