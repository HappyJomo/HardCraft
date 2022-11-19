package me.zeal.hardcraft.challenge;

import me.zeal.hardcraft.challenge.challenges.NoJumpChallenge;
import me.zeal.hardcraft.challenge.challenges.NoPlaceBlocksChallenge;
import me.zeal.hardcraft.challenge.challenges.ShuffleInventoryChallenge;
import me.zeal.hardcraft.challenge.challenges.SlowedDownChallenge;

public enum Challenges {

    NO_BREAK_BLOCKS(new NoPlaceBlocksChallenge()),
    NO_PLACE_BLOCKS(new NoPlaceBlocksChallenge()),
    NO_JUMP(new NoJumpChallenge()),
    SHUFFLE_INVENTORY(new ShuffleInventoryChallenge()),
    SLOWED_DOWN(new SlowedDownChallenge());

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