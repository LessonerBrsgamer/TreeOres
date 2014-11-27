package com.lessoner.oretrees.proxy;

import com.lessoner.oretrees.entity.EntityCoalBoss;
import com.lessoner.oretrees.entity.EntityDiamondBoss;
import com.lessoner.oretrees.entity.EntityEmeraldBoss;
import com.lessoner.oretrees.entity.EntityGlowstoneBoss;
import com.lessoner.oretrees.entity.EntityGoldBoss;
import com.lessoner.oretrees.entity.EntityIronBoss;
import com.lessoner.oretrees.entity.EntityLapisBoss;
import com.lessoner.oretrees.entity.EntityObsidianBoss;
import com.lessoner.oretrees.entity.EntityPumpkinBoss;
import com.lessoner.oretrees.entity.EntityQuartzBoss;
import com.lessoner.oretrees.entity.EntityRedstoneBoss;
import com.lessoner.oretrees.entity.EntityXPBoss;
import com.lessoner.oretrees.model.modelBoss;
import com.lessoner.oretrees.renderer.RendererCoalBoss;
import com.lessoner.oretrees.renderer.RendererDiamondBoss;
import com.lessoner.oretrees.renderer.RendererEmeraldBoss;
import com.lessoner.oretrees.renderer.RendererGlowstoneBoss;
import com.lessoner.oretrees.renderer.RendererGoldBoss;
import com.lessoner.oretrees.renderer.RendererIronBoss;
import com.lessoner.oretrees.renderer.RendererLapisBoss;
import com.lessoner.oretrees.renderer.RendererObsidianBoss;
import com.lessoner.oretrees.renderer.RendererPumpkinBoss;
import com.lessoner.oretrees.renderer.RendererQuartzBoss;
import com.lessoner.oretrees.renderer.RendererRedstoneBoss;
import com.lessoner.oretrees.renderer.RendererXPBoss;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
	
	public void registerRenderThings(){
		//Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityIronBoss.class, new RendererIronBoss(new modelBoss(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGoldBoss.class, new RendererGoldBoss(new modelBoss(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCoalBoss.class, new RendererCoalBoss(new modelBoss(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityRedstoneBoss.class, new RendererRedstoneBoss(new modelBoss(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondBoss.class, new RendererDiamondBoss(new modelBoss(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldBoss.class, new RendererEmeraldBoss(new modelBoss(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGlowstoneBoss.class, new RendererGlowstoneBoss(new modelBoss(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityQuartzBoss.class, new RendererQuartzBoss(new modelBoss(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLapisBoss.class, new RendererLapisBoss(new modelBoss(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPumpkinBoss.class, new RendererPumpkinBoss(new modelBoss(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityXPBoss.class, new RendererXPBoss(new modelBoss(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityObsidianBoss.class, new RendererObsidianBoss(new modelBoss(), 0.3F));
	}
	
	public void registerTileEntitySpecialRenderer(){
		
	}

}
