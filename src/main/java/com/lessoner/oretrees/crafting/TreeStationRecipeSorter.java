package com.lessoner.oretrees.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class TreeStationRecipeSorter implements Comparator {

	final TreeStationCraftingManager treestation;

	public TreeStationRecipeSorter(
			TreeStationCraftingManager treeStationCraftingManager) {
		this.treestation = treeStationCraftingManager;
	}

	public int compareRecipes(IRecipe ire1, IRecipe ire2) {
		return ire1 instanceof TreeStationShapelessRecipes
				&& ire2 instanceof TreeStationShapedRecipes ? 1
				: (ire2 instanceof TreeStationShapelessRecipes
						&& ire1 instanceof TreeStationShapedRecipes ? -1
						: (ire2.getRecipeSize() < ire1.getRecipeSize() ? -1
								: (ire2.getRecipeSize() > ire1.getRecipeSize() ? 1
										: 0)));
	}

	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}

}
