package github.thelawf.gensokyoontology.core.init;

import github.thelawf.gensokyoontology.GensokyoOntology;
import github.thelawf.gensokyoontology.common.entity.*;
import github.thelawf.gensokyoontology.common.entity.projectile.DanmakuShotEntity;
import github.thelawf.gensokyoontology.common.entity.projectile.HeartShotEntity;
import github.thelawf.gensokyoontology.common.entity.projectile.LargeShotEntity;
import github.thelawf.gensokyoontology.common.entity.projectile.MasterSparkEntity;
import github.thelawf.gensokyoontology.common.entity.spellcard.SpellCardEntity;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
            ForgeRegistries.ENTITIES, GensokyoOntology.MODID);

    public static final RegistryObject<EntityType<HumanResidentEntity>> HUMAN_RESIDENT_ENTITY = ENTITIES.register(
            "human_resident", () -> HumanResidentEntity.HUMAN_RESIDENT);

    public static final RegistryObject<EntityType<CitizenEntity>> CITIZEN = ENTITIES.register(
            "citizen", () -> CitizenEntity.CITIZEN);

    public static final RegistryObject<EntityType<InyoJadeMonsterEntity>> INYO_JADE_ENTITY = ENTITIES.register(
            "inyo_jade", () -> InyoJadeMonsterEntity.INYO_JADE_MONSTER);

    public static final RegistryObject<EntityType<FairyEntity>> FAIRY_ENTITY = ENTITIES.register(
            "fairy", () -> FairyEntity.FAIRY);

    public static final RegistryObject<EntityType<SpectreEntity>> SPECTRE_ENTITY = ENTITIES.register(
            "spectre", () -> SpectreEntity.SPECTRE);

    public static final RegistryObject<EntityType<KoishiEntity>> KOISHI_ENTITY = ENTITIES.register(
            "komeiji_koishi", () -> KoishiEntity.KOISHI);

    public static final RegistryObject<EntityType<SumirekoEntity>> SUMIREKO_ENTITY = ENTITIES.register(
            "usami_sumireko", () -> SumirekoEntity.SUMIREKO);

    public static final RegistryObject<EntityType<YukariEntity>> YUKARI_ENTITY = ENTITIES.register(
            "yakumo_yukari", () -> YukariEntity.YUKARI);

    public static final RegistryObject<EntityType<DanmakuShotEntity>> DANMAKU_ENTITY = ENTITIES.register(
            "danmaku_entity", () -> DanmakuShotEntity.DANMAKU);

    public static final RegistryObject<EntityType<SpellCardEntity>> SPELL_CARD_ENTITY = ENTITIES.register(
            "spell_card_entity", () -> SpellCardEntity.SPELL_CARD_ENTITY);

    public static final RegistryObject<EntityType<HeartShotEntity>> HERAT_SHOT_ENTITY = ENTITIES.register(
            "heart_shot_entity", () -> HeartShotEntity.HEART_SHOT);

    public static final RegistryObject<EntityType<LargeShotEntity>> LARGE_SHOT_ENTITY =ENTITIES.register(
            "large_shot_entity", () -> LargeShotEntity.LARGE_SHOT);

    public static final RegistryObject<EntityType<MasterSparkEntity>> MASTER_SPARK_ENTITY = ENTITIES.register(
            "master_spark", () -> MasterSparkEntity.MASTER_SPARK);

    public static final RegistryObject<EntityType<NamespaceDomain>> NAMESPACE_DOMAIN = ENTITIES.register(
            "namespace_domain", () -> NamespaceDomain.NAMESPACE_DOMAIN);

   // public static final RegistryObject<EntityType<FlyingSwordEntity>> FLY_SWORD_ENTITY = GSKO_ENTITIES.register(
   //         "flying_sword", () -> FlyingSwordEntity.FLY_SWORD_TYPE);

   // public static final RegistryObject<EntityType<PhantasmSphereEntity>> PH_SPHERE_ENTITY = GSKO_ENTITIES.register(
   //         "phantasm_sphere", () -> PhantasmSphereEntity.PH_SPHERE_TYPE);
}


