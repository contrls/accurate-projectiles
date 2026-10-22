# Accurate Projectiles (Fabric 1.21.1)

A small server-side Fabric mod for Minecraft 1.21.1. It removes the random launch uncertainty from **player-owned** ender pearls, wind charges, and thrown potions. It does not add collision features, change Multishot, alter any other projectile, or change non-random launch behavior.

## Compatibility

- Minecraft Java Edition 1.21.1
- Java 21
- Fabric Loader 0.16.x
- Fabric API for Minecraft 1.21.1
- Yarn named mappings `1.21.1+build.3`

## Important behavior notes

- Only launch uncertainty is set to zero for player-owned ender pearls, wind charges, and thrown potions.
- Vanilla launch speed, gravity, drag, collisions, item behavior, and player momentum contribution are intended to remain unchanged.
- Arrows, snowballs, tridents, and all other projectile types are untouched.
- Dispenser-fired and mob-fired projectiles are not changed.
- Install on the server for multiplayer. A client-only install on a multiplayer server does not change the server's real trajectories. In singleplayer, the integrated server runs inside the client, so the mod in the client `mods` folder applies.

## Build

Install a 64-bit Java 21 JDK. From this project folder run:

```bash
gradle build
```

The release/remapped JAR should be at `build/libs/accurate-projectiles-1.0.0.jar`. The `-sources.jar` is not the installable mod.

## Install

Put `accurate-projectiles-1.0.0.jar` in the relevant instance's `mods` folder. Fabric Loader and Fabric API for Minecraft 1.21.1 must also be installed.

## Manual test plan

1. Stand still and throw 20 ender pearls at the same wall point; compare repeated impacts with vanilla.
2. Repeat with player-thrown wind charges.
3. Repeat with thrown potions.
4. Throw arrows and snowballs; verify their launch spread is still vanilla.
5. Test a dispenser and a breeze mob; their launch behavior should remain vanilla.
6. Verify gravity, drag, launch speed, and the effect of moving while throwing are unchanged.

## Verification status

This project has not been built or launched in Minecraft in the environment where it was prepared. Run the build and in-game tests before treating it as verified.
