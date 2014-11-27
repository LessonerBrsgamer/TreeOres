package com.lessoner.oretrees;

import java.io.File;
import java.io.IOException;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import com.lessoner.oretrees.entity.EntityCoalBoss;
import com.lessoner.oretrees.entity.EntityDiamondBoss;
import com.lessoner.oretrees.entity.EntityEmeraldBoss;
import com.lessoner.oretrees.entity.EntityGlowstoneBoss;
import com.lessoner.oretrees.entity.EntityGoldBoss;
import com.lessoner.oretrees.entity.EntityIronBoss;
import com.lessoner.oretrees.entity.EntityLapisBoss;
import com.lessoner.oretrees.entity.EntityObsidianBoss;
import com.lessoner.oretrees.entity.EntityPumpkinBoss;
import com.lessoner.oretrees.entity.EntityQuartzBoss;
import com.lessoner.oretrees.entity.EntityRedstoneBoss;
import com.lessoner.oretrees.entity.EntityXPBoss;
import com.lessoner.oretrees.event.UpdateEvent;
import com.lessoner.oretrees.gui.TreeOresGuiHandler;
import com.lessoner.oretrees.handler.EntityHandler;
import com.lessoner.oretrees.items.ItemChops;
import com.lessoner.oretrees.items.ItemChops2;
import com.lessoner.oretrees.items.ItemChops3;
import com.lessoner.oretrees.items.ItemCoalSpawner;
import com.lessoner.oretrees.items.ItemDiamondSpawner;
import com.lessoner.oretrees.items.ItemEmeraldSpawner;
import com.lessoner.oretrees.items.ItemGlowstoneSpawner;
import com.lessoner.oretrees.items.ItemGoldSpawner;
import com.lessoner.oretrees.items.ItemIronSpawner;
import com.lessoner.oretrees.items.ItemLapisSpawner;
import com.lessoner.oretrees.items.ItemObsidianSpawner;
import com.lessoner.oretrees.items.ItemPumpkinSpawner;
import com.lessoner.oretrees.items.ItemQuartzSpawner;
import com.lessoner.oretrees.items.ItemRedstoneSpawner;
import com.lessoner.oretrees.items.ItemTransformer;
import com.lessoner.oretrees.items.ItemTransformerNether;
import com.lessoner.oretrees.items.ItemTransformerReinforced;
import com.lessoner.oretrees.items.ItemXpSpawner;
import com.lessoner.oretrees.itemsformetadata.ItemBossLeaf;
import com.lessoner.oretrees.itemsformetadata.ItemBossLeaf2;
import com.lessoner.oretrees.itemsformetadata.ItemBossLeaf3;
import com.lessoner.oretrees.itemsformetadata.ItemBossLeaf4;
import com.lessoner.oretrees.itemsformetadata.ItemBossSapling;
import com.lessoner.oretrees.itemsformetadata.ItemBossSapling2;
import com.lessoner.oretrees.itemsformetadata.ItemLeafBlocks;
import com.lessoner.oretrees.itemsformetadata.ItemLeafBlocks2;
import com.lessoner.oretrees.itemsformetadata.ItemLeafBlocks3;
import com.lessoner.oretrees.itemsformetadata.ItemLeafBlocks4;
import com.lessoner.oretrees.itemsformetadata.ItemLogBlocks;
import com.lessoner.oretrees.itemsformetadata.ItemLogBlocks2;
import com.lessoner.oretrees.itemsformetadata.ItemLogBlocks3;
import com.lessoner.oretrees.itemsformetadata.ItemSaplingBlocks;
import com.lessoner.oretrees.itemsformetadata.ItemSaplingBlocks2;
import com.lessoner.oretrees.logsnleafs.BossLeaf;
import com.lessoner.oretrees.logsnleafs.BossLeaf2;
import com.lessoner.oretrees.logsnleafs.BossLeaf3;
import com.lessoner.oretrees.logsnleafs.BossLeaf4;
import com.lessoner.oretrees.logsnleafs.BossSapling;
import com.lessoner.oretrees.logsnleafs.BossSapling2;
import com.lessoner.oretrees.logsnleafs.NCLeaf;
import com.lessoner.oretrees.logsnleafs.NCLeaf2;
import com.lessoner.oretrees.logsnleafs.NCLeaf3;
import com.lessoner.oretrees.logsnleafs.NCLeaf4;
import com.lessoner.oretrees.logsnleafs.NCLog;
import com.lessoner.oretrees.logsnleafs.NCLog2;
import com.lessoner.oretrees.logsnleafs.NCLog3;
import com.lessoner.oretrees.logsnleafs.NCSapling;
import com.lessoner.oretrees.logsnleafs.NCSapling2;
import com.lessoner.oretrees.proxy.ClientProxy;
import com.lessoner.oretrees.proxy.CommonProxy;
import com.lessoner.oretrees.thaumcraft.THChop2;
import com.lessoner.oretrees.thaumcraft.THChops;
import com.lessoner.oretrees.thaumcraft.THILeaf;
import com.lessoner.oretrees.thaumcraft.THILeaf2;
import com.lessoner.oretrees.thaumcraft.THILog;
import com.lessoner.oretrees.thaumcraft.THILog2;
import com.lessoner.oretrees.thaumcraft.THISapling;
import com.lessoner.oretrees.thaumcraft.THISapling2;
import com.lessoner.oretrees.thaumcraft.THLeaf;
import com.lessoner.oretrees.thaumcraft.THLeaf2;
import com.lessoner.oretrees.thaumcraft.THLog;
import com.lessoner.oretrees.thaumcraft.THLog2;
import com.lessoner.oretrees.thaumcraft.THSapling;
import com.lessoner.oretrees.thaumcraft.THSapling2;
import com.lessoner.oretrees.thaumcraft.THTransformer;
import com.lessoner.oretrees.updatecheck.CheckUpdates;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = TreeOres.MODID, version = TreeOres.VERSION)
public class TreeOres {

