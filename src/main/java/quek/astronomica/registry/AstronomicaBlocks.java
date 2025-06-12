package quek.astronomica.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import quek.astronomica.Astronomica;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public class AstronomicaBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Astronomica.MODID);

    public static final DeferredBlock<Block> STELLAR_METAL_ORE = register("stellar_metal_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));

    private static <T extends Block> DeferredBlock<T> baseRegister(String name, Supplier<? extends T> block, Function<DeferredBlock<T>, Supplier<? extends Item>> item) {
        DeferredBlock<T> register = BLOCKS.register(name, block);
        AstronomicaItems.ITEMS.register(name, item.apply(register));
        return register;
    }

    private static <B extends Block> DeferredBlock<B> register(String name, Supplier<B> block) {
        return baseRegister(name, block, AstronomicaBlocks::registerBlockItem);
    }

    private static <T extends Block> Supplier<BlockItem> registerBlockItem(final DeferredBlock<T> block) {
        return () -> new BlockItem(Objects.requireNonNull(block.get()), new Item.Properties());
    }
}
