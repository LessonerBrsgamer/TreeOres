package com.lessoner.oretrees.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.lessoner.oretrees.TreeOres;
import com.lessoner.oretrees.container.ContainerTreeStation;

import cpw.mods.fml.common.network.IGuiHandler;

public class TreeOresGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(ID == TreeOres.guiTreeWorkStation){
			return ID == TreeOres.guiTreeWorkStation && world.getBlock(x, y, z) == TreeOres.blockTreeWorkstation ? new ContainerTreeStation(player.inventory, world, x, y, z ): null; 
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		
		if(ID == TreeOres.guiTreeWorkStation){
			return ID == TreeOres.guiTreeWorkStation && world.getBlock(x, y, z) == TreeOres.blockTreeWorkstation ? new guiTreeStation(player.inventory, world, x, y, z ): null; 
		}
		
		return null;
	}

}
