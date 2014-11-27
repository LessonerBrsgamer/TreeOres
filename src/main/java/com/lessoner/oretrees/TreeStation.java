package com.lessoner.oretrees;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TreeStation extends Block{
	
	@SideOnly(Side.CLIENT)
	private IIcon TreeStationTop;

	protected TreeStation() {
		super(Material.wood);
		
		this.setHardness(3.5f);
		this.setResistance(5f);
	}
	
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon (int side, int metadata){
		return side ==1 ? this.TreeStationTop : this.blockIcon;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister ir){
		this.blockIcon = ir.registerIcon(TreeOres.MODID + ":" + "TreeStationSide");
		this.TreeStationTop = ir.registerIcon(TreeOres.MODID + ":" + "TreeStationTop");
	}
	
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c){
		if(!player.isSneaking()){
			player.openGui(TreeOres.instance, TreeOres.guiTreeWorkStation, w, x, y, z);
			return true;
		}else{
		return false;
		}
	}

}
