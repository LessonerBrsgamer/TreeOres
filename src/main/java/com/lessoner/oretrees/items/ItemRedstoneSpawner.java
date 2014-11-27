package com.lessoner.oretrees.items;

import com.lessoner.oretrees.TreeOres;
import com.lessoner.oretrees.entity.EntityIronBossSpawner;
import com.lessoner.oretrees.entity.EntityRedstoneBossSpawner;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRedstoneSpawner extends Item{

	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir)
    {
        this.itemIcon = ir.registerIcon(TreeOres.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
	
	public ItemStack onItemRightClick(ItemStack ie, World w, EntityPlayer p)
    {
        if (!p.capabilities.isCreativeMode)
        {
            --ie.stackSize;
        }

        w.playSoundAtEntity(p, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!w.isRemote)
        {
            w.spawnEntityInWorld(new EntityRedstoneBossSpawner(w, p));
        }

        return ie;
    }
}
