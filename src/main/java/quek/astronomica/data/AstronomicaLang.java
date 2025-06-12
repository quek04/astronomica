package quek.astronomica.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import quek.astronomica.Astronomica;
import quek.astronomica.registry.AstronomicaBlocks;
import quek.astronomica.registry.AstronomicaDimensions;
import quek.astronomica.registry.AstronomicaItems;

public class AstronomicaLang extends LanguageProvider {

    public AstronomicaLang(PackOutput output) {
        super(output, Astronomica.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(AstronomicaItems.RAW_STELLAR_METAL, "Raw Stellar Metal");
        addItem(AstronomicaItems.STELLAR_METAL_INGOT, "Stellar Metal Ingot");

        addBlock(AstronomicaBlocks.STELLAR_METAL_ORE, "Stellar Metal Ore");

        addDimension(AstronomicaDimensions.LUNA_LEVEL, "Luna");
        addDimension(AstronomicaDimensions.ERSATZ_LEVEL, "Ersatz");
        addDimension(AstronomicaDimensions.VESTIGE_LEVEL, "Vestige");
        addDimension(AstronomicaDimensions.NOTHINGNESS_LEVEL, "Nothingness");
    }
}