	public static final String MODID = "treeores";
	public static final String VERSION = "5.0"; // TODO change this every time

	public static CreativeTabs treeores;

	@SidedProxy(clientSide = "com.lessoner.oretrees.proxy.ClientProxy", serverSide = "com.lessoner.oretrees.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static ClientProxy proxyc;

	public static Block blockLog;
	public static Block blockLog2;
	public static Block blockLog3;
	public static Block blockLeaf;
	public static Block bossLeaf;
	public static Block bossLeaf2;
	public static Block bossLeaf3;
	public static Block bossLeaf4;
	public static Block blockLeaf2;
	public static Block blockLeaf3;
	public static Block blockLeaf4;
	public static Block blockSapling;
	public static Block BossSapling;
	public static Block BossSapling2;
	public static Block blockSapling2;
	public static Item itemTransformer;
	public static Item itemTransformerNether;
	public static Item itemTransformerReinforced;
	public static Item Woodchops;
	public static Item Woodchops2;
	public static Item Woodchops3;

	public static Item ironSpawner;
	public static Item goldSpawner;
	public static Item coalSpawner;
	public static Item redstoneSpawner;
	public static Item diamondSpawner;
	public static Item emeraldSpawner;
	public static Item lapisSpawner;
	public static Item quartzSpawner;
	public static Item glowstoneSpawner;
	public static Item obsidianSpawner;
	public static Item xpSpawner;
	public static Item pumpkinSpawner;

	public static Block ThaumcraftLog;
	public static Block ThaumcraftLeaf;
	public static Block ThaumcraftSapling;
	public static Item ThaumcraftChop;
	public static Block ThaumcraftLog2;
	public static Block ThaumcraftLeaf2;
	public static Block ThaumcraftSapling2;
	public static Item ThaumcraftChop2;
	public static Item ThaumcraftTransformer;

	@Instance(MODID)
	public static TreeOres instance;

	public static Block blockTreeWorkstation;
	public static final int guiTreeWorkStation = 0;

	public static boolean canboneMeal;
	public static boolean irontree;
	public static boolean goldtree;
	public static boolean coaltree;
	public static boolean redstonetree;
	public static boolean diamondtree;
	public static boolean emeraldtree;
	public static boolean lapistree;
	public static boolean quartztree;
	public static boolean glowstonetree;
	public static boolean obsidiantree;
	public static boolean xptree;
	public static boolean pumpkintree;

	public static boolean threex3recipechops;
	public static boolean usechops;

	public static boolean thaumictrees;

	public static String saplings;
	public static String THsaplings;
	public static String logs;
	public static String THlogs;
	public static String leaves;
	public static String THleaves;

	public void initConfiguration(FMLPreInitializationEvent e) {
		Configuration config = new Configuration(new File("config/treeores.cfg"));
		config.load();

		canboneMeal = config.get("bonemeal", "Can Use Bonemeal?", true).getBoolean();
		irontree = config.get("blocks", "Does Iron Tree Grow?", true).getBoolean();
		goldtree = config.get("blocks", "Does Gold Tree Grow?", true).getBoolean();
		coaltree = config.get("blocks", "Does Coal Tree Grow?", true).getBoolean();
		redstonetree = config.get("blocks", "Does Redstone Tree Grow?", true).getBoolean();
		diamondtree = config.get("blocks", "Does Diamond Tree Grow?", true).getBoolean();
		emeraldtree = config.get("blocks", "Does Emerald Tree Grow?", true).getBoolean();
		lapistree = config.get("blocks", "Does Lapis Tree Grow?", true).getBoolean();
		quartztree = config.get("blocks", "Does Quartz Tree Grow?", true).getBoolean();
		glowstonetree = config.get("blocks", "Does Glowstone Tree Grow?", true).getBoolean();
		obsidiantree = config.get("blocks", "Does Obsidian Tree Grow?", true).getBoolean();
		xptree = config.get("blocks", "Does XP Tree Grow?", true).getBoolean();
		pumpkintree = config.get("blocks", "Does Pumpkin Tree Grow?", true).getBoolean();
		saplings = config.get("oredict", "oredict for saplings", "treeSapling").getString();
		logs = config.get("oredict", "oredict for logs", "logWood").getString();
		leaves = config.get("oredict", "oredict for leaves", "treeLeaves").getString();

		if (Loader.isModLoaded("Thaumcraft")) {
			thaumictrees = config.get("blocks", "Does Thaumcraft Trees Grow?", true).getBoolean();
			THlogs = config.get("oredict", "oredict for thaumcraft logs", "logWood").toString();
			THleaves = config.get("oredict", "oredict for thaumcraft leaves", "treeLeaves").toString();
			THsaplings = config.get("oredict", "oredict for thaumcraft saplings", "treeSapling").toString();

		}

		usechops = config.get("recipes", "you want to use chops?", true).getBoolean();
		threex3recipechops = config.get("recipes", "is log recipe 3x3?", false).getBoolean();

		config.save();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		this.initConfiguration(e);

		FMLCommonHandler.instance().bus().register(new UpdateEvent());

		treeores = new CreativeTabs("treeoress") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return Item.getItemFromBlock(Blocks.sapling);
			}
		};

