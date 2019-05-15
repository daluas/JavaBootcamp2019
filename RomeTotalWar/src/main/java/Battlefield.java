public class Battlefield {

    public static void main(String[] args) {
        Unit JuliiArchers = new Archer();
        Unit JuliiLightInfantry = new LightInfantry();
        Unit JuliiPikemen = new Pikemen();
        Unit JuliiHeavyInfantry = new HeavyInfantry();
        Unit JuliiArmy = new Army("Julii");

        JuliiArmy.add(JuliiArchers);
        JuliiArmy.add(JuliiLightInfantry);
        JuliiArmy.add(JuliiPikemen);
        JuliiArmy.add(JuliiHeavyInfantry);
        Unit BrutiiArmy = new Army("Brutii");
        Unit BrutiiCavalry = new Cavalry();
        Unit BrutiiSkirmishers = new Skirmisher();
        BrutiiArmy.add((BrutiiCavalry));
        BrutiiArmy.add((BrutiiSkirmishers));
        Unit RomanArmy = Army.JoinForces(JuliiArmy,BrutiiArmy, "Roman");


        Unit GaulFrontArchers = new Archer();
        Unit GaulRightArchers = new Archer();
        Unit GaulPikemen = new Pikemen();
        Unit GaulSkirmishCavaltry = new Cavalry();
        Unit GaulBarnarianCavalry = new Cavalry();
        Unit GaulSkirmishers = new Skirmisher();
        Unit GaulAxemen = new HeavyInfantry();
        Unit GaulArmy = new Army("Gaul");


        GaulArmy.add(GaulFrontArchers);
        GaulArmy.add(GaulRightArchers);
        GaulArmy.add(GaulPikemen);
        GaulArmy.add(GaulSkirmishCavaltry);
        GaulArmy.add(GaulBarnarianCavalry);
        GaulArmy.add(GaulSkirmishers);
        GaulArmy.add(GaulAxemen);

        System.out.println(GaulArmy.getDefensePower());
        System.out.println(GaulArmy.getOffensePower());
        System.out.println(RomanArmy.getOffensePower());
        System.out.println(RomanArmy.getDefensePower());

        Subject battleOfAlesia = new Battle("Battle of Alesia");
        Observer SPQR = new CommandCenter();
        SPQR.setSubject(battleOfAlesia);
        battleOfAlesia.register(SPQR);
        SPQR.update();
        ((Battle) battleOfAlesia).postBattleReport(RomanArmy,GaulArmy);
    }
}
