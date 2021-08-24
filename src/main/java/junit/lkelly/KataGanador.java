package junit.lkelly;

public class KataGanador {

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker){
       int health1 = fighter1.getHealth();
       int health2 = fighter2.getHealth();
       String winner = "";
       String attacker = firstAttacker;
       while((health1 > 0) && (health2 > 0)){
           if(fighter1.getName().equals(attacker)){
               health2 -= fighter1.getDamagePerAttack();
                attacker = fighter2.getName();
           }else{
               health1 -= fighter2.getDamagePerAttack();
               attacker = fighter1.getName();
           }
           if (health1 <= 0){
               winner = fighter2.getName();
           }
           if (health2 <= 0){
               winner = fighter1.getName();
           }
       }
        return winner;
    }
}
