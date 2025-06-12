package quek.astronomica.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import quek.astronomica.Astronomica;
import quek.astronomica.registry.AstronomicaBlocks;

public class AstronomicaBlockStates extends BlockStateProvider {

    public AstronomicaBlockStates(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Astronomica.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(AstronomicaBlocks.STELLAR_METAL_ORE.get());
    }
}
