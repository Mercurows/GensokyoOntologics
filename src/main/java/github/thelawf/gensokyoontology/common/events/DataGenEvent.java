package github.thelawf.gensokyoontology.common.events;

import github.thelawf.gensokyoontology.GensokyoOntology;
import github.thelawf.gensokyoontology.data.GSKOBlockTags;
import github.thelawf.gensokyoontology.data.GSKOItemTags;
import github.thelawf.gensokyoontology.data.GSKORecipeHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

// @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
// public class DataGenEvent {
//
//     @SubscribeEvent
//     public static void dataGen(GatherDataEvent event) {
//
//         event.getGenerator().addProvider(new GSKORecipeHandler(event.getGenerator()));
//         event.getGenerator().addProvider(new GSKOItemTags(event.getGenerator(),
//                 new GSKOBlockTags(event.getGenerator(), GensokyoOntology.MODID,
//                         event.getExistingFileHelper()),GensokyoOntology.MODID,event.getExistingFileHelper()));
//     }
// }
