package com.lessoner.oretrees.thaumcraft;

import com.lessoner.oretrees.TreeOres;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class THTransformer extends Item{

	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir)
    {
        this.itemIcon = ir.registerIcon(TreeOres.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}
