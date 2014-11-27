package com.lessoner.oretrees.thaumcraft;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.lessoner.oretrees.TreeOres;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class THSapling extends BlockSapling{
	
	public static final String[] saplings = new String[] {"thaumium", "air", "fire", "water"};
    private static final IIcon[] iconLength = new IIcon[saplings.length];

    public THSapling()
    {
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(TreeOres.treeores);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World w, int x, int y, int z, Random r)
    {
        if (!w.isRemote)
        {
            super.updateTick(w, x, y, z, r);

            if (w.getBlockLightValue(x, y + 1, z) >= 9 && r.nextInt(7) == 0)
            {
                this.func_149879_c(w, x, y, z, r);
            }
        }
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    public IIcon getIcon (int side, int metadata) 

	{ 

		return metadata >= 0 && metadata <THISapling.saplings.length? this.iconLength[metadata] : this.iconLength [0]; 

	}

    //markorgrowmarked
    public void func_149879_c(World w, int x, int y, int z, Random r)
    {
        int l = w.getBlockMetadata(x, y, z);

        if ((l & 8) == 0)
        {
            w.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
        }
        else
        {
            this.func_149878_d(w, x, y, z, r);
        }
    }
    //grow tree
    
    public void func_149878_d(World w, int x, int y, int z, Random r)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(w, r, x, y, z)) return;
        int l = w.getBlockMetadata(x, y, z) & 7;
        Object object = r.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;

        switch (l){
            case 0:
            	object = new WorldGenThaumcraftTree(TreeOres.ThaumcraftLog, TreeOres.ThaumcraftLeaf, 0,0,false, 4,8, false);
            	break;
            case 1:
            	object = new WorldGenThaumcraftTree(TreeOres.ThaumcraftLog, TreeOres.ThaumcraftLeaf, 1,1,false, 4,8, false);
            	break;
            case 2:
            	object = new WorldGenThaumcraftTree(TreeOres.ThaumcraftLog, TreeOres.ThaumcraftLeaf, 2,2,false, 4,8, false);
            	break;
            case 3:
            	object = new WorldGenThaumcraftTree(TreeOres.ThaumcraftLog, TreeOres.ThaumcraftLeaf, 3,3,false, 4,8, false);
            	break;
            default:
                break;
        }

        Block block = Blocks.air;

        if (flag)
        {
            w.setBlock(x + i1, y, z + j1, block, 0, 4);
            w.setBlock(x + i1 + 1, y, z + j1, block, 0, 4);
            w.setBlock(x + i1, y, z + j1 + 1, block, 0, 4);
            w.setBlock(x + i1 + 1, y, z + j1 + 1, block, 0, 4);
        }
        else
        {
            w.setBlock(x, y, z, block, 0, 4);
        }

        if (!((WorldGenerator)object).generate(w, r, x + i1, y, z + j1))
        {
            if (flag)
            {
                w.setBlock(x + i1, y, z + j1, this, l, 4);
                w.setBlock(x + i1 + 1, y, z + j1, this, l, 4);
                w.setBlock(x + i1, y, z + j1 + 1, this, l, 4);
                w.setBlock(x + i1 + 1, y, z + j1 + 1, this, l, 4);
            }
            else
            {
                w.setBlock(x, y, z, this, l, 4);
            }
        }
    }
    //issamesapling
    
    public boolean func_149880_a(World w, int x, int y, int z, int par1)
    {
        return w.getBlock(x, y, z) == this && (w.getBlockMetadata(x, y, z) & 7) == par1;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return MathHelper.clamp_int(p_149692_1_ & 7, 0, 5);
    }
    
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab,
			List list) {
		for(int i = 0; i < saplings.length; i++){
			list.add(new ItemStack(item, 1, i));
		}
	}

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        for (int i = 0; i < iconLength.length; ++i)
        {
        	iconLength[i] = p_149651_1_.registerIcon(TreeOres.MODID + ":" + this.getUnlocalizedName().substring(5) + "_" + saplings[i]);
        }
    }

    public boolean func_149851_a(World w, int x, int y, int z, boolean bool)
    {
    	 return TreeOres.canboneMeal ? true : false;
    }

    public boolean func_149852_a(World w, Random r, int x, int y, int z)
    {
        return true;
    }

    public void func_149853_b(World w, Random r, int x, int y, int z)
    {
        this.func_149879_c(w, x, y, z, r);
    }

}
