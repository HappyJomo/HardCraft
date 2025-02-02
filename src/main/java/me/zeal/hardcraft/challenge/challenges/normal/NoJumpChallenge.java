package me.zeal.hardcraft.challenge.challenges.normal;

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
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, getDuration() * 20, 128, false, false));
        super.startChallenge(player);
    }

    @Override
    public Challenges getEnum() {
        return Challenges.NO_JUMP;
    }

    @Override
    public int getDuration() {
        return 90;
    }
}
