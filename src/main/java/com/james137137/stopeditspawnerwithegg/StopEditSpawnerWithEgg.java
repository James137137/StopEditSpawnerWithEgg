/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.james137137.stopeditspawnerwithegg;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.plugin.java.JavaPlugin;
/**
 *
 * @author James
 */
public class StopEditSpawnerWithEgg extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("StopEditSpawnerWithEgg is enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("StopEditSpawnerWithEgg is disabled");
    }
    
    @EventHandler
    public void onPlayerClick(PlayerInteractEvent event)
    {
        if (event.hasItem() && event.hasBlock() && event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
        {
            if (event.getItem().getType().equals(Material.MONSTER_EGG) &&
                    event.getClickedBlock().getType().equals(Material.MOB_SPAWNER))
            {
                event.setCancelled(true);
            }
        }
    }
    
}
