package io.github.kydzombie.simpleshears;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class SimpleShears implements ModInitializer {

	public static final Tag<Item> SHEARS_TAG = TagRegistry.item(new Identifier("c", "shears"));

	@Override
	public void onInitialize() {
	}
}
