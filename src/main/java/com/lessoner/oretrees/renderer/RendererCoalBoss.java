package com.lessoner.oretrees.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

import com.lessoner.oretrees.TreeOres;
import com.lessoner.oretrees.entity.EntityCoalBoss;
import com.lessoner.oretrees.entity.EntityIronBoss;
import com.lessoner.oretrees.model.modelBoss;

public class RendererCoalBoss extends RenderBiped {

	public static final ResourceLocation texture = new ResourceLocation(
			TreeOres.MODID + ":" + "textures/model/coalboss.png");

	protected modelBoss modelEntity;
	
	private Object ModelBipedMobRightarm;

	public RendererCoalBoss(ModelBiped mb, float f) {
		super(mb, f);
		modelEntity = ((modelBoss) mainModel);
	}

	public void renderCoalBoss(EntityCoalBoss entity, double x, double y,
			double z, float u, float v) {
		BossStatus.setBossStatus(entity, true);
		super.doRender(entity, x, y, z, u, v);
	}

	public void doRenderLiving(EntityLiving entityl, double x, double y,
			double z, float u, float v) {
		renderCoalBoss((EntityCoalBoss) entityl, x, y, z, u, v);

	}

	public void doRender(Entity entity, double x, double y, double z, float u,
			float v) {
		
		renderCoalBoss((EntityCoalBoss) entity, x, y, z, u, v);

	}
	

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return texture;
	}

}
