package com.lessoner.oretrees.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.lessoner.oretrees.TreeOres;
import com.lessoner.oretrees.container.ContainerTreeStation;

public class guiTreeStation extends GuiContainer {

	private ResourceLocation texture = new ResourceLocation(TreeOres.MODID + ":" + "textures/gui/treestation.png");
	public guiTreeStation(InventoryPlayer invp, World w, int x, int y, int z) {
		
		super(new ContainerTreeStation(invp,w, x, y, z));
		
		this.xSize = 176;
		this.ySize = 166;
		
	}
	
	public void onGuiClosed(){
		super.onGuiClosed();
	}

	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String s = "Treestation";
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
	};
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1f,1f,1f,1f);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft,guiTop, 0,0,xSize,ySize);

	}

}
