package com.lessoner.oretrees.logsnleafs;

import java.util.List;
import java.util.Random;

import com.lessoner.oretrees.TreeOres;
import com.lessoner.oretrees.itemsformetadata.ItemLogBlocks;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NCLog extends BlockLog {
	public static final String[] logs = new String[]{"Iron", "Gold","Coal","Redstone"};

	@SideOnly(Side.CLIENT)
	public void getSubBlocks (Item item, CreativeTabs tabs, List list){
		for(int i = 0; i < logs.length; i++){
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	 public int quantityDropped(Random r)
	    {
		 if(TreeOres.usechops){
	      	return 2 + r.nextInt(2);
		 }else{
			 return 1;
		 }
	    }

	    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	    {
	    	if(TreeOres.usechops){
	        return TreeOres.Woodchops;
	    	}else{
	        	return Item.getItemFromBlock(this);
	        }
	    }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir){
		this.field_150167_a = new IIcon[logs.length];
		this.field_150166_b = new IIcon[logs.length];
		
		for(int i = 0; i< this.field_150167_a.length; i++){
			this.field_150167_a[i] = ir.registerIcon(TreeOres.MODID + ":" + this.getUnlocalizedName().substring(5) + logs[i]);
			this.field_150166_b[i] = ir.registerIcon(TreeOres.MODID + ":" + this.getUnlocalizedName().substring(5) + logs[i]+ "Top");
		}
	}
	
	public boolean canProvidePower()
    {
		if(ItemLogBlocks.meta == 3){
        return true;
		} return false;
    }

    public int isProvidingWeakPower(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_)
    {
        return 15;
    }
}
