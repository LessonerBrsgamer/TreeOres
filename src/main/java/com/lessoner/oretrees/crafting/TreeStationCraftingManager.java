package com.lessoner.oretrees.crafting;

import ic2.api.item.IC2Items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import thaumcraft.api.ItemApi;

import com.lessoner.oretrees.TreeOres;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class TreeStationCraftingManager {
	/** The static instance of this class */
	private static final TreeStationCraftingManager instance = new TreeStationCraftingManager();
	/** A list of all the recipes added */
	private List recipes = new ArrayList();
	private static final String __OBFID = "CL_00000090";

	/**
	 * Returns the static instance of this class
	 */
	public static final TreeStationCraftingManager getInstance() {
		/** The static instance of this class */
		return instance;
	}

	private TreeStationCraftingManager() {
		recipes = new ArrayList();

		if (TreeOres.threex3recipechops == false) {
			for (int i = 0; i < 4; i++) {
				this.addRecipe(new ItemStack(TreeOres.blockLog, 1, i), new Object[] { "XX", "XX", 'X', new ItemStack(TreeOres.Woodchops, 1, i) });
			}
			for (int i = 0; i < 4; i++) {
				this.addRecipe(new ItemStack(TreeOres.blockLog2, 1, i), new Object[] { "XX", "XX", 'X', new ItemStack(TreeOres.Woodchops2, 1, i) });
			}
			for (int i = 0; i < 4; i++) {
				this.addRecipe(new ItemStack(TreeOres.blockLog3, 1, i), new Object[] { "XX", "XX", 'X', new ItemStack(TreeOres.Woodchops3, 1, i) });
			}
			for (int i = 0; i < 4; i++) {
				if (Loader.isModLoaded("Thaumcraft")) {
					this.addRecipe(new ItemStack(TreeOres.ThaumcraftLog, 1, i), new Object[] { "XX", "XX", 'X', new ItemStack(TreeOres.ThaumcraftChop, 1, i) });
				}
			}
			for (int i = 0; i < 4; i++) {
				if (Loader.isModLoaded("IC2")) {
					this.addRecipe(new ItemStack(TreeOres.IC2Log, 1, i), new Object[] { "XX", "XX", 'X', new ItemStack(TreeOres.IC2Chop, 1, i) });
				}
			}
			for (int i = 0; i < 4; i++) {
				if (Loader.isModLoaded("Thaumcraft")) {
					this.addRecipe(new ItemStack(TreeOres.ThaumcraftLog2, 1, i), new Object[] { "XX", "XX", 'X', new ItemStack(TreeOres.ThaumcraftChop2, 1, i) });
				}
			}
			for (int i = 0; i < 2; i++) {
				if (Loader.isModLoaded("TConstruct")) {
					this.addRecipe(new ItemStack(TreeOres.TCLog, 1, i), new Object[] { "XX", "XX", 'X', new ItemStack(TreeOres.TCChop, 1, i) });
				}
			}
		}

		if (TreeOres.threex3recipechops) {
			for (int i = 0; i < 4; i++) {
				this.addRecipe(new ItemStack(TreeOres.blockLog, 1, i), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(TreeOres.Woodchops, 1, i) });
			}
			for (int i = 0; i < 4; i++) {
				this.addRecipe(new ItemStack(TreeOres.blockLog2, 1, i), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(TreeOres.Woodchops2, 1, i) });
			}
			for (int i = 0; i < 4; i++) {
				this.addRecipe(new ItemStack(TreeOres.blockLog3, 1, i), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(TreeOres.Woodchops3, 1, i) });
			}
			for (int i = 0; i < 4; i++) {
				if (Loader.isModLoaded("Thaumcraft")) {
					this.addRecipe(new ItemStack(TreeOres.ThaumcraftLog, 1, i), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(TreeOres.ThaumcraftChop, 1, i) });
				}
			}
			for (int i = 0; i < 4; i++) {
				if (Loader.isModLoaded("Thaumcraft")) {
					this.addRecipe(new ItemStack(TreeOres.ThaumcraftLog2, 1, i), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(TreeOres.ThaumcraftChop2, 1, i) });
				}
			}
			for (int i = 0; i < 4; i++) {
				if (Loader.isModLoaded("IC2")) {
					this.addRecipe(new ItemStack(TreeOres.IC2Log, 1, i), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(TreeOres.IC2Chop, 1, i) });
				}
			}
			for (int i = 0; i < 2; i++) {
				if (Loader.isModLoaded("TConstruct")) {
					this.addRecipe(new ItemStack(TreeOres.TCLog, 1, i), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(TreeOres.TCChop, 1, i) });
				}
			}
		}

		this.addRecipe(new ItemStack(TreeOres.itemTransformer), new Object[] { " c ", "dsi", " g ", 'c', Items.coal, 'd', Items.diamond, 's', Items.slime_ball, 'i',
				Items.iron_ingot, 'g', Items.gold_ingot });
		this.addRecipe(new ItemStack(TreeOres.itemTransformerNether), new Object[] { "nnn", "ntn", "nnn", 't', TreeOres.itemTransformer, 'n', Blocks.netherrack, });
		this.addRecipe(new ItemStack(TreeOres.itemTransformerReinforced), new Object[] { "ddd", "dtI", "III", 't', TreeOres.itemTransformer, 'I', Items.iron_ingot, 'd',
				Items.diamond });
		if (TreeOres.irontree) {
			this.addRecipe(new ItemStack(TreeOres.blockSapling, 1, 0), new Object[] { "III", "ISI", "III", 'I', Blocks.iron_block, 'S', Blocks.sapling });
		}

		if (Loader.isModLoaded("TConstruct")) {
			this.addRecipe(new ItemStack(TreeOres.TCSapling, 1, 0), new Object[] { "XXX", "XSX", "XXX", 'X',
					new ItemStack(GameRegistry.findBlock("TConstruct", "MetalBlock"), 2, 1), 'S', Blocks.sapling });
			this.addRecipe(new ItemStack(TreeOres.TCSapling, 1, 1), new Object[] { "XXX", "XSX", "XXX", 'X',
					new ItemStack(GameRegistry.findBlock("TConstruct", "MetalBlock"), 2, 0), 'S', Blocks.sapling });

			this.addRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 8,4), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.TCLog, 1, 0), 'S',
					TreeOres.itemTransformerNether });
			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 7,4), new Object[] { new ItemStack(TreeOres.TCLog, 1, 0),
					new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.TCLog, 1, 0),
					new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.itemTransformerNether, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 6,4), new Object[] { new ItemStack(TreeOres.TCLog, 1, 0),
					new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.TCLog, 1, 0),
					new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.itemTransformerNether, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 5,4), new Object[] { new ItemStack(TreeOres.TCLog, 1, 0),
					new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.TCLog, 1, 0),
					new ItemStack(TreeOres.itemTransformerNether, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 4,4), new Object[] { new ItemStack(TreeOres.TCLog, 1, 0),
					new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.itemTransformerNether, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 3,4), new Object[] { new ItemStack(TreeOres.TCLog, 1, 0),
					new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.itemTransformerNether, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 2,4), new Object[] { new ItemStack(TreeOres.TCLog, 1, 0),
					new ItemStack(TreeOres.TCLog, 1, 0), new ItemStack(TreeOres.itemTransformerNether, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 1,4), new Object[] { new ItemStack(TreeOres.TCLog, 1, 0),
					new ItemStack(TreeOres.itemTransformerNether, 1) });

			this.addRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 8,3), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.TCLog, 1, 1), 'S',
					TreeOres.itemTransformerNether });
			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 7,3), new Object[] { new ItemStack(TreeOres.TCLog, 1, 1),
					new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.TCLog, 1, 1),
					new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.itemTransformerNether, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 6,3), new Object[] { new ItemStack(TreeOres.TCLog, 1, 1),
					new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.TCLog, 1, 1),
					new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.itemTransformerNether, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 5,3), new Object[] { new ItemStack(TreeOres.TCLog, 1, 1),
					new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.TCLog, 1, 1),
					new ItemStack(TreeOres.itemTransformerNether, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 4,3), new Object[] { new ItemStack(TreeOres.TCLog, 1, 1),
					new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.itemTransformerNether, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 3,3), new Object[] { new ItemStack(TreeOres.TCLog, 1, 1),
					new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.itemTransformerNether, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 2,3), new Object[] { new ItemStack(TreeOres.TCLog, 1, 1),
					new ItemStack(TreeOres.TCLog, 1, 1), new ItemStack(TreeOres.itemTransformerNether, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 1,3), new Object[] { new ItemStack(TreeOres.TCLog, 1, 1),
					new ItemStack(TreeOres.itemTransformerNether, 1) });

		}

		if (Loader.isModLoaded("IC2")) {
			if (TreeOres.IC2trees) {

				this.addRecipe(new ItemStack(TreeOres.IC2Sapling, 1, 0), new Object[] { "XXX", "XSX", "XXX", 'X', IC2Items.getItem("copperBlock"), 'S', Blocks.sapling });
				this.addRecipe(new ItemStack(TreeOres.IC2Sapling, 1, 1), new Object[] { "XXX", "XSX", "XXX", 'X', IC2Items.getItem("tinBlock"), 'S', Blocks.sapling });
				this.addRecipe(new ItemStack(TreeOres.IC2Sapling, 1, 2), new Object[] { "XXX", "XSX", "XXX", 'X', IC2Items.getItem("uraniumBlock"), 'S', Blocks.sapling });
				this.addRecipe(new ItemStack(TreeOres.IC2Sapling, 1, 3), new Object[] { "XXX", "XSX", "XXX", 'X', IC2Items.getItem("leadBlock"), 'S', Blocks.sapling });

				this.addRecipe(new ItemStack(GameRegistry.findItem("IC2", "copperIngot"), 8), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.IC2Log, 1, 0), 'S',
						TreeOres.itemTransformer });
				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "copperIngot"), 7), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 0),
						new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.IC2Log, 1, 0),
						new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "copperIngot"), 6), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 0),
						new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.IC2Log, 1, 0),
						new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "copperIngot"), 5), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 0),
						new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.IC2Log, 1, 0),
						new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "copperIngot"), 4), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 0),
						new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.IC2Log, 1, 0),
						new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "copperIngot"), 3), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 0),
						new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "copperIngot"), 2), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 0),
						new ItemStack(TreeOres.IC2Log, 1, 0), new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "copperIngot"), 1), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 0),
						new ItemStack(TreeOres.itemTransformer, 1) });

				this.addRecipe(new ItemStack(GameRegistry.findItem("IC2", "tinIngot"), 8), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.IC2Log, 1, 1), 'S',
						TreeOres.itemTransformer });
				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "tinIngot"), 7), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 1),
						new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.IC2Log, 1, 1),
						new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "tinIngot"), 6), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 1),
						new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.IC2Log, 1, 1),
						new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "tinIngot"), 5), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 1),
						new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.IC2Log, 1, 1),
						new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "tinIngot"), 4), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 1),
						new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.IC2Log, 1, 1),
						new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "tinIngot"), 3), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 1),
						new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "tinIngot"), 2), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 1),
						new ItemStack(TreeOres.IC2Log, 1, 1), new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "tinIngot"), 1), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 1),
						new ItemStack(TreeOres.itemTransformer, 1) });

				this.addRecipe(new ItemStack(GameRegistry.findItem("IC2", "uraniumIngot"), 8), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.IC2Log, 1, 0), 'S',
						TreeOres.itemTransformer });
				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "uraniumIngot"), 7), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 2),
						new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.IC2Log, 1, 2),
						new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "uraniumIngot"), 6), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 2),
						new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.IC2Log, 1, 2),
						new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "uraniumIngot"), 5), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 2),
						new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.IC2Log, 1, 2),
						new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "uraniumIngot"), 4), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 2),
						new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.IC2Log, 1, 2),
						new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "uraniumIngot"), 3), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 2),
						new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "uraniumIngot"), 2), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 2),
						new ItemStack(TreeOres.IC2Log, 1, 2), new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "uraniumIngot"), 1), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 2),
						new ItemStack(TreeOres.itemTransformer, 1) });

				this.addRecipe(new ItemStack(GameRegistry.findItem("IC2", "leadIngot"), 8), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.IC2Log, 1, 0), 'S',
						TreeOres.itemTransformer });
				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "leadIngot"), 7), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 3),
						new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.IC2Log, 1, 3),
						new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "leadIngot"), 6), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 3),
						new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.IC2Log, 1, 3),
						new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "leadIngot"), 5), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 3),
						new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.IC2Log, 1, 3),
						new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "leadIngot"), 4), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 3),
						new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.IC2Log, 1, 3),
						new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "leadIngot"), 3), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 3),
						new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "leadIngot"), 2), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 3),
						new ItemStack(TreeOres.IC2Log, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

				this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("IC2", "leadIngot"), 1), new Object[] { new ItemStack(TreeOres.IC2Log, 1, 3),
						new ItemStack(TreeOres.itemTransformer, 1) });
			}
		}

		if (Loader.isModLoaded("Thaumcraft")) {
			if (TreeOres.thaumictrees) {
				this.addRecipe(new ItemStack(TreeOres.ThaumcraftSapling, 1, 0), new Object[] { "XXX", "XSX", "XXX", 'X', ItemApi.getBlock("blockCosmeticSolid", 4), 'S',
						Blocks.sapling });
			}
			if (TreeOres.thaumictrees) {
				this.addRecipe(new ItemStack(TreeOres.ThaumcraftSapling, 1, 1), new Object[] { "XXX", "XSX", "XXX", 'X', ItemApi.getBlock("blockCrystal", 0), 'S', Blocks.sapling });
			}
			if (TreeOres.thaumictrees) {
				this.addRecipe(new ItemStack(TreeOres.ThaumcraftSapling, 1, 2), new Object[] { "XXX", "XSX", "XXX", 'X', ItemApi.getBlock("blockCrystal", 1), 'S', Blocks.sapling });
			}
			if (TreeOres.thaumictrees) {
				this.addRecipe(new ItemStack(TreeOres.ThaumcraftSapling, 1, 3), new Object[] { "XXX", "XSX", "XXX", 'X', ItemApi.getBlock("blockCrystal", 2), 'S', Blocks.sapling });
			}
			if (TreeOres.thaumictrees) {
				this.addRecipe(new ItemStack(TreeOres.ThaumcraftSapling2, 1, 1),
						new Object[] { "XXX", "XSX", "XXX", 'X', ItemApi.getBlock("blockCrystal", 3), 'S', Blocks.sapling });
			}
			if (TreeOres.thaumictrees) {
				this.addRecipe(new ItemStack(TreeOres.ThaumcraftSapling2, 1, 2),
						new Object[] { "XXX", "XSX", "XXX", 'X', ItemApi.getBlock("blockCrystal", 4), 'S', Blocks.sapling });
			}
			if (TreeOres.thaumictrees) {
				this.addRecipe(new ItemStack(TreeOres.ThaumcraftSapling2, 1, 0),
						new Object[] { "XXX", "XSX", "XXX", 'X', ItemApi.getBlock("blockCrystal", 5), 'S', Blocks.sapling });
			}
			if (TreeOres.thaumictrees) {
				this.addRecipe(new ItemStack(TreeOres.ThaumcraftSapling2, 1, 3), new Object[] { "XXX", "XSX", "XXX", 'X', ItemApi.getItem("itemResource", 3), 'S', Blocks.sapling });
			}
			this.addRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 8, 2), new Object[] { "III", "ISI", "III", 'I',
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), 'S', TreeOres.ThaumcraftTransformer });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 7, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 6, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 5, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 4, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 3, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 2, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 1, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 8, 3), new Object[] { "III", "ISI", "III", 'I',
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), 'S', TreeOres.ThaumcraftTransformer });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 7, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 6, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 5, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 4, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 3, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 2, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 1, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 8, 0), new Object[] { "III", "ISI", "III", 'I',
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), 'S', TreeOres.ThaumcraftTransformer });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 7, 0), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 6, 0), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 5, 0), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 4, 0), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 3, 0), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 2, 0), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 0), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 8, 1), new Object[] { "III", "ISI", "III", 'I',
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), 'S', TreeOres.ThaumcraftTransformer });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 7, 1), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 6, 1), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 5, 1), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 4, 1), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 3, 1), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 2, 1), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 8, 2), new Object[] { "III", "ISI", "III", 'I',
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), 'S', TreeOres.ThaumcraftTransformer });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 7, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 6, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 5, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 4, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 3, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 2, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 8, 3), new Object[] { "III", "ISI", "III", 'I',
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), 'S', TreeOres.ThaumcraftTransformer });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 7, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 6, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 5, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 4, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 3, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 2, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 8, 4), new Object[] { "III", "ISI", "III", 'I',
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), 'S', TreeOres.ThaumcraftTransformer });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 7, 4), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 6, 4), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 5, 4), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 4, 4), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 3, 4), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 2, 4), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 4), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 8, 5), new Object[] { "III", "ISI", "III", 'I',
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), 'S', TreeOres.ThaumcraftTransformer });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 7, 5), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 6, 5), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 5, 5), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 4, 5), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 3, 5), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 2, 5), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 5), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

		}
		if (TreeOres.goldtree) {
			this.addRecipe(new ItemStack(TreeOres.blockSapling, 1, 1), new Object[] { "III", "ISI", "III", 'I', Blocks.gold_block, 'S', Blocks.sapling });
		}
		if (TreeOres.coaltree) {
			this.addRecipe(new ItemStack(TreeOres.blockSapling, 1, 2), new Object[] { "III", "ISI", "III", 'I', Blocks.coal_block, 'S', Blocks.sapling });
		}
		if (TreeOres.redstonetree) {
			this.addRecipe(new ItemStack(TreeOres.blockSapling, 1, 3), new Object[] { "III", "ISI", "III", 'I', Blocks.redstone_block, 'S', Blocks.sapling });
		}
		if (TreeOres.diamondtree) {
			this.addRecipe(new ItemStack(TreeOres.blockSapling, 1, 4), new Object[] { "III", "ISI", "III", 'I', Items.diamond, 'S', Blocks.sapling });
		}
		if (TreeOres.emeraldtree) {
			this.addRecipe(new ItemStack(TreeOres.blockSapling, 1, 5), new Object[] { "III", "ISI", "III", 'I', Items.emerald, 'S', Blocks.sapling });
		}
		if (TreeOres.quartztree) {
			this.addRecipe(new ItemStack(TreeOres.blockSapling2, 1, 2), new Object[] { "III", "ISI", "III", 'I', Blocks.quartz_block, 'S', Blocks.sapling });
		}
		if (TreeOres.lapistree) {
			this.addRecipe(new ItemStack(TreeOres.blockSapling2, 1, 3), new Object[] { "III", "ISI", "III", 'I', Blocks.lapis_block, 'S', Blocks.sapling });
		}
		if (TreeOres.glowstonetree) {
			this.addRecipe(new ItemStack(TreeOres.blockSapling2, 1, 0), new Object[] { "III", "ISI", "III", 'I', Blocks.glowstone, 'S', Blocks.sapling });
		}
		if (TreeOres.obsidiantree) {
			this.addRecipe(new ItemStack(TreeOres.blockSapling2, 1, 1), new Object[] { "III", "ISI", "III", 'I', Blocks.obsidian, 'S', Blocks.sapling });
		}
		if (TreeOres.xptree) {
			this.addRecipe(new ItemStack(TreeOres.blockSapling2, 1, 4), new Object[] { "TEF", "GSB", "WOA", 'T', Items.string, 'F', Items.rotten_flesh, 'E', Items.spider_eye, 'G',
					Items.gunpowder, 'B', Items.bone, 'W', Items.diamond_sword, 'O', Items.bow, 'A', Items.arrow, 'S', Blocks.sapling });
		}
		if (TreeOres.pumpkintree) {
			this.addRecipe(new ItemStack(TreeOres.blockSapling2, 1, 5), new Object[] { "III", "ISI", "III", 'I', Blocks.pumpkin, 'S', Blocks.sapling });
		}

		this.addRecipe(new ItemStack(Items.iron_ingot, 8), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.blockLog, 1, 0), 'S', TreeOres.itemTransformer });
		this.addShapelessRecipe(new ItemStack(Items.iron_ingot, 7), new Object[] { new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.blockLog, 1, 0),
				new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.blockLog, 1, 0),
				new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.iron_ingot, 6), new Object[] { new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.blockLog, 1, 0),
				new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.blockLog, 1, 0),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.iron_ingot, 5),
				new Object[] { new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.blockLog, 1, 0),
						new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.iron_ingot, 4), new Object[] { new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.blockLog, 1, 0),
				new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.iron_ingot, 3), new Object[] { new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.blockLog, 1, 0),
				new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.iron_ingot, 2), new Object[] { new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.blockLog, 1, 0),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.iron_ingot, 1), new Object[] { new ItemStack(TreeOres.blockLog, 1, 0), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addRecipe(new ItemStack(Items.gold_ingot, 8), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.blockLog, 1, 1), 'S', TreeOres.itemTransformer });
		this.addShapelessRecipe(new ItemStack(Items.gold_ingot, 7), new Object[] { new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.blockLog, 1, 1),
				new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.blockLog, 1, 1),
				new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.gold_ingot, 6), new Object[] { new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.blockLog, 1, 1),
				new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.blockLog, 1, 1),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.gold_ingot, 5),
				new Object[] { new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.blockLog, 1, 1),
						new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.gold_ingot, 4), new Object[] { new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.blockLog, 1, 1),
				new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.gold_ingot, 3), new Object[] { new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.blockLog, 1, 1),
				new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.gold_ingot, 2), new Object[] { new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.blockLog, 1, 1),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.gold_ingot, 1), new Object[] { new ItemStack(TreeOres.blockLog, 1, 1), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addRecipe(new ItemStack(Items.coal, 8), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.blockLog, 1, 2), 'S', TreeOres.itemTransformer });
		this.addShapelessRecipe(new ItemStack(Items.coal, 7), new Object[] { new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.blockLog, 1, 2),
				new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.blockLog, 1, 2),
				new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.coal, 6), new Object[] { new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.blockLog, 1, 2),
				new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.blockLog, 1, 2),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.coal, 5),
				new Object[] { new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.blockLog, 1, 2),
						new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.coal, 4), new Object[] { new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.blockLog, 1, 2),
				new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.coal, 3), new Object[] { new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.blockLog, 1, 2),
				new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.coal, 2), new Object[] { new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.blockLog, 1, 2),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.coal, 1), new Object[] { new ItemStack(TreeOres.blockLog, 1, 2), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addRecipe(new ItemStack(Blocks.redstone_block, 8), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.blockLog, 1, 3), 'S', TreeOres.itemTransformer });
		this.addShapelessRecipe(new ItemStack(Blocks.redstone_block, 7), new Object[] { new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.blockLog, 1, 3),
				new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.blockLog, 1, 3),
				new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.redstone_block, 6), new Object[] { new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.blockLog, 1, 3),
				new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.blockLog, 1, 3),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.redstone_block, 5),
				new Object[] { new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.blockLog, 1, 3),
						new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.redstone_block, 4), new Object[] { new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.blockLog, 1, 3),
				new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.redstone_block, 3), new Object[] { new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.blockLog, 1, 3),
				new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.redstone_block, 2), new Object[] { new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.blockLog, 1, 3),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.redstone_block, 1), new Object[] { new ItemStack(TreeOres.blockLog, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addRecipe(new ItemStack(Items.diamond, 8), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.blockLog2, 1, 0), 'S', TreeOres.itemTransformer });

		this.addShapelessRecipe(new ItemStack(Items.diamond, 7), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.blockLog2, 1, 0),
				new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.blockLog2, 1, 0),
				new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.diamond, 6), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.blockLog2, 1, 0),
				new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.blockLog2, 1, 0),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.diamond, 5), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.blockLog2, 1, 0),
				new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.blockLog2, 1, 0),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.diamond, 4), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.blockLog2, 1, 0),
				new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.diamond, 3), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.blockLog2, 1, 0),
				new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.diamond, 2), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.blockLog2, 1, 0),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.diamond, 1), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 0), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addRecipe(new ItemStack(Items.emerald, 8), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.blockLog2, 1, 1), 'S', TreeOres.itemTransformer });

		this.addShapelessRecipe(new ItemStack(Items.emerald, 7), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.blockLog2, 1, 1),
				new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.blockLog2, 1, 1),
				new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.emerald, 6), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.blockLog2, 1, 1),
				new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.blockLog2, 1, 1),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.emerald, 5), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.blockLog2, 1, 1),
				new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.blockLog2, 1, 1),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.emerald, 4), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.blockLog2, 1, 1),
				new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.emerald, 3), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.blockLog2, 1, 1),
				new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.emerald, 2), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.blockLog2, 1, 1),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.emerald, 1), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 1), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addRecipe(new ItemStack(Items.quartz, 8), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.blockLog2, 1, 2), 'S', TreeOres.itemTransformerNether });

		this.addShapelessRecipe(new ItemStack(Items.quartz, 7), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.blockLog2, 1, 2),
				new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.blockLog2, 1, 2),
				new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.itemTransformerNether, 1) });

		this.addShapelessRecipe(new ItemStack(Items.quartz, 6), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.blockLog2, 1, 2),
				new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.blockLog2, 1, 2),
				new ItemStack(TreeOres.itemTransformerNether, 1) });

		this.addShapelessRecipe(new ItemStack(Items.quartz, 5), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.blockLog2, 1, 2),
				new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.blockLog2, 1, 2),
				new ItemStack(TreeOres.itemTransformerNether, 1) });

		this.addShapelessRecipe(new ItemStack(Items.quartz, 4), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.blockLog2, 1, 2),
				new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.itemTransformerNether, 1) });

		this.addShapelessRecipe(new ItemStack(Items.quartz, 3), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.blockLog2, 1, 2),
				new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.itemTransformerNether, 1) });

		this.addShapelessRecipe(new ItemStack(Items.quartz, 2), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.blockLog2, 1, 2),
				new ItemStack(TreeOres.itemTransformerNether, 1) });

		this.addShapelessRecipe(new ItemStack(Items.quartz, 1), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 2), new ItemStack(TreeOres.itemTransformerNether, 1) });

		this.addRecipe(new ItemStack(Blocks.lapis_block, 8), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.blockLog2, 1, 3), 'S', TreeOres.itemTransformer });

		this.addShapelessRecipe(new ItemStack(Blocks.lapis_block, 7), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.blockLog2, 1, 3),
				new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.blockLog2, 1, 3),
				new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.lapis_block, 6), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.blockLog2, 1, 3),
				new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.blockLog2, 1, 3),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.lapis_block, 5), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.blockLog2, 1, 3),
				new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.blockLog2, 1, 3),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.lapis_block, 4), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.blockLog2, 1, 3),
				new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.lapis_block, 3), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.blockLog2, 1, 3),
				new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.lapis_block, 2), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.blockLog2, 1, 3),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.lapis_block, 1), new Object[] { new ItemStack(TreeOres.blockLog2, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addRecipe(new ItemStack(Blocks.glowstone, 8), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.blockLog3, 1, 0), 'S', TreeOres.itemTransformerNether });

		this.addShapelessRecipe(new ItemStack(Blocks.glowstone, 7), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.blockLog3, 1, 0),
				new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.blockLog3, 1, 0),
				new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.itemTransformerNether, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.glowstone, 6), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.blockLog3, 1, 0),
				new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.blockLog3, 1, 0),
				new ItemStack(TreeOres.itemTransformerNether, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.glowstone, 5), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.blockLog3, 1, 0),
				new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.blockLog3, 1, 0),
				new ItemStack(TreeOres.itemTransformerNether, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.glowstone, 4), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.blockLog3, 1, 0),
				new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.itemTransformerNether, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.glowstone, 3), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.blockLog3, 1, 0),
				new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.itemTransformerNether, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.glowstone, 2), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.blockLog3, 1, 0),
				new ItemStack(TreeOres.itemTransformerNether, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.glowstone, 1), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 0), new ItemStack(TreeOres.itemTransformerNether, 1) });

		this.addRecipe(new ItemStack(Blocks.obsidian, 8),
				new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.blockLog3, 1, 1), 'S', TreeOres.itemTransformerReinforced });

		this.addShapelessRecipe(new ItemStack(Blocks.obsidian, 7), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.blockLog3, 1, 1),
				new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.blockLog3, 1, 1),
				new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.itemTransformerReinforced, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.obsidian, 6), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.blockLog3, 1, 1),
				new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.blockLog3, 1, 1),
				new ItemStack(TreeOres.itemTransformerReinforced, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.obsidian, 5), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.blockLog3, 1, 1),
				new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.blockLog3, 1, 1),
				new ItemStack(TreeOres.itemTransformerReinforced, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.obsidian, 4), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.blockLog3, 1, 1),
				new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.itemTransformerReinforced, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.obsidian, 3), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.blockLog3, 1, 1),
				new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.itemTransformerReinforced, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.obsidian, 2), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.blockLog3, 1, 1),
				new ItemStack(TreeOres.itemTransformerReinforced, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.obsidian, 1), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 1), new ItemStack(TreeOres.itemTransformerReinforced, 1) });

		this.addRecipe(new ItemStack(Items.experience_bottle, 8), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.blockLog3, 1, 2), 'S', TreeOres.itemTransformer });

		this.addShapelessRecipe(new ItemStack(Items.experience_bottle, 7), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.blockLog3, 1, 2),
				new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.blockLog3, 1, 2),
				new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.experience_bottle, 6), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.blockLog3, 1, 2),
				new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.blockLog3, 1, 2),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.experience_bottle, 5), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.blockLog3, 1, 2),
				new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.blockLog3, 1, 2),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.experience_bottle, 4), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.blockLog3, 1, 2),
				new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.experience_bottle, 3), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.blockLog3, 1, 2),
				new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.experience_bottle, 2), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.blockLog3, 1, 2),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Items.experience_bottle, 1), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 2), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addRecipe(new ItemStack(Blocks.pumpkin, 8), new Object[] { "III", "ISI", "III", 'I', new ItemStack(TreeOres.blockLog3, 1, 3), 'S', TreeOres.itemTransformer });

		this.addShapelessRecipe(new ItemStack(Blocks.pumpkin, 7), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.blockLog3, 1, 3),
				new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.blockLog3, 1, 3),
				new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.pumpkin, 6), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.blockLog3, 1, 3),
				new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.blockLog3, 1, 3),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.pumpkin, 5), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.blockLog3, 1, 3),
				new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.blockLog3, 1, 3),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.pumpkin, 4), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.blockLog3, 1, 3),
				new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.pumpkin, 3), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.blockLog3, 1, 3),
				new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.pumpkin, 2), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.blockLog3, 1, 3),
				new ItemStack(TreeOres.itemTransformer, 1) });

		this.addShapelessRecipe(new ItemStack(Blocks.pumpkin, 1), new Object[] { new ItemStack(TreeOres.blockLog3, 1, 3), new ItemStack(TreeOres.itemTransformer, 1) });

		if (Loader.isModLoaded("Thaumcraft")) {
			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 7, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 6, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 5, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 4, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 3, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 2, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 0), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 1, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 0),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 7, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 6, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 5, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 4, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 3, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 2, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 3), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 1, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 3),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 7, 0), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 6, 0), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 5, 0), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 4, 0), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 3, 0), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 2, 0), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 1), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 0), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 1),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 7, 1), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 6, 1), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 5, 1), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 4, 1), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 3, 1), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 2, 1), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 2), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 1), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 2),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 7, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 6, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 5, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 4, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 3, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 2, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftLog, 1, 3), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 2), new Object[] { new ItemStack(TreeOres.ThaumcraftLog, 1, 3),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 7, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 6, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 5, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 4, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 3, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 2, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 0), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 3), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 0),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 7, 4), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 6, 4), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 5, 4), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 4, 4), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 3, 4), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 2, 4), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 1), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 4), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 1),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 7, 5), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 6, 5), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 5, 5), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 4, 5), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 3, 5), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 2, 5), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftLog2, 1, 2), new ItemStack(TreeOres.ThaumcraftTransformer, 1) });

			this.addShapelessRecipe(new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 5), new Object[] { new ItemStack(TreeOres.ThaumcraftLog2, 1, 2),
					new ItemStack(TreeOres.ThaumcraftTransformer, 1) });
		}

		this.addRecipe(new ItemStack(TreeOres.ironSpawner),
				new Object[] { "III", "ISI", "III", 'I', new ItemStack(Blocks.iron_block), 'S', new ItemStack(TreeOres.blockLog, 1, 0) });

		this.addRecipe(new ItemStack(TreeOres.goldSpawner),
				new Object[] { "III", "ISI", "III", 'I', new ItemStack(Blocks.gold_block), 'S', new ItemStack(TreeOres.blockLog, 1, 1) });

		this.addRecipe(new ItemStack(TreeOres.coalSpawner),
				new Object[] { "III", "ISI", "III", 'I', new ItemStack(Blocks.coal_block), 'S', new ItemStack(TreeOres.blockLog, 1, 2) });

		this.addRecipe(new ItemStack(TreeOres.redstoneSpawner), new Object[] { "III", "ISI", "III", 'I', new ItemStack(Blocks.redstone_block), 'S',
				new ItemStack(TreeOres.blockLog, 1, 3) });

		this.addRecipe(new ItemStack(TreeOres.diamondSpawner), new Object[] { "III", "ISI", "III", 'I', new ItemStack(Blocks.diamond_block), 'S',
				new ItemStack(TreeOres.blockLog2, 1, 0) });

		this.addRecipe(new ItemStack(TreeOres.emeraldSpawner), new Object[] { "III", "ISI", "III", 'I', new ItemStack(Blocks.emerald_block), 'S',
				new ItemStack(TreeOres.blockLog2, 1, 1) });

		this.addRecipe(new ItemStack(TreeOres.lapisSpawner), new Object[] { "III", "ISI", "III", 'I', new ItemStack(Blocks.lapis_block), 'S',
				new ItemStack(TreeOres.blockLog2, 1, 3) });

		this.addRecipe(new ItemStack(TreeOres.quartzSpawner), new Object[] { "III", "ISI", "III", 'I', new ItemStack(Blocks.quartz_block), 'S',
				new ItemStack(TreeOres.blockLog2, 1, 2) });

		this.addRecipe(new ItemStack(TreeOres.glowstoneSpawner), new Object[] { "III", "ISI", "III", 'I', new ItemStack(Blocks.glowstone), 'S',
				new ItemStack(TreeOres.blockLog3, 1, 0) });

		this.addRecipe(new ItemStack(TreeOres.obsidianSpawner), new Object[] { "III", "ISI", "III", 'I', new ItemStack(Blocks.obsidian), 'S',
				new ItemStack(TreeOres.blockLog3, 1, 1) });

		this.addRecipe(new ItemStack(TreeOres.xpSpawner),
				new Object[] { "III", "ISI", "III", 'I', new ItemStack(Items.diamond_sword), 'S', new ItemStack(TreeOres.blockLog3, 1, 2) });

		this.addRecipe(new ItemStack(TreeOres.pumpkinSpawner),
				new Object[] { "III", "ISI", "III", 'I', new ItemStack(Blocks.pumpkin), 'S', new ItemStack(TreeOres.blockLog3, 1, 3) });

		Collections.sort(this.recipes, new TreeStationRecipeSorter(this));
	}

	public TreeStationShapedRecipes addRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;

		if (par2ArrayOfObj[i] instanceof String[]) {
			String[] astring = (String[]) ((String[]) par2ArrayOfObj[i++]);

			for (int l = 0; l < astring.length; ++l) {
				String s1 = astring[l];
				++k;
				j = s1.length();
				s = s + s1;
			}
		} else {
			while (par2ArrayOfObj[i] instanceof String) {
				String s2 = (String) par2ArrayOfObj[i++];
				++k;
				j = s2.length();
				s = s + s2;
			}
		}

		HashMap hashmap;

		for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2) {
			Character character = (Character) par2ArrayOfObj[i];
			ItemStack itemstack1 = null;

			if (par2ArrayOfObj[i + 1] instanceof Item) {
				itemstack1 = new ItemStack((Item) par2ArrayOfObj[i + 1]);
			} else if (par2ArrayOfObj[i + 1] instanceof Block) {
				itemstack1 = new ItemStack((Block) par2ArrayOfObj[i + 1], 1, 32767);
			} else if (par2ArrayOfObj[i + 1] instanceof ItemStack) {
				itemstack1 = (ItemStack) par2ArrayOfObj[i + 1];
			}

			hashmap.put(character, itemstack1);
		}

		ItemStack[] aitemstack = new ItemStack[j * k];

		for (int i1 = 0; i1 < j * k; ++i1) {
			char c0 = s.charAt(i1);

			if (hashmap.containsKey(Character.valueOf(c0))) {
				aitemstack[i1] = ((ItemStack) hashmap.get(Character.valueOf(c0))).copy();
			} else {
				aitemstack[i1] = null;
			}
		}

		TreeStationShapedRecipes shapedrecipes = new TreeStationShapedRecipes(j, k, aitemstack, par1ItemStack);
		this.recipes.add(shapedrecipes);
		return shapedrecipes;
	}

	public void addShapelessRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {
		ArrayList arraylist = new ArrayList();
		Object[] aobject = par2ArrayOfObj;
		int i = par2ArrayOfObj.length;

		for (int j = 0; j < i; ++j) {
			Object object1 = aobject[j];

			if (object1 instanceof ItemStack) {
				arraylist.add(((ItemStack) object1).copy());
			} else if (object1 instanceof Item) {
				arraylist.add(new ItemStack((Item) object1));
			} else {
				if (!(object1 instanceof Block)) {
					throw new RuntimeException("Invalid shapeless recipe!");
				}

				arraylist.add(new ItemStack((Block) object1));
			}
		}

		this.recipes.add(new TreeStationShapelessRecipes(par1ItemStack, arraylist));
	}

	public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World) {
		int i = 0;
		ItemStack itemstack = null;
		ItemStack itemstack1 = null;
		int j;

		for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j) {
			ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);

			if (itemstack2 != null) {
				if (i == 0) {
					itemstack = itemstack2;
				}

				if (i == 1) {
					itemstack1 = itemstack2;
				}

				++i;
			}
		}

		if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable()) {
			Item item = itemstack.getItem();
			int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
			int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
			int l = j1 + k + item.getMaxDamage() * 5 / 100;
			int i1 = item.getMaxDamage() - l;

			if (i1 < 0) {
				i1 = 0;
			}

			return new ItemStack(itemstack.getItem(), 1, i1);
		} else {
			for (j = 0; j < this.recipes.size(); ++j) {
				IRecipe irecipe = (IRecipe) this.recipes.get(j);

				if (irecipe.matches(par1InventoryCrafting, par2World)) {
					return irecipe.getCraftingResult(par1InventoryCrafting);
				}
			}

			return null;
		}
	}

	/**
	 * returns the List<> of all recipes
	 */
	public List getRecipeList() {
		return this.recipes;
	}
}