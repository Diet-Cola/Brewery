package com.dre.brewery.integration.barrel;

import org.bukkit.block.Block;

import com.dre.brewery.api.events.barrel.BarrelAccessEvent;

import vg.civcraft.mc.citadel.CitadelPermissionHandler;
import vg.civcraft.mc.citadel.ReinforcementLogic;
import vg.civcraft.mc.citadel.model.Reinforcement;

public class CitadelBarrel {
	
	public static boolean checkAccess(BarrelAccessEvent event) {
		Block block = event.getClickedBlock();
		if (block == null) {
			return true;
		}
		Reinforcement rein = ReinforcementLogic.getReinforcementProtecting(block);
		if (rein == null) {
			return true;
		}
		return rein.hasPermission(event.getPlayer(), CitadelPermissionHandler.getChests());
	}

}
