package me.zeal.hardcraft.challenge;

import me.zeal.hardcraft.challenge.challenges.extreme.LaunchChallenge;
import me.zeal.hardcraft.challenge.challenges.extreme.SuperGravityChallenge;
import me.zeal.hardcraft.challenge.challenges.hard.EndermanChallenge;
import me.zeal.hardcraft.challenge.challenges.hard.TeleportationChallenge;
import me.zeal.hardcraft.challenge.challenges.easy.MoonGravityChallenge;
import me.zeal.hardcraft.challenge.challenges.normal.NoInventoryChallenge;
import me.zeal.hardcraft.challenge.challenges.easy.NoPlaceBlocksChallenge;
import me.zeal.hardcraft.challenge.challenges.normal.ShuffleInventoryChallenge;
import me.zeal.hardcraft.challenge.challenges.normal.SlowedDownChallenge;
import me.zeal.hardcraft.challenge.challenges.normal.NoJumpChallenge;
import org.apache.commons.lang.WordUtils;

public enum Challenges {

    NO_BREAK_BLOCKS(new NoPlaceBlocksChallenge(), "No Breaking Blocks!"),
    NO_INVENTORY(new NoInventoryChallenge(), "No Inventory!"),
    NO_PLACE_BLOCKS(new NoPlaceBlocksChallenge(), "No Placing Blocks!"),
    NO_JUMP(new NoJumpChallenge(), "No Jumping!"),
    SHUFFLE_INVENTORY(new ShuffleInventoryChallenge(), "Inventory Shuffle!"),
    SLOWED_DOWN(new SlowedDownChallenge(), "Slowed Down!"),
    TELEPORTATION(new TeleportationChallenge(), "Teleported!"),
    ENDERMAN(new EndermanChallenge(), "Prepare to be an enderman!"),
    LAUNCH(new LaunchChallenge(), "You got a water bucket?"),
    SUPER_GRAVITY(new SuperGravityChallenge(), "Super gravity!"),
    MOON_GRAVITY(new MoonGravityChallenge(), "Moon gravity!");

    public static final Challenges[] VALUES = values();
    private static final int NUM_OF_CHALLENGES = VALUES.length;

    private final Challenge challenge;

    Challenges(Challenge challenge) {
        this.challenge = challenge;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public static int getNumOfChallenges() {
        return NUM_OF_CHALLENGES;
    }
}