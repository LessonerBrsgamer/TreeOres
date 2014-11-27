package com.lessoner.oretrees.container;

import com.lessoner.oretrees.TreeOres;
import com.lessoner.oretrees.crafting.TreeStationCraftingManager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerTreeStation extends Container {

	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	
	
	public ContainerTreeStation(InventoryPlayer invp, World w ,int x, int y, int z) {
		craftMatrix = new InventoryCrafting(this, 3,3);
		craftResult = new InventoryCraftResult();
		worldObj = w;
		posX = x;
		posY = y;
		posZ = z;
		
		this.addSlotToContainer(new SlotCrafting(invp.player, craftMatrix, craftResult, 0, 124, 35));
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				this.addSlotToContainer(new Slot(craftMatrix, j + i * 3, 30 + j * 18, 17 + i * 18));
			}
		}
		for(int i = 0; i <3; i++){
			for(int k = 0; k < 9; k++){
				this.addSlotToContainer(new Slot(invp, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
			}
		}
		
		for(int i = 0; i < 9; i++){
			this.addSlotToContainer(new Slot(invp, i, 8+i*18, 142));
		}
		
		onCraftMatrixChanged(craftMatrix);
	}
	
	public void onCraftMatrixChanged(IInventory iinv){
		craftResult.setInventorySlotContents(0, TreeStationCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
	}
	
	public void onContainerClosed(EntityPlayer p_75134_1_)
	    {
	        super.onContainerClosed(p_75134_1_);

	        if (!this.worldObj.isRemote)
	        {
	            for (int i = 0; i < 9; ++i)
	            {
	                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

	                if (itemstack != null)
	                {
	                    p_75134_1_.dropPlayerItemWithRandomChoice(itemstack, false);
	                }
	            }
	        }
	    }
	
	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ == 0)
            {
                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (p_82846_2_ >= 10 && p_82846_2_ < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return null;
                }
            }
            else if (p_82846_2_ >= 37 && p_82846_2_ < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(p_82846_1_, itemstack1);
        }

        return itemstack;
    }

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if(worldObj.getBlock(posX, posY, posZ) != TreeOres.blockTreeWorkstation){
			return false;
		}else{
			return player.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64.0D;
		}
	}

}
