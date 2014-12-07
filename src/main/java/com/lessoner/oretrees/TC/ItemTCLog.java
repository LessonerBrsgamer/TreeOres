package com.lessoner.oretrees.TC;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemTCLog extends ItemBlock{
	
	public static final String[] logs = new String[]{"Ardite", "Cobalt"};

	public static int meta;
	
	public ItemTCLog(Block block) {
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
