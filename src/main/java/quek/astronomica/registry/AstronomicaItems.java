package quek.astronomica.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import quek.astronomica.Astronomica;

public class AstronomicaItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Astronomica.MODID);

    public static final DeferredItem<Item> RAW_STELLAR_METAL = ITEMS.register("raw_stellar_metal", () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    public static final DeferredItem<Item> STELLAR_METAL_INGOT = ITEMS.register("stellar_metal_ingot", () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
}
