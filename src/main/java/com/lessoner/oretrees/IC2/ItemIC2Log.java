package com.lessoner.oretrees.IC2;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemIC2Log extends ItemBlock{
	
	public static final String[] logs = new String[]{"Copper", "Tin","Uranium","Lead"};

	public static int meta;
	
	public ItemIC2Log(Block block) {
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
