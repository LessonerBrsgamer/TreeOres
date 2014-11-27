package com.lessoner.oretrees.updatecheck;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

import com.lessoner.oretrees.TreeOres;
import com.lessoner.oretrees.entity.EntityIronBoss;

public class CheckUpdates {
	
	public static boolean newversion;
	public static float versionnew = (float) (Float.parseFloat(TreeOres.VERSION) + 0.5);
	
	public static void checkUpdate() throws IOException {
		final URL url = new URL("https://dl.dropboxusercontent.com/u/79165610/TreeOresMod-1.7.10-" + String.valueOf(versionnew) + ".jar");
		HttpURLConnection huc = (HttpURLConnection) url.openConnection();
		int responseCode = huc.getResponseCode();

		if (responseCode == 200) {
			newversion = true;
		} else {

		}
	}

}
