package github.thelawf.gensokyoontology.common.entity.spellcard;

import github.thelawf.gensokyoontology.common.entity.projectile.RiceShotEntity;
import github.thelawf.gensokyoontology.common.util.danmaku.DanmakuColor;
import github.thelawf.gensokyoontology.common.util.danmaku.DanmakuType;
import github.thelawf.gensokyoontology.common.util.danmaku.DanmakuUtil;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FullCherryBlossomEntity extends SpellCardEntity{

    public static final EntityType<FullCherryBlossomEntity> FULL_CHERRY_BLOSSOM =
            EntityType.Builder.<FullCherryBlossomEntity>create(FullCherryBlossomEntity::new, EntityClassification.MISC)
                    .size(1F,1F).trackingRange(4).updateInterval(2).build("full_cherry_blossom");

    public FullCherryBlossomEntity(World worldIn, LivingEntity living) {
        super(FULL_CHERRY_BLOSSOM, worldIn, living);
    }

    public FullCherryBlossomEntity(EntityType<? extends SpellCardEntity> entityTypeIn, World worldIn) {
        super(FULL_CHERRY_BLOSSOM, worldIn);
    }

    /**
     * 这个方法是为了方便其它类在外部调用符卡的弹幕演出
     */
    public void onTick(World world, LivingEntity living, int ticksExisted) {
        List<Vector3d> roseLinePos = DanmakuUtil.getRoseLinePos(1.2, 3, 2, 0.05);

        if (ticksExisted % 20 == 0) {
            for (Vector3d vector3d : roseLinePos) {
                RiceShotEntity riceShot = new RiceShotEntity(living, world, DanmakuType.RICE_SHOT, DanmakuColor.PURPLE);
                Vector3d shootVec = new Vector3d(vector3d.x, vector3d.y, vector3d.z);
                shootVec = DanmakuUtil.rotateRandomAngle(shootVec, (float) Math.PI * 2, (float) Math.PI * 2);
                vector3d = vector3d.add(DanmakuUtil.getRandomPosWithin(3.5f, DanmakuUtil.Plane.XYZ));
                vector3d = vector3d.add(living.getPositionVec());

                DanmakuUtil.initDanmaku(riceShot, vector3d, new Vector2f((float) vector3d.x, (float) vector3d.y), true);
                riceShot.shoot(shootVec.x, shootVec.y, shootVec.z, 0.3f, 0f);
                world.addEntity(riceShot);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        onTick(this.world, (LivingEntity) this.getOwner(), ticksExisted);
    }

    @Override
    @NotNull
    public ItemStack getItem() {
        return ItemStack.EMPTY;
    }
}
