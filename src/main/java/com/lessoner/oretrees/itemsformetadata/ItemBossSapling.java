package com.lessoner.oretrees.itemsformetadata;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemBossSapling extends ItemBlockWithMetadata{
	
	public static final String[] saplings = new String[]{"iron", "gold","coal","redstone", "diamond","emerald"};

	public ItemBossSapling(Block block) {
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
