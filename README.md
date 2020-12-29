# SimpleSearsLib

## Setup

Add the JitPack repository:
```
repositories {
	maven {
		name = "JitPack"
		url = "https://jitpack.io"
	}
}
```

Add `modImplementation include("com.github.KydZombie:SimpleShears-API:1.0.2")` to the end of your dependencies. Replace `1.0.2` with whatever the latest version is.


## How to Use

This library comes with the ShearsBase class built in. You can create a shears item like this:
`public static final ShearsBase CUSTOM_SHEARS = new ShearsBase(400);`
By default, the shears will be in the tools itemgroup by default, but you can add a second argument with a different group, like this:
`public static final ShearsBase CUSTOM_SHEARS = new ShearsBase(400, ItemGroup.COMBAT);`

After creating your shears, add `shears.json` to `resources/data/c/tags/items`, and insert this:
```
{
  "replace": false,
  "values": [
    "minecraft:shears"
  ]
}
```
Replace `"minecraft:shears"` with your modded item(or multiple).
