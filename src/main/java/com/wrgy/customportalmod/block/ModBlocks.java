package com.wrgy.customportalmod.block;

import java.util.function.Supplier;
import com.wrgy.customportalmod.CustomPortalMod;
import com.wrgy.customportalmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CustomPortalMod.MOD_ID);

     public static final RegistryObject<Block> wPortalBlock = registerBlockWithoutItem("wportalblock",
            ()-> new wgPortalBlock(BlockBehaviour.Properties.of(Material.GLASS)));

    public static final RegistryObject<Block> CUSTOMHOPPERBLOCK_D = registerBlock("customhopperblock_d",
            () -> new CustomHopperBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(-1.0F, 3600000.0F)), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> CUSTOMHOPPERBLOCK_A = registerBlock("customhopperblock_a",
            () -> new CustomHopperBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(-1.0F, 3600000.0F)), CreativeModeTab.TAB_MISC);

    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn,tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                         CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
