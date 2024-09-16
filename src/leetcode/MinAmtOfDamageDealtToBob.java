package leetcode;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/minimum-amount-of-damage-dealt-to-bob/description/
//damage[]=[1,2,3,4] health[]=[4,5,6,8] power=4 damageDealt=39
class DamageAndTimeToKill {
    int damage;

    int timeToKill;
}

class DamageAndTimeToKillComaparator implements Comparator<DamageAndTimeToKill> {

    @Override
    public int compare(DamageAndTimeToKill o1, DamageAndTimeToKill o2) {
        double damagePerTimeToKill1 = (double) o1.damage / o1.timeToKill;
        double damagePerTimeToKill2 = (double) o2.damage / o2.timeToKill;
        return Double.compare(damagePerTimeToKill2, damagePerTimeToKill1);
    }
}

class MinAmtOfDamageDealtToBob {


    public static long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;
        int[] timeToKill = new int[n];
        DamageAndTimeToKill[] dtka = new DamageAndTimeToKill[n];
        long maxDamage=0;
        for (int i = 0; i < n; i++) {
            maxDamage+=damage[i];
            timeToKill[i] = (int)Math.ceil((double) health[i] / power);
            DamageAndTimeToKill dtk=new DamageAndTimeToKill();
            //we need to kill those enemies first those can damage more but will take less time to kill
            dtk.damage = damage[i];
            dtk.timeToKill = timeToKill[i];
            dtka[i]=dtk;
        }
        Arrays.sort(dtka,new DamageAndTimeToKillComaparator());
        long totalDamageDealt=0;
        for (int i=0;i<n;i++){
            totalDamageDealt+=dtka[i].timeToKill*maxDamage;
            maxDamage-=dtka[i].damage;
        }
        return totalDamageDealt;
    }
}