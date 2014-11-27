package com.lessoner.oretrees.event;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.lessoner.oretrees.TreeOres;
import com.lessoner.oretrees.updatecheck.CheckUpdates;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class UpdateEvent {
	
	private String _downloadUrl = "http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/2242983-treeores-mod-4-5-available-someone-said-thaumcraft/";

	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent e) {
		String str = "Do download it as fast as you can";
		
		if (CheckUpdates.newversion) {
			e.player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "{" + "TreeOres Mod" + "}").appendText(EnumChatFormatting.WHITE + " A new freaking version is on!"));
			IChatComponent localIChatComponent;

			localIChatComponent = IChatComponent.Serializer.func_150699_a("[{\"text\":\"" + str + "\",\"color\":\"aqua\"}," + "{\"text\":\" " + EnumChatFormatting.WHITE + "[" + EnumChatFormatting.GREEN + "Forum Link" + EnumChatFormatting.WHITE + "]\"," + "\"color\":\"green\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":" + "{\"text\":\"Click this to go to forum thread\",\"color\":\"yellow\"}}," + "\"clickEvent\":{\"action\":\"open_url\",\"value\":\"" + this._downloadUrl  + "\"}}]");
			e.player.addChatMessage(localIChatComponent);
		}
	}

}
