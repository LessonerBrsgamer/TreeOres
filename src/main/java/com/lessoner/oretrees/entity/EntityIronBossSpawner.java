package com.lessoner.oretrees.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityIronBossSpawner extends EntityThrowable
{
	public EntityIronBossSpawner(World w)
    {
        super(w);
    }

    public EntityIronBossSpawner(World w, EntityLivingBase elv)
    {
        super(w, elv);
    }

    public EntityIronBossSpawner(World w, double x, double y, double z)
    {
        super(w, x, y, z);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition p_70184_1_)
    {
        if (p_70184_1_.entityHit != null)
        {
            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        if (!this.worldObj.isRemote)
        {
                EntityIronBoss entityironboss = new EntityIronBoss(this.worldObj);
                entityironboss.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                this.worldObj.spawnEntityInWorld(entityironboss);
            }

        for (int j = 0; j < 8; ++j)
        {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}