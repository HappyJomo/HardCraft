package me.zeal.hardcraft.challenge.challenges;

import me.zeal.hardcraft.challenge.Challenge;
import me.zeal.hardcraft.challenge.Challenges;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NoJumpChallenge extends Challenge {

    @Override
    public void startChallenge(Player player) {
        if (!isThisChallengeActive(player)) {
            return;
        }
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, getDuration() * 20, 9999, true));
    }

    @Override
    public Challenges getEnum() {
        return Challenges.NO_JUMP;
    }

    @Override
    public int getDuration() {
        return 40;
    }
}
