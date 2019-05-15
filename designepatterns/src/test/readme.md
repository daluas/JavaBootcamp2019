1 create a repository with the application
2 rewrite the classes and adapt them in java
3 apart of this create Battle class where you can deploy
the Army/units in battle and attach a Observer on this
class to notify the CommandCenter the winning army .


 example of the composite pattern usage find below

        $main_army = new Army();
        $main_army->addUnit(new Archer());
        $main_army->addUnit(new LaserCannonUnit());
        $sub_army = new Army();
        $sub_army->addUnit(new Archer());

        $under_army = new Army();
        $under_army->addUnit(new Archer());

        $joined_army = UnitScript::joinExisting($main_army, $sub_army);

        $join_second_army = UnitScript::joinExisting($joined_army, $under_army);

        echo   "Boombard Strength: ".$join_second_army->bombardStrength();

        Battle battle = new Battle();

        Observer commandCenter = new CommandCenter();
        battle.register(commandCenter);
        commandCenter.setSubject(battle);

        battle.addArmies(army1, army2);

