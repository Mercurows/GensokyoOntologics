package github.thelawf.gensokyoontology.common.entity.spellcard;

import github.thelawf.gensokyoontology.common.entity.projectile.RiceShotEntity;
import github.thelawf.gensokyoontology.common.util.danmaku.DanmakuColor;
import github.thelawf.gensokyoontology.common.util.danmaku.DanmakuType;
import github.thelawf.gensokyoontology.core.init.ItemRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;


/** 八云紫的经典符卡：【境符】波与粒的境界 */
public class WaveAndParticleEntity extends SpellCardEntity{

    public static final EntityType<WaveAndParticleEntity> WAVE_AND_PARTICLE =
            EntityType.Builder.<WaveAndParticleEntity>create(WaveAndParticleEntity::new,
                    EntityClassification.MISC).size(1F,1F).trackingRange(4)
            .updateInterval(2).build("wave_and_particle");

    public WaveAndParticleEntity(EntityType<? extends SpellCardEntity> entityTypeIn, World worldIn) {
        super(WAVE_AND_PARTICLE, worldIn);
    }

    public WaveAndParticleEntity(World worldIn, PlayerEntity player) {
        super(WAVE_AND_PARTICLE, worldIn, player);
    }



    @Override
    public void tick() {
        super.tick();

        for (int i = 0; i < 3; i++) {
            RiceShotEntity riceShot = new RiceShotEntity((LivingEntity) this.getOwner(), world, DanmakuType.RICE_SHOT, DanmakuColor.PURPLE);

            Vector3d muzzle = this.getLookVec().rotateYaw((float) Math.PI * 2 / 3 * i);
            Vector3d shootAngle = muzzle.rotateYaw((float) (Math.PI / 180 *
                    ticksExisted * ((float) ticksExisted / 5)));

            setDanmakuInit(riceShot, this.getPositionVec(), shootAngle.x, shootAngle.z);
            riceShot.shoot(shootAngle.getX(), 0, shootAngle.getZ(), 0.6f, 0f);
            world.addEntity(riceShot);

        }

    }

    @Override
    public @NotNull ItemStack getItem() {
        return new ItemStack(ItemRegistry.SC_WAVE_AND_PARTICLE.get());
    }
}
