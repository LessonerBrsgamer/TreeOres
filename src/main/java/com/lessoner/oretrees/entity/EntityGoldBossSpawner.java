package com.lessoner.oretrees.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGoldBossSpawner extends EntityThrowable
{
	public EntityGoldBossSpawner(World w)
    {
        super(w);
    }

    public EntityGoldBossSpawner(World w, EntityLivingBase elv)
    {
        super(w, elv);
    }

    public EntityGoldBossSpawner(World w, double x, double y, double z)
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
        	EntityGoldBoss entityboss = new EntityGoldBoss(this.worldObj);
        	entityboss.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                this.worldObj.spawnEntityInWorld(entityboss);
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
