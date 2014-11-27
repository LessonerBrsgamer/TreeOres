package com.lessoner.oretrees.logsnleafs;

import java.util.List;
import java.util.Random;

import com.lessoner.oretrees.TreeOres;

import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NCLeaf4 extends BlockLeaves {

	public static final String[][] leaftypes = new String[][] {
			{"LeafXP", "LeafPumpkin" },
			{"LeafXPOpaque", "LeafPumpkinOpaque" } };
	public static final String[] leaves = new String[] {"XP", "Pumpkin"};

	
	
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(TreeOres.blockSapling2);
    }
	
	/**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return super.damageDropped(p_149692_1_) + 4;
    }

	/**
	 * Get the block's damage value (for use with pick block).
	 */
	public int getDamageValue(World w, int x,
			int y, int z) {
		return w.getBlockMetadata(x, y,
				z) & 3;
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab,
			List list) {
		for(int i = 0; i < leaves.length; i++){
			list.add(new ItemStack(item, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ic) {
		for (int i = 0; i < leaftypes.length; ++i) {
			this.field_150129_M[i] = new IIcon[leaftypes[i].length];

			for (int j = 0; j < leaftypes[i].length; ++j) {
				this.field_150129_M[i][j] = ic
						.registerIcon(TreeOres.MODID + ":" + leaftypes[i][j]);
			}
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return (meta & 3) == 1 ? this.field_150129_M[this.field_150127_b][1]
				: this.field_150129_M[this.field_150127_b][0];
	}

	@Override
	public String[] func_150125_e() {
		return leaves;
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}

	@Override
	public boolean isOpaqueCube(){
		return false;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockaccessm, int x, int y, int z, int side){
		return true;
	}

}
