package com.lessoner.oretrees.itemsformetadata;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemLeafBlocks4 extends ItemBlock{
	
	public static final String[] leaves = new String[]{"XP", "Pumpkin"};

	public ItemLeafBlocks4(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack){
		int i = itemstack.getItemDamage();
		if(i<0 || i>= leaves.length){
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + leaves[i];
	}
	
	public int getMetadata(int meta){
		return meta;
	}
}
