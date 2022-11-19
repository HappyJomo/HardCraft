package me.zeal.hardcraft.challenge.challenges;

import me.zeal.hardcraft.challenge.Challenge;
import me.zeal.hardcraft.challenge.Challenges;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SlowedDownChallenge extends Challenge {

    @Override
    public void startChallenge(Player player) {
        if (!isThisChallengeActive(player)) {
            return;
        }
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, getDuration() * 20, 3));
    }

    @Override
    public Challenges getEnum() {
        return Challenges.SLOWED_DOWN;
    }

    @Override
    public int getDuration() {
        return 40;
    }
}