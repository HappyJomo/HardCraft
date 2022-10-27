package me.zeal.hardcraft.challenges;

public enum Challenges {

    NO_PLACE_BLOCKS(new NoPlaceBlocksChallenge()),
    NO_BREAK_BLOCKS(new NoPlaceBlocksChallenge());

    public static final Challenges[] VALUES = values();

    private Challenge challenge;

    Challenges(Challenge challenge) {

    }


}