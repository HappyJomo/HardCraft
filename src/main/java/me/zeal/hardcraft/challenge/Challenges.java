package me.zeal.hardcraft.challenge;

import me.zeal.hardcraft.challenge.challenges.extreme.LaunchChallenge;
import me.zeal.hardcraft.challenge.challenges.extreme.SuperGravityChallenge;
import me.zeal.hardcraft.challenge.challenges.hard.EndermanChallenge;
import me.zeal.hardcraft.challenge.challenges.easy.TeleportationChallenge;
import me.zeal.hardcraft.challenge.challenges.easy.MoonGravityChallenge;
import me.zeal.hardcraft.challenge.challenges.hard.FreezeChallenge;
import me.zeal.hardcraft.challenge.challenges.normal.NoInventoryChallenge;
import me.zeal.hardcraft.challenge.challenges.easy.NoPlaceBlocksChallenge;
import me.zeal.hardcraft.challenge.challenges.hard.ShuffleInventoryChallenge;
import me.zeal.hardcraft.challenge.challenges.normal.SlowedDownChallenge;
import me.zeal.hardcraft.challenge.challenges.normal.NoJumpChallenge;
import org.apache.commons.lang.WordUtils;

public enum Challenges {

    NO_BREAK_BLOCKS(new NoPlaceBlocksChallenge(), "No Breaking Blocks!", Difficulty.EASY),
    NO_INVENTORY(new NoInventoryChallenge(), "No Inventory!", Difficulty.NORMAL),
    NO_PLACE_BLOCKS(new NoPlaceBlocksChallenge(), "No Placing Blocks!", Difficulty.EASY),
    NO_JUMP(new NoJumpChallenge(), "No Jumping!", Difficulty.NORMAL),
    SHUFFLE_INVENTORY(new ShuffleInventoryChallenge(), "Inventory Shuffle!", Difficulty.HARD),
    SLOWED_DOWN(new SlowedDownChallenge(), "Slowed Down!", Difficulty.NORMAL),
    TELEPORTATION(new TeleportationChallenge(), "Teleported!", Difficulty.EASY),
    ENDERMAN(new EndermanChallenge(), "Prepare to be an enderman!", Difficulty.HARD),
    LAUNCH(new LaunchChallenge(), "You got a water bucket?", Difficulty.EXTREME),
    SUPER_GRAVITY(new SuperGravityChallenge(), "Super gravity!", Difficulty.EXTREME),
    MOON_GRAVITY(new MoonGravityChallenge(), "Moon gravity!", Difficulty.EASY),
    FROZEN(new FreezeChallenge(), "Frozen!", Difficulty.HARD);

    public static final Challenges[] VALUES = values();
    private static final int NUM_OF_CHALLENGES = VALUES.length;

    private final Challenge challenge;
    private String name;
    private Difficulty difficulty;

    public enum Difficulty {
        EASY,
        NORMAL,
        HARD,
        EXTREME;
    }

    Challenges(Challenge challenge) {
        this.challenge = challenge;
    }

    Challenges(Challenge challenge, String name, Difficulty difficulty) {
        this.challenge = challenge;
        this.name = name;
        this.difficulty = difficulty;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    @Override
    public String toString() {
        if (name == null) {
            name = name().toLowerCase();
            name = name.replaceAll("_", " ");
            name = WordUtils.capitalizeFully(name) + "!";
        }

        return name;
    }

    public static int getNumOfChallenges() {
        return NUM_OF_CHALLENGES;
    }
}