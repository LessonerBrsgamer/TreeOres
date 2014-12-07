package com.lessoner.oretrees.TC;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemTCSaplings extends ItemBlockWithMetadata{
	
	public static final String[] saplings = new String[]{"ardite", "cobalt"};

	public ItemTCSaplings(Block block) {
		super(block,block);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack){
		int i = itemstack.getItemDamage();
		if(i<0 || i>= saplings.length){
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + saplings[i];
	}
	
	public int getMetadata(int meta){
		return meta;
	}
	

}
