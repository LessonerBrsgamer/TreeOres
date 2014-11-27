package com.lessoner.oretrees.itemsformetadata;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemLogBlocks3 extends ItemBlock{
	
	public static final String[] logs = new String[]{"glowstone","obsidian", "xp", "pumpkin"};

	public static int meta;
	
	public ItemLogBlocks3(Block block) {
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
