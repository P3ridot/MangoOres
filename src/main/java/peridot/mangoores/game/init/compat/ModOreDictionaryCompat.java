package peridot.mangoores.game.init.compat;

import net.minecraftforge.oredict.OreDictionary;
import peridot.mangoores.game.blocks.ModBlocks;
import peridot.mangoores.game.items.ModItems;

public class ModOreDictionaryCompat {

    public static void registerOreDicionaries() {
        OreDictionary.registerOre("rodIron", ModItems.IRON_ROD);
        OreDictionary.registerOre("rodGold", ModItems.GOLD_ROD);

        OreDictionary.registerOre("ingotMangonium", ModItems.MANGONIUM_INGOT);
        OreDictionary.registerOre("ingotVibranium", ModItems.VIBRANIUM_INGOT);
        OreDictionary.registerOre("ingotUranite", ModItems.URANITE_INGOT);

        OreDictionary.registerOre("nuggetMangonium", ModItems.MANGONIUM_NUGGET);
        OreDictionary.registerOre("nuggetVibranium", ModItems.VIBRANIUM_NUGGET);
        OreDictionary.registerOre("nuggetUranite", ModItems.URANITE_NUGGET);

        OreDictionary.registerOre("gemAmber", ModItems.AMBER_GEM);
        OreDictionary.registerOre("gemAmethyst", ModItems.AMETHYST_GEM);
        OreDictionary.registerOre("gemAquamarine", ModItems.AQUAMARINE_GEM);
        OreDictionary.registerOre("gemGalaxite", ModItems.GALAXITE_GEM);
        OreDictionary.registerOre("gemKyanite", ModItems.KYANITE_GEM);
        OreDictionary.registerOre("gemPeridot", ModItems.PERIDOT_GEM);
        OreDictionary.registerOre("gemRuby", ModItems.RUBY_GEM);
        OreDictionary.registerOre("gemSapphire", ModItems.SAPPHIRE_GEM);
        OreDictionary.registerOre("gemTanzanite", ModItems.TANZANITE_GEM);
        OreDictionary.registerOre("gemTopaz", ModItems.TOPAZ_GEM);
        OreDictionary.registerOre("gemVulcanite", ModItems.VULCANITE_GEM);

        OreDictionary.registerOre("blockMeteorite", ModBlocks.METEORITE_BLOCK);

        OreDictionary.registerOre("oreMangonium", ModBlocks.MANGONIUM_ORE);
        OreDictionary.registerOre("oreVibranium", ModBlocks.VIBRANIUM_ORE);
        OreDictionary.registerOre("oreUranite", ModBlocks.URANITE_ORE);

        OreDictionary.registerOre("blockMangonium", ModBlocks.MANGONIUM_BLOCK);
        OreDictionary.registerOre("blockVibranium", ModBlocks.VIBRANIUM_BLOCK);
        OreDictionary.registerOre("blockUranite", ModBlocks.URANITE_BLOCK);
    }

}
