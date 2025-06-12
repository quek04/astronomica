package quek.astronomica.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import quek.astronomica.Astronomica;
import quek.astronomica.registry.AstronomicaBlocks;
import quek.astronomica.registry.AstronomicaItems;

public class AstronomicaItemModels extends ItemModelProvider {

    public AstronomicaItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Astronomica.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(AstronomicaItems.RAW_STELLAR_METAL.get());
        basicItem(AstronomicaItems.STELLAR_METAL_INGOT.get());
        simpleBlockItem(AstronomicaBlocks.STELLAR_METAL_ORE.get());
    }
}
