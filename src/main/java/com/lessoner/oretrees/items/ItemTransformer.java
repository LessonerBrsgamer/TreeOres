package com.lessoner.oretrees.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.lessoner.oretrees.TreeOres;
import com.lessoner.oretrees.entity.EntityIronBossSpawner;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTransformer extends Item {

	
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack)
	 {
	 return false;
	 }
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir)
    {
        this.itemIcon = ir.registerIcon(TreeOres.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
	
	
}
