package com.lessoner.oretrees.items;

import java.util.List;

import com.lessoner.oretrees.TreeOres;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockLog;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemChops extends Item
{
    public static final String[] chops = new String[] {"iron", "gold", "coal", "redstone"};
    

    public ItemChops()
    {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }
    
    int itemcount = chops.length;
    
    @SideOnly(Side.CLIENT)
    private IIcon[] c;

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_)
    {
        this.c = new IIcon[chops.length];

        for (int i = 0; i < c.length; ++i)
        {
            this.c[i] = p_94581_1_.registerIcon(TreeOres.MODID + ":" + this.getUnlocalizedName().substring(5) + "." + chops[i]);
        }
    }
    public String getUnlocalizedName(ItemStack par1ItemStack)
	{
	         int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, itemcount-1);
	         return super.getUnlocalizedName() + "." + chops[i];
	}
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1){
    	int j = MathHelper.clamp_int(par1, 0, itemcount-1);
        return this.c[j];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item it, CreativeTabs ct, List list)
    {
    	for(int i = 0; i<chops.length; i++){
        list.add(new ItemStack(it, 1, i));
    	}
    }
    
    

    
}