		checkupdateswithtrycatch();

		if (Loader.isModLoaded("Thaumcraft")) {
			everythingThaumcraft();
		}

		initializeBlocks();

		initializeChops();

		initializeTransformers();

		initializeSpawners();

		registerSpawners();

		registerBlocks();

		registerItems();

		addrecipes();

		oreDict();

		registerChops();

		proxy.registerRenderThings();

		registerEntities();

	}

	public void checkupdateswithtrycatch() {
		try {
			CheckUpdates.checkUpdate();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void everythingThaumcraft() {
		AspectList transformerlist = new AspectList();
		transformerlist.add(Aspect.EARTH, 50);
		ThaumcraftLog = new THLog().setBlockName("THLog").setCreativeTab(treeores);
		ThaumcraftLeaf = new THLeaf().setBlockName("THLeaf").setCreativeTab(treeores);
		ThaumcraftSapling = new THSapling().setBlockName("THSapling").setCreativeTab(treeores);
		ThaumcraftChop = new THChops().setUnlocalizedName("THchop").setCreativeTab(treeores);
		ThaumcraftLog2 = new THLog2().setBlockName("THLog2").setCreativeTab(treeores);
		ThaumcraftLeaf2 = new THLeaf2().setBlockName("THLeaf2").setCreativeTab(treeores);
		ThaumcraftSapling2 = new THSapling2().setBlockName("THSapling2").setCreativeTab(treeores);
		ThaumcraftChop2 = new THChop2().setUnlocalizedName("THchop2").setCreativeTab(treeores);
		ThaumcraftTransformer = new THTransformer().setUnlocalizedName("thitt").setCreativeTab(treeores);
		ThaumcraftTransformer.setContainerItem(TreeOres.ThaumcraftTransformer);

		ItemStack airshard = new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 0);
		ItemStack fireshard = new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 1);
		ItemStack watershard = new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 2);
		ItemStack earthshard = new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 3);
		ItemStack ordershard = new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 4);
		ItemStack entropyshard = new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 5);
		ItemStack quicksilver = new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 1, 3);
		ItemStack thaumiumingot = new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 1, 2);
		ItemStack log = new ItemStack(Blocks.log);

		ThaumcraftApi.addArcaneCraftingRecipe("", new ItemStack(TreeOres.ThaumcraftTransformer), transformerlist, new Object[] { "AFW", "ELO", "KQI", 'A', airshard, 'F',
				fireshard, 'W', watershard, 'E', earthshard, 'L', log, 'O', ordershard, 'K', entropyshard, 'Q', quicksilver, 'I', thaumiumingot });

		GameRegistry.registerBlock(ThaumcraftLog, THILog.class, ThaumcraftLog.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ThaumcraftLeaf, THILeaf.class, ThaumcraftLeaf.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ThaumcraftSapling, THISapling.class, ThaumcraftSapling.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ThaumcraftChop, "THchops");
		GameRegistry.registerCustomItemStack("thaumic", new ItemStack(ThaumcraftChop, 1, 0));
		GameRegistry.registerCustomItemStack("air", new ItemStack(ThaumcraftChop, 1, 1));
		GameRegistry.registerCustomItemStack("fire", new ItemStack(ThaumcraftChop, 1, 2));
		GameRegistry.registerCustomItemStack("water", new ItemStack(ThaumcraftChop, 1, 3));
		GameRegistry.registerBlock(ThaumcraftLog2, THILog2.class, ThaumcraftLog2.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ThaumcraftLeaf2, THILeaf2.class, ThaumcraftLeaf2.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ThaumcraftSapling2, THISapling2.class, ThaumcraftSapling2.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ThaumcraftTransformer, "THTransformer");
		GameRegistry.registerItem(ThaumcraftChop2, "THchops2");
		GameRegistry.registerCustomItemStack("earth", new ItemStack(ThaumcraftChop2, 1, 0));
		GameRegistry.registerCustomItemStack("order", new ItemStack(ThaumcraftChop2, 1, 1));
		GameRegistry.registerCustomItemStack("entropy", new ItemStack(ThaumcraftChop2, 1, 2));

		OreDictionary.registerOre(THlogs, new ItemStack(ThaumcraftLog, 1, Short.MAX_VALUE));
		OreDictionary.registerOre(THleaves, new ItemStack(ThaumcraftLeaf, 1, Short.MAX_VALUE));
		OreDictionary.registerOre(THsaplings, new ItemStack(ThaumcraftSapling, 1, Short.MAX_VALUE));
		OreDictionary.registerOre(THlogs, new ItemStack(ThaumcraftLog2, 1, Short.MAX_VALUE));
		OreDictionary.registerOre(THleaves, new ItemStack(ThaumcraftLeaf2, 1, Short.MAX_VALUE));
		OreDictionary.registerOre(THsaplings, new ItemStack(ThaumcraftSapling2, 1, Short.MAX_VALUE));
	}

	public void initializeBlocks() {
		blockLog = new NCLog().setBlockName("Log").setCreativeTab(treeores);
		blockLog2 = new NCLog2().setBlockName("Log2").setCreativeTab(treeores);
		blockLog3 = new NCLog3().setBlockName("Log3").setCreativeTab(treeores);
		blockLeaf = new NCLeaf().setBlockName("Leaf").setCreativeTab(treeores);
		bossLeaf = new BossLeaf().setBlockName("Leaf");
		bossLeaf2 = new BossLeaf2().setBlockName("Leaf");
		bossLeaf3 = new BossLeaf3().setBlockName("Leaf");
		bossLeaf4 = new BossLeaf4().setBlockName("Leaf");
		blockLeaf2 = new NCLeaf2().setBlockName("Leaf2").setCreativeTab(treeores);
		blockLeaf3 = new NCLeaf3().setBlockName("Leaf3").setCreativeTab(treeores);
		blockLeaf4 = new NCLeaf4().setBlockName("Leaf4").setCreativeTab(treeores);
		blockSapling = new NCSapling().setBlockName("sapling").setCreativeTab(treeores);
		BossSapling = new BossSapling().setBlockName("sapling").setCreativeTab(treeores);
		BossSapling2 = new BossSapling2().setBlockName("sapling").setCreativeTab(treeores);
		blockSapling2 = new NCSapling2().setBlockName("sapling2").setCreativeTab(treeores);
		blockTreeWorkstation = new TreeStation().setBlockName("TreeStation").setCreativeTab(treeores);
	}

	public void initializeChops() {
		Woodchops = new ItemChops().setUnlocalizedName("chop").setCreativeTab(treeores);
		Woodchops2 = new ItemChops2().setUnlocalizedName("chop2").setCreativeTab(treeores);
		Woodchops3 = new ItemChops3().setUnlocalizedName("chop3").setCreativeTab(treeores);
	}

	public void initializeTransformers() {
		itemTransformer = new ItemTransformer().setUnlocalizedName("itt").setCreativeTab(treeores);
		itemTransformer.setContainerItem(TreeOres.itemTransformer);
		itemTransformerNether = new ItemTransformerNether().setUnlocalizedName("ittn").setCreativeTab(treeores);
		itemTransformerNether.setContainerItem(TreeOres.itemTransformerNether);
		itemTransformerReinforced = new ItemTransformerReinforced().setUnlocalizedName("ittr").setCreativeTab(treeores);
		itemTransformerReinforced.setContainerItem(TreeOres.itemTransformerReinforced);
	}

	public void initializeSpawners() {
		ironSpawner = new ItemIronSpawner().setCreativeTab(treeores).setUnlocalizedName("irs");
		goldSpawner = new ItemGoldSpawner().setCreativeTab(treeores).setUnlocalizedName("gos");
		coalSpawner = new ItemCoalSpawner().setCreativeTab(treeores).setUnlocalizedName("cos");
		redstoneSpawner = new ItemRedstoneSpawner().setCreativeTab(treeores).setUnlocalizedName("res");
		diamondSpawner = new ItemDiamondSpawner().setCreativeTab(treeores).setUnlocalizedName("dis");
		emeraldSpawner = new ItemEmeraldSpawner().setCreativeTab(treeores).setUnlocalizedName("ems");
		lapisSpawner = new ItemLapisSpawner().setCreativeTab(treeores).setUnlocalizedName("las");
		quartzSpawner = new ItemQuartzSpawner().setCreativeTab(treeores).setUnlocalizedName("qus");
		glowstoneSpawner = new ItemGlowstoneSpawner().setCreativeTab(treeores).setUnlocalizedName("gls");
		xpSpawner = new ItemXpSpawner().setCreativeTab(treeores).setUnlocalizedName("xps");
		obsidianSpawner = new ItemObsidianSpawner().setCreativeTab(treeores).setUnlocalizedName("obs");
		pumpkinSpawner = new ItemPumpkinSpawner().setCreativeTab(treeores).setUnlocalizedName("pus");
	}

	public void registerSpawners() {
		GameRegistry.registerItem(ironSpawner, ironSpawner.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldSpawner, goldSpawner.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(coalSpawner, coalSpawner.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(redstoneSpawner, redstoneSpawner.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(diamondSpawner, diamondSpawner.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(emeraldSpawner, emeraldSpawner.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(lapisSpawner, lapisSpawner.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(quartzSpawner, quartzSpawner.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(glowstoneSpawner, glowstoneSpawner.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(xpSpawner, xpSpawner.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(obsidianSpawner, obsidianSpawner.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(pumpkinSpawner, pumpkinSpawner.getUnlocalizedName().substring(5));
	}

	public void registerBlocks() {
		GameRegistry.registerBlock(blockLog, ItemLogBlocks.class, blockLog.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockLeaf, ItemLeafBlocks.class, blockLeaf.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(bossLeaf, ItemBossLeaf.class, bossLeaf.getUnlocalizedName().substring(5) + "b");
		GameRegistry.registerBlock(bossLeaf2, ItemBossLeaf2.class, bossLeaf2.getUnlocalizedName().substring(5) + "b2");
		GameRegistry.registerBlock(bossLeaf3, ItemBossLeaf3.class, bossLeaf3.getUnlocalizedName().substring(5) + "b3");
		GameRegistry.registerBlock(bossLeaf4, ItemBossLeaf4.class, bossLeaf4.getUnlocalizedName().substring(5) + "b4");
		GameRegistry.registerBlock(blockLog2, ItemLogBlocks2.class, blockLog2.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockLeaf2, ItemLeafBlocks2.class, blockLeaf2.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockLog3, ItemLogBlocks3.class, blockLog3.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockLeaf3, ItemLeafBlocks3.class, blockLeaf3.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockLeaf4, ItemLeafBlocks4.class, blockLeaf4.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockSapling, ItemSaplingBlocks.class, blockSapling.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(BossSapling, ItemBossSapling.class, BossSapling.getUnlocalizedName().substring(5) + "b");
		GameRegistry.registerBlock(BossSapling2, ItemBossSapling2.class, BossSapling2.getUnlocalizedName().substring(5) + "b2");
		GameRegistry.registerBlock(blockSapling2, ItemSaplingBlocks2.class, blockSapling2.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockTreeWorkstation, "TreeStation");
	}

	public void registerItems() {
		GameRegistry.registerItem(itemTransformer, "ItemTransformer");
		GameRegistry.registerItem(itemTransformerNether, "ItemTransformerNether");
		GameRegistry.registerItem(itemTransformerReinforced, "ItemTransformerReinforced");
	}

	public void addrecipes() {
		GameRegistry.addRecipe(new ItemStack(TreeOres.blockTreeWorkstation, 1), new Object[] { "WWW", "WIW", "WWW", 'W', Blocks.log, 'I', Items.iron_ingot });
		GameRegistry.addRecipe(new ItemStack(TreeOres.blockTreeWorkstation, 1), new Object[] { "WWW", "WIW", "WWW", 'W', Blocks.log2, 'I', Items.iron_ingot });
	}

	public void oreDict() {
		OreDictionary.registerOre(saplings, new ItemStack(blockSapling, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre(saplings, new ItemStack(blockSapling2, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre(logs, new ItemStack(blockLog, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre(logs, new ItemStack(blockLog2, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre(logs, new ItemStack(blockLog3, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre(leaves, new ItemStack(blockLeaf, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre(leaves, new ItemStack(blockLeaf2, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre(leaves, new ItemStack(blockLeaf3, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre(leaves, new ItemStack(blockLeaf4, 1, OreDictionary.WILDCARD_VALUE));
	}

	public void registerEntities() {
		// Entities
		EntityHandler.registerMonsters(EntityIronBoss.class, "IronTreeBoss");
		EntityHandler.registerMonsters(EntityGoldBoss.class, "GoldTreeBoss");
		EntityHandler.registerMonsters(EntityCoalBoss.class, "CoalTreeBoss");
		EntityHandler.registerMonsters(EntityRedstoneBoss.class, "RedstoneTreeBoss");
		EntityHandler.registerMonsters(EntityDiamondBoss.class, "DiamondTreeBoss");
		EntityHandler.registerMonsters(EntityEmeraldBoss.class, "EmeraldTreeBoss");
		EntityHandler.registerMonsters(EntityLapisBoss.class, "LapisTreeBoss");
		EntityHandler.registerMonsters(EntityQuartzBoss.class, "QuartzTreeBoss");
		EntityHandler.registerMonsters(EntityGlowstoneBoss.class, "GlowstoneTreeBoss");
		EntityHandler.registerMonsters(EntityObsidianBoss.class, "ObsidianTreeBoss");
		EntityHandler.registerMonsters(EntityXPBoss.class, "XPTreeBoss");
		EntityHandler.registerMonsters(EntityPumpkinBoss.class, "PumpkinTreeBoss");
	}

	public void registerChops() {
		GameRegistry.registerItem(Woodchops, "chops");
		GameRegistry.registerCustomItemStack("iron", new ItemStack(Woodchops, 1, 0));
		GameRegistry.registerCustomItemStack("gold", new ItemStack(Woodchops, 1, 1));
		GameRegistry.registerCustomItemStack("coal", new ItemStack(Woodchops, 1, 2));
		GameRegistry.registerCustomItemStack("redstone", new ItemStack(Woodchops, 1, 3));
		GameRegistry.registerItem(Woodchops2, "chops2");
		GameRegistry.registerCustomItemStack("diamond", new ItemStack(Woodchops2, 1, 0));
		GameRegistry.registerCustomItemStack("emerald", new ItemStack(Woodchops2, 1, 1));
		GameRegistry.registerCustomItemStack("lapis", new ItemStack(Woodchops2, 1, 2));
		GameRegistry.registerCustomItemStack("quartz", new ItemStack(Woodchops2, 1, 3));
		GameRegistry.registerItem(Woodchops3, "chops3");
		GameRegistry.registerCustomItemStack("glowstone", new ItemStack(Woodchops3, 1, 0));
		GameRegistry.registerCustomItemStack("obsidian", new ItemStack(Woodchops3, 1, 1));
		GameRegistry.registerCustomItemStack("xp", new ItemStack(Woodchops3, 1, 2));
		GameRegistry.registerCustomItemStack("pumpkin", new ItemStack(Woodchops3, 1, 3));
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(MODID, new TreeOresGuiHandler());
		proxy.registerProxies();
	}

}
