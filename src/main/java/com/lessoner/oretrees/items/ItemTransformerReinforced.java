package com.lessoner.oretrees.items;

import com.lessoner.oretrees.TreeOres;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTransformerReinforced extends Item {

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
