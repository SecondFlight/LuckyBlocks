package io.github.secondflight.LuckyBlocks;

import java.awt.Color;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

// secondflight.github.io/cheatystick and secondflight.github.io/luckyblocks :)

public class LuckyBlocks extends JavaPlugin implements Listener {
	
	public final Logger logger = Logger.getLogger("Minecraft");
	public static LuckyBlocks plugin;
	
	//prints text to console when disabled
		@Override
		public void onDisable() {
			PluginDescriptionFile pdfFile = this.getDescription();
			this.logger.info(pdfFile.getName() + " has been disabled.");
		
		}
		
		//prints text to console when enabled
		@Override
		public void onEnable() {
			PluginDescriptionFile pdfFile = this.getDescription();
			this.logger.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " has been enabled.");
			getServer().getPluginManager().registerEvents(this, this);
		
			saveConfig();
}
/**
		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
		{
			Player player = (Player) sender;
			
			
			
			//for debugging, seems to be broken :(
			if(commandLabel.equalsIgnoreCase("test")) {
				potionItems(player.getLocation(), player);
				player.sendMessage("hello");
			}
			return false;
		}
**/
	@EventHandler
	public void breakListener(BlockBreakEvent event) {
		
		if (event.getBlock() != null && event.getBlock().getState().getType() == Material.SPONGE) {
			Player p = event.getPlayer();
			
			event.setCancelled(true);
			
			event.getPlayer().getWorld().getBlockAt(event.getBlock().getLocation()).setType(Material.AIR);
			
			int howManyPossibleHappenstances = 50;
			
			int randomChoice = 1 + (int)(Math.random() * howManyPossibleHappenstances);
			
			Location l = event.getBlock().getState().getLocation();
			
			switch (randomChoice) {
			//
			//  Items
			//
				case 1: luckyTools(1, l, p);  break;
				case 2: luckyTools(2, l, p);  break;
				case 3: luckyTools(3, l, p);  break;
				case 4: luckyTools(4, l, p);  break;
				case 5: luckyTools(5, l, p);  break;
				case 6: luckyTools(6, l, p);  break;
				case 7:
				case 8:
				case 9:
				case 10: materials(l, p); break;
				case 11:
				case 12: woodTools(l, p); break;
				case 13:
				case 14: stoneTools(l, p); break; 
				case 15:
				case 16: goldTools(l, p); break; 
				case 17:
				case 18: leatherArmor(l, p); break;
				case 19:
				case 20: goldArmor(l, p); break;
				case 21: chainArmor(l, p); break;
				case 22:
				case 23: ironTools(l, p); break;
				case 24: diamondTools(l, p); break;
				case 25:
				case 26: ironArmor(l, p); break;
				case 27:
				case 28: diamondArmor(l, p); break;
				case 29:
				case 30:
				case 31: horseArmor(l, p); break;
				case 32:
				case 33:
				case 34: bowAndArrows(l, p); break;
				case 35:
				case 36: 
				case 38: booksAndBookshelves(l, p); break;
				case 39:
				case 40:
				case 41: vegetables(l, p); break;
				case 42:
				case 43:
				case 44: meats(l, p); break;
				case 45:
				case 46:
				case 47: potionItems(l, p); break;
				case 48:
				case 49:
				case 50: brewingItems(l, p); break;
				case 51:
				case 52:
				case 53:
				case 54:
				case 55:
				case 56:
				case 57: potionItems(l, p); break;	
				
				
					
				//
				//  Materials
				//
			}
			//note: you can put any method below here
			//if you want to test it; if you put it
			//below, it will be fired every time a
			//sponge block is broken.
			//example:
			//
			//potionItems(l, p);
		}
	}
	public static int randomNumber(int lower, int upper) {
		return lower + (int)(Math.random() * ((upper - lower) + 1));
	}
	
	public static boolean randomBoolean() {
		return Math.random() < 0.5;
	}
	
	public void luckyTools(int i, Location l, Player p) {
		//TODO: add lucky armor
		
		World world = p.getWorld();
		
		ItemStack bow = (new ItemStack(Material.BOW));
		{
			ItemMeta meta = bow.getItemMeta();
			meta.addEnchant(Enchantment.DURABILITY, 3, true);
			meta.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
			meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
			meta.addEnchant(Enchantment.ARROW_FIRE, 1, false);
			meta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
			
			meta.setDisplayName(ChatColor.GOLD + "Lucky Bow");
			
			bow.setItemMeta(meta);
			
			
		}
		
		ItemStack sword = (new ItemStack(Material.GOLD_SWORD));
		{
			ItemMeta meta = bow.getItemMeta();
			meta.addEnchant(Enchantment.DURABILITY, 3, true);
			meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
			meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
			meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
			meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 1, true);
			
			meta.setDisplayName(ChatColor.GOLD + "Lucky Sword");
			
			sword.setItemMeta(meta);
		}
		
		ItemStack axe = (new ItemStack(Material.GOLD_AXE));
		{
			ItemMeta meta = bow.getItemMeta();
			meta.addEnchant(Enchantment.DURABILITY, 3, true);
			meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
			meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
			meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
			meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 1, true);
			meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
			meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
			
			meta.setDisplayName(ChatColor.GOLD + "Lucky Axe");
			
			axe.setItemMeta(meta);
		}
		
		ItemStack pickaxe = (new ItemStack(Material.GOLD_PICKAXE));
		{
			ItemMeta meta = bow.getItemMeta();
			meta.addEnchant(Enchantment.DURABILITY, 3, true);
			meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
			meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
			
			meta.setDisplayName(ChatColor.GOLD + "Lucky Pickaxe");
			
			pickaxe.setItemMeta(meta);
		}
		
		ItemStack fishingRod = (new ItemStack(Material.FISHING_ROD));
		{
			ItemMeta meta = bow.getItemMeta();
			meta.addEnchant(Enchantment.DURABILITY, 3, true);
			meta.addEnchant(Enchantment.LUCK, 3, true);
			meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
			
			meta.setDisplayName(ChatColor.GOLD + "Lucky Fishing Rod");
			
			fishingRod.setItemMeta(meta);
		}
		
		ItemStack shovel = (new ItemStack(Material.GOLD_SPADE));
		{
			ItemMeta meta = bow.getItemMeta();
			meta.addEnchant(Enchantment.DURABILITY, 3, true);
			meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
			meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
			meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
			meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
			
			meta.setDisplayName(ChatColor.GOLD + "Lucky Shovel");
			
			shovel.setItemMeta(meta);
		}
		
		switch (i) {
			case 1: world.dropItemNaturally(l, bow); break;
			case 2: world.dropItemNaturally(l, sword); break;
			case 3: world.dropItemNaturally(l, axe); break;
			case 4: world.dropItemNaturally(l, pickaxe); break;
			case 5: world.dropItemNaturally(l, fishingRod); break;
			case 6: world.dropItemNaturally(l, shovel); break;
		}
	}
	
	public void materials(Location l, Player p) {
		//TODO: add fireworks, items should be emeralds, diamonds, gold, iron
		
		World world = p.getWorld();
		
		int diamondDropRate = 10;
		int diamondRand = 0 + (int)(Math.random() * diamondDropRate);
		
		for (int i = 0; i < diamondRand; ++i) {
			int howManyPossibleHappenstances = 10;
		
			//float xRand = -5 + (float)(Math.random() * howManyPossibleHappenstances);
			//float zRand = -5 + (float)(Math.random() * howManyPossibleHappenstances);
			
			world.dropItemNaturally(l, new ItemStack(Material.DIAMOND));
		}
		
		int goldDropRate = 20;
		int goldRand = 5 + (int)(Math.random() * goldDropRate);
		
		for (int i = 0; i < goldRand; ++i) {
			int howManyPossibleHappenstances = 10;
		
			//float xRand = -5 + (float)(Math.random() * howManyPossibleHappenstances);
			//float zRand = -5 + (float)(Math.random() * howManyPossibleHappenstances);
			
			world.dropItemNaturally(l, new ItemStack(Material.GOLD_INGOT));
		}
		
		int redstoneDropRate = 45;
		int redstoneRand = 20 + (int)(Math.random() * redstoneDropRate);
		
		for (int i = 0; i < redstoneRand; ++i) {
			int howManyPossibleHappenstances = 10;
		
			//float xRand = -5 + (float)(Math.random() * howManyPossibleHappenstances);
			//float zRand = -5 + (float)(Math.random() * howManyPossibleHappenstances);
			
			world.dropItemNaturally(l, new ItemStack(Material.REDSTONE));
		}
		
		int lapisDropRate = 5;
		int lapisRand = 1 + (int)(Math.random() * lapisDropRate);
		
		for (int i = 0; i < lapisRand; ++i) {
			int howManyPossibleHappenstances = 10;
		
			//float xRand = -5 + (float)(Math.random() * howManyPossibleHappenstances);
			//float zRand = -5 + (float)(Math.random() * howManyPossibleHappenstances);
			
			world.dropItemNaturally(l, new ItemStack(Material.LAPIS_BLOCK));
		}
		
		int coalDropRate = 32;
		int coalRand = 32 + (int)(Math.random() * coalDropRate);
		
		for (int i = 0; i < coalRand; ++i) {
			int howManyPossibleHappenstances = 10;
		
			//float xRand = -5 + (float)(Math.random() * howManyPossibleHappenstances);
			//float zRand = -5 + (float)(Math.random() * howManyPossibleHappenstances);
			
			world.dropItemNaturally(l, new ItemStack(Material.COAL));
		}
	}

	public void woodTools(Location l, Player p) {
		World w = p.getWorld();
		
		w.dropItemNaturally(l, new ItemStack(Material.WOOD_SWORD));
		w.dropItemNaturally(l, new ItemStack(Material.WOOD_PICKAXE));
		w.dropItemNaturally(l, new ItemStack(Material.WOOD_SPADE));
		w.dropItemNaturally(l, new ItemStack(Material.WOOD_HOE));
		w.dropItemNaturally(l, new ItemStack(Material.WOOD_AXE));
	}
	
	public void stoneTools(Location l, Player p) {
		World w = p.getWorld();
		
		w.dropItemNaturally(l, new ItemStack(Material.STONE_SWORD));
		w.dropItemNaturally(l, new ItemStack(Material.STONE_PICKAXE));
		w.dropItemNaturally(l, new ItemStack(Material.STONE_SPADE));
		w.dropItemNaturally(l, new ItemStack(Material.STONE_HOE));
		w.dropItemNaturally(l, new ItemStack(Material.STONE_AXE));
	}
	
	public void goldTools(Location l, Player p) {
		World w = p.getWorld();
		
		w.dropItemNaturally(l, new ItemStack(Material.GOLD_SWORD));
		w.dropItemNaturally(l, new ItemStack(Material.GOLD_PICKAXE));
		w.dropItemNaturally(l, new ItemStack(Material.GOLD_SPADE));
		w.dropItemNaturally(l, new ItemStack(Material.GOLD_HOE));
		w.dropItemNaturally(l, new ItemStack(Material.GOLD_AXE));
	}

	public void leatherArmor(Location l, Player p) {
		World w = p.getWorld();
		
		w.dropItemNaturally(l, new ItemStack(Material.LEATHER_BOOTS));
		w.dropItemNaturally(l, new ItemStack(Material.LEATHER_LEGGINGS));
		w.dropItemNaturally(l, new ItemStack(Material.LEATHER_CHESTPLATE));
		w.dropItemNaturally(l, new ItemStack(Material.LEATHER_HELMET));
	}
	
	public void goldArmor(Location l, Player p) {
		World w = p.getWorld();
		
		w.dropItemNaturally(l, new ItemStack(Material.GOLD_BOOTS));
		w.dropItemNaturally(l, new ItemStack(Material.GOLD_LEGGINGS));
		w.dropItemNaturally(l, new ItemStack(Material.GOLD_CHESTPLATE));
		w.dropItemNaturally(l, new ItemStack(Material.GOLD_HELMET));
	}

	public void ironTools(Location l, Player p) {
		World w = p.getWorld();
		
		List<ItemStack> list = new ArrayList();
		
		list.add(new ItemStack(Material.IRON_AXE));
		list.add(new ItemStack(Material.IRON_HOE));
		list.add(new ItemStack(Material.IRON_SWORD));
		list.add(new ItemStack(Material.IRON_PICKAXE));
		list.add(new ItemStack(Material.IRON_SPADE));
		
		Collections.shuffle(list);
		
		//int rand = (lowest number here) + (int)(Math.random() * (((highest number here) - (lowest number here)) + 1));
		
		int rand = 2 + (int)(Math.random() * ((3 - 2) + 1));
		
		for (int i = 1; i < (1 + rand); ++i) {
			w.dropItemNaturally(l, list.get(i));
		}
	}

	public void chainArmor(Location l, Player p) {
		World w = p.getWorld();
		
		List<ItemStack> list = new ArrayList();
		
		list.add(new ItemStack(Material.CHAINMAIL_BOOTS));
		list.add(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		list.add(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		list.add(new ItemStack(Material.CHAINMAIL_HELMET));
		
		Collections.shuffle(list);
		
		int rand = 2 + (int)(Math.random() * ((3 - 2) + 1));
		
		for (int i = 1; i < (1 + rand); ++i) {
			w.dropItemNaturally(l, list.get(i));
		}
	}

	public void diamondTools(Location l, Player p) {
		World w = p.getWorld();
		
		List<ItemStack> list = new ArrayList();
		
		list.add(new ItemStack(Material.DIAMOND_AXE));
		list.add(new ItemStack(Material.DIAMOND_PICKAXE));
		list.add(new ItemStack(Material.DIAMOND_HOE));
		list.add(new ItemStack(Material.DIAMOND_SPADE));
		list.add(new ItemStack(Material.DIAMOND_SWORD));
		
		Collections.shuffle(list);
		
		int rand = 1 + (int)(Math.random() * ((2 - 1) + 1));
		
		for (int i = 1; i < (1 + rand); ++i) {
			w.dropItemNaturally(l, list.get(i));
		}
	}

	public void ironArmor(Location l, Player p) {
		World w = p.getWorld();
		
		List<ItemStack> list = new ArrayList();
		
		list.add(new ItemStack(Material.IRON_BOOTS));
		list.add(new ItemStack(Material.IRON_LEGGINGS));
		list.add(new ItemStack(Material.IRON_CHESTPLATE));
		list.add(new ItemStack(Material.IRON_HELMET));
		
		Collections.shuffle(list);
		
		int rand = 2 + (int)(Math.random() * ((3 - 2) + 1));
		
		for (int i = 1; i < (1 + rand); ++i) {
			w.dropItemNaturally(l, list.get(i));
		}
	}

	public void diamondArmor(Location l, Player p) {
		World w = p.getWorld();
		
		List<ItemStack> list = new ArrayList();
		
		list.add(new ItemStack(Material.DIAMOND_BOOTS));
		list.add(new ItemStack(Material.DIAMOND_LEGGINGS));
		list.add(new ItemStack(Material.DIAMOND_CHESTPLATE));
		list.add(new ItemStack(Material.DIAMOND_HELMET));
		
		Collections.shuffle(list);
		
		int rand = 1 + (int)(Math.random() * ((2 - 1) + 1));
		
		for (int i = 1; i < (1 + rand); ++i) {
			w.dropItemNaturally(l, list.get(i));
		}
	}

	public void horseArmor(Location l, Player p) {
		World w = p.getWorld();
		
		w.dropItemNaturally(l, new ItemStack(Material.IRON_BARDING));
		w.dropItemNaturally(l, new ItemStack(Material.GOLD_BARDING));
		w.dropItemNaturally(l, new ItemStack(Material.DIAMOND_BARDING));
	}
	
	public void bowAndArrows(Location l, Player p) {
		World w = p.getWorld();
		
		w.dropItemNaturally(l, new ItemStack(Material.BOW));
		
		int rand = 16 + (int)(Math.random() * ((32 - 16) + 1));
		for (int i = 16; i < (1 + rand); ++i) {
			w.dropItemNaturally(l, new ItemStack(Material.ARROW));
		}
	}

	public void booksAndBookshelves(Location l, Player p) {
		World w = p.getWorld();
		
		int rand = 8 + (int)(Math.random() * ((16 - 8) + 1));
		for (int i = 8; i < (1 + rand); ++i) {
			w.dropItemNaturally(l, new ItemStack(Material.BOOK));
		}
		
		int rand2 = 0 + (int)(Math.random() * ((8 - 0) + 1));
		for (int i = 0; i < (1 + rand); ++i) {
			w.dropItemNaturally(l, new ItemStack(Material.BOOKSHELF));
		}
		
	}

	public void vegetables(Location l, Player p) {
		int rand = 8 + (int)(Math.random() * ((16 - 8) + 1));
		for (int i = 8; i < (1 + rand); ++i) {
			World w = p.getWorld();
			
			int howManyPossibleHappenstances = 6;
			
			int randomChoice = 1 + (int)(Math.random() * howManyPossibleHappenstances);
			
			switch (randomChoice) {
				case 1: w.dropItemNaturally(l, new ItemStack(Material.POISONOUS_POTATO)); break;
				case 2: w.dropItemNaturally(l, new ItemStack(Material.POTATO)); break;
				case 3:
				case 4: w.dropItemNaturally(l, new ItemStack(Material.BAKED_POTATO)); break;
				case 5:
				case 6: w.dropItemNaturally(l, new ItemStack(Material.CARROT)); break;
			}
		}
	}

	public void meats(Location l, Player p) {
		World w = p.getWorld();
		
		int rand = 8 + (int)(Math.random() * ((16 - 8) + 1));
		for (int i = 8; i < (1 + rand); ++i) {
			
			int howManyPossibleHappenstances = 16;
			
			int randomChoice = 1 + (int)(Math.random() * howManyPossibleHappenstances);
			
			switch (randomChoice) {
				case 1:
				case 2: w.dropItemNaturally(l, new ItemStack(Material.COOKED_CHICKEN)); break;
				case 3:
				case 4: w.dropItemNaturally(l, new ItemStack(Material.RAW_CHICKEN)); break;
				case 5:
				case 6: w.dropItemNaturally(l, new ItemStack(Material.COOKED_FISH)); break;
				case 7: 
				case 8: w.dropItemNaturally(l, new ItemStack(Material.RAW_FISH)); break;
				case 9:
				case 10: w.dropItemNaturally(l, new ItemStack(Material.COOKED_BEEF)); break;
				case 11:
				case 12: w.dropItemNaturally(l, new ItemStack(Material.RAW_BEEF)); break;
				case 13:
				case 14: w.dropItemNaturally(l, new ItemStack(Material.PORK)); break;
				case 15:
				case 16: w.dropItemNaturally(l, new ItemStack(Material.GRILLED_PORK)); break;
			}
		}
	}
	
	public void potionItems(Location l, Player p) {
		World w = p.getWorld();

		for (int i = 1; i < (randomNumber(4, 8)); ++i) {
			
			
			Potion potion;
			
			switch (randomNumber(1, 12)) {
			case 1: potion = new Potion(PotionType.FIRE_RESISTANCE, randomNumber(1, PotionType.FIRE_RESISTANCE.getMaxLevel())); potion.setSplash(randomBoolean()); potion.setHasExtendedDuration(randomBoolean()); w.dropItemNaturally(l,potion.toItemStack(1)); break;
			case 2: potion = new Potion(PotionType.INSTANT_DAMAGE, randomNumber(1, PotionType.INSTANT_DAMAGE.getMaxLevel()));  potion.setSplash(randomBoolean()); w.dropItemNaturally(l,potion.toItemStack(1)); break;
			case 3: potion = new Potion(PotionType.INSTANT_HEAL, randomNumber(1, PotionType.INSTANT_HEAL.getMaxLevel()));  potion.setSplash(randomBoolean()); w.dropItemNaturally(l,potion.toItemStack(1)); break;
			case 4: potion = new Potion(PotionType.INVISIBILITY, randomNumber(1, PotionType.INVISIBILITY.getMaxLevel()));  potion.setSplash(randomBoolean()); potion.setHasExtendedDuration(randomBoolean()); w.dropItemNaturally(l,potion.toItemStack(1)); break;
			case 5: potion = new Potion(PotionType.NIGHT_VISION, randomNumber(1, PotionType.NIGHT_VISION.getMaxLevel()));  potion.setSplash(randomBoolean()); potion.setHasExtendedDuration(randomBoolean()); w.dropItemNaturally(l,potion.toItemStack(1)); break;
			case 6: potion = new Potion(PotionType.POISON, randomNumber(1, PotionType.POISON.getMaxLevel()));  potion.setSplash(randomBoolean()); potion.setHasExtendedDuration(randomBoolean()); w.dropItemNaturally(l,potion.toItemStack(1)); break;
			case 7: potion = new Potion(PotionType.REGEN, randomNumber(1, PotionType.REGEN.getMaxLevel()));  potion.setSplash(randomBoolean()); potion.setHasExtendedDuration(randomBoolean()); w.dropItemNaturally(l,potion.toItemStack(1)); break;
			case 8: potion = new Potion(PotionType.SLOWNESS, randomNumber(1, PotionType.SLOWNESS.getMaxLevel()));  potion.setSplash(randomBoolean()); potion.setHasExtendedDuration(randomBoolean()); w.dropItemNaturally(l,potion.toItemStack(1)); break;
			case 9: potion = new Potion(PotionType.SPEED, randomNumber(1, PotionType.SPEED.getMaxLevel()));  potion.setSplash(randomBoolean()); potion.setHasExtendedDuration(randomBoolean()); w.dropItemNaturally(l,potion.toItemStack(1)); break;
			case 10: potion = new Potion(PotionType.STRENGTH, randomNumber(1, PotionType.STRENGTH.getMaxLevel()));  potion.setSplash(randomBoolean()); potion.setHasExtendedDuration(randomBoolean()); w.dropItemNaturally(l,potion.toItemStack(1)); break;
			case 11: potion = new Potion(PotionType.WATER_BREATHING, randomNumber(1, PotionType.WATER_BREATHING.getMaxLevel()));  potion.setSplash(randomBoolean()); potion.setHasExtendedDuration(randomBoolean()); w.dropItemNaturally(l,potion.toItemStack(1)); break;
			case 12: potion = new Potion(PotionType.WEAKNESS, randomNumber(1, PotionType.WEAKNESS.getMaxLevel()));  potion.setSplash(randomBoolean()); potion.setHasExtendedDuration(randomBoolean()); w.dropItemNaturally(l,potion.toItemStack(1)); break;
			
			}
			
		}
	}

	public void brewingItems(Location l, Player p) {
		World w = p.getWorld();
		
		int rand = 16 + (int)(Math.random() * ((32 - 16) + 1));
		for (int i = 16; i < (1 + rand); ++i) {
			
			int howManyPossibleHappenstances = 34;
			
			int randomChoice = 1 + (int)(Math.random() * howManyPossibleHappenstances);
			
			switch (randomChoice) {
				case 1: w.dropItemNaturally(l, new ItemStack(Material.ENDER_PEARL)); break;
				case 2: w.dropItemNaturally(l, new ItemStack(Material.GHAST_TEAR)); break;
				case 3:
				case 4:
				case 5: w.dropItemNaturally(l, new ItemStack(Material.NETHER_WARTS)); break;
				case 6: w.dropItemNaturally(l, new ItemStack(Material.EYE_OF_ENDER)); break;
				case 7: 
				case 8: w.dropItemNaturally(l, new ItemStack(Material.SPIDER_EYE)); break;
				case 9: w.dropItemNaturally(l, new ItemStack(Material.FERMENTED_SPIDER_EYE)); break;
				case 10:
				case 11: w.dropItemNaturally(l, new ItemStack(Material.BLAZE_POWDER)); break;
				case 12: w.dropItemNaturally(l, new ItemStack(Material.BLAZE_ROD)); break;
				case 13:
				case 14: w.dropItemNaturally(l, new ItemStack(Material.MAGMA_CREAM)); break;
				case 15:
				case 16:
				case 17:
				case 18: w.dropItemNaturally(l, new ItemStack(Material.REDSTONE)); break;
				case 19:
				case 20:
				case 21:
				case 22: w.dropItemNaturally(l, new ItemStack(Material.GLOWSTONE_DUST)); break;
				case 24:
				case 25:
				case 26: w.dropItemNaturally(l, new ItemStack(Material.SULPHUR)); break;
				case 27:
				case 28: w.dropItemNaturally(l, new ItemStack(Material.GOLDEN_CARROT)); break;
				case 29:
				case 30:
				case 31:
				case 32: w.dropItemNaturally(l, new ItemStack(Material.GOLD_NUGGET)); break;
				case 33:
				case 34: w.dropItemNaturally(l, new ItemStack(Material.SPECKLED_MELON)); break;
			}
		}
	}
}