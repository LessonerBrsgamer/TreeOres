package com.lessoner.oretrees.IC2;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemIC2Leaf extends ItemBlock {

	public static final String[] leaves = new String[] { "Copper", "Tin", "Uranium", "Lead" };

	public ItemIC2Leaf(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= leaves.length) {
			i = 0;
		}

		return super.getUnlocalizedName() + "." + leaves[i];
	}

	public int getMetadata(int meta) {
		return meta;
	}
}
