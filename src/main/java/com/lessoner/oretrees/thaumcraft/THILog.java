package com.lessoner.oretrees.thaumcraft;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class THILog extends ItemBlock{
	
	public static final String[] logs = new String[]{"Thaumium", "Air", "Fire", "Water"};

	public static int meta;
	
	public THILog(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack){
		int i = itemstack.getItemDamage();
		if(i < 0 || i >= logs.length){
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + logs[i];
	}
	
	public int getMetadata(int meta){
		this.meta = meta;
		return meta;
	}

}
