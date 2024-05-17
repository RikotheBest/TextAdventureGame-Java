package Design;

import Units.Player;
import Units.Troll;
import Weapons.GryffindorSword;
import Weapons.MagicWand;
import Weapons.NoWeapon;
import Weapons.Weapon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Choice implements ActionListener {
    Transition transition;
    Game game;
    UI ui;
    String nextPosS, nextPosN, nextPosW, nextPosE, nextPosI;
    Player player;
    Troll troll;


    public Choice(Transition transition, UI ui, Game game, Player player, Troll troll) {
        this.player = player;
        this.transition = transition;
        this.ui = ui;
        this.game = game;
        this.troll = troll;
    }


    public void actionPerformed(ActionEvent event) {

        String yourChoice = event.getActionCommand();

        switch (yourChoice) {
            case "start":
                transition.showGameScreen();
                dumbledoreRoom();
                break;
            case "N":
                selectPosition(nextPosN);
                break;
            case "S":
                selectPosition(nextPosS);
                break;
            case "E":
                selectPosition(nextPosE);
                break;
            case "W":
                selectPosition(nextPosW);
                break;
            case "I":
                selectPosition(nextPosI);
                break;
        }

    }

    public void selectPosition(String nextPos) {
        switch (nextPos) {
            case "dumbledoreRoom":
                dumbledoreRoom();
                break;
            case "talkToDumbleD":
                talkToDumbleD();
                break;
            case "firePlace":
                firePlace();
                break;
            case "forbiddenForest":
                forbiddenForest();
                break;
            case "troll":
                troll();
                break;
            case "ranAtTroll":
                ranAtTroll();
                break;
            case "titleScreen":setDefault();transition.showTitleScreen();
                break;
            case "fight": fight();
                break;
            case "win": win();
                break;
            case "lose": lose();
                break;
            case "river": river();
                break;
            case "regen": regen();
                break;
            case "Sword": Sword();
                break;
            case "Voldemort": Voldemort();
                break;
            case "voldeTalk": voldeTalk();
                break;
            case "lastFight": lastFight();
                break;
            case "lastDecision": lastDecision();
                break;



        }
    }

    public void setDefault(){
        player.setHp(10);
        ui.hpLabel.setText("HP: " + player.getHp());
        player.setWeapon(new NoWeapon());
        ui.weaponLabel.setText("Weapon: " + player.weapon.getName());
        ui.choice1.setText("North");
        ui.choice2.setText("South");
        ui.choice3.setText("West");
        ui.choice4.setText("East");
        ui.choice5.setText("Interact");

    }

    public void dumbledoreRoom() {
        ui.mainText.setText("You're in Dumbledore's room.\nHe is sitting right in front of you, behind his desk.\nHe looks like has something to say.\nTo your right is a fireplace.");
        nextPosI = "talkToDumbleD";
        nextPosE = "firePlace";
        nextPosW = "";
        nextPosS = "";
        nextPosN = "";
    }

    public void talkToDumbleD() {
        ui.mainText.setText("You will need this on your journey!\nRemember, happiness can be found, even in the darkest of times,\nif one only remembers to turn on the light!");
        player.setWeapon(new MagicWand());
        ui.weaponLabel.setText("Weapon: " + player.weapon.getName());
        nextPosE = "firePlace";
        nextPosW = "";
        nextPosS = "";
        nextPosN = "";
        nextPosI = "";
    }

    public void firePlace() {
        ui.mainText.setText("You're standing in front of a fireplace.\nIt doesn't seem to be an ordinary one...");
        nextPosI = "forbiddenForest";
        nextPosW = "dumbledoreRoom";
        nextPosS = "";
        nextPosN = "";
        nextPosE = "";

    }

    public void forbiddenForest() {
        ui.mainText.setText("SWOOSH! You found yourself in the middle of the forbidden forest.\nYou should look around to find a way back.");
        nextPosW = "troll";
        nextPosE = "troll";
        nextPosS = "troll";
        nextPosN = "troll";
        nextPosI = "";

    }

    public void troll() {
        ui.mainText.setText("Oh no! you woke up the dungeon troll! (HP: " + troll.getHp() + ")\nYou can either run away or attack him before he attacks you first");
        nextPosE = "river";
        nextPosS = "river";
        nextPosW = "river";
        nextPosN = "ranAtTroll";
        nextPosI = "fight";

    }

    public void ranAtTroll() {
        ui.mainText.setText("You charged at the troll and he killed you...\nDamage received: " + (-player.getHp()));
        player.setHp(0);
        ui.hpLabel.setText("HP: " + player.getHp());
        nextPosE = "";
        nextPosS = "";
        nextPosW = "";
        nextPosN = "";
        nextPosI = "titleScreen";


        ui.choice1.setText("");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        ui.choice5.setText("Quit");

    }

    public void fight(){
        troll.setHp(troll.getHp()-player.weapon.getDamage());
        player.setHp(player.getHp() - troll.weapon.getDamage());
        ui.hpLabel.setText("HP: " + player.getHp());
        ui.mainText.setText("You attacked the troll! Damage given: " + player.weapon.getDamage() + "\nTroll(HP: " + troll.getHp() + ") attacked you too, Damage received: " + (-troll.weapon.getDamage()));
        if(troll.hp > player.weapon.getDamage()){
            nextPosE = "river";
            nextPosS = "river";
            nextPosW = "river";
            nextPosN = "ranAtTroll";
            nextPosI = "fight";

        } else if(troll.hp <= player.weapon.getDamage()){
            nextPosE = "river";
            nextPosS = "river";
            nextPosW = "river";
            nextPosN = "ranAtTroll";
            nextPosI = "win";

        }  if(player.getHp() <= troll.weapon.getDamage()) {
            nextPosE = "river";
            nextPosS = "river";
            nextPosW = "river";
            nextPosN = "ranAtTroll";
            nextPosI = "lose";

        }

    }
    public void win(){
        ui.mainText.setText("You defeated the troll!\nYou can finally continue your journey");
        nextPosE = "river";
        nextPosS = "river";
        nextPosW = "river";
        nextPosN = "river";
        nextPosI = "";
    }
    public void lose(){
        ui.mainText.setText("The troll managed to kill you :(\nGame Over!");
        player.setHp(0);
        ui.hpLabel.setText("HP: " + player.getHp());

        nextPosE = "";
        nextPosS = "";
        nextPosW = "";
        nextPosN = "";
        nextPosI = "titleScreen";


        ui.choice1.setText("");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        ui.choice5.setText("Quit");

    }
    public void river(){
        ui.mainText.setText("You found a river! But it doesn't seem to be an ordinary one...\nWait, have i seen this one before?\nAnyway you know what to do");

        nextPosE = "";
        nextPosS = "";
        nextPosW = "";
        nextPosN = "";
        nextPosI = "regen";
    }
    public void regen(){
        ui.mainText.setText("You drank from the magical river and restored your HP\n HP received: " + (10 - player.getHp()) + "\nYou noticed something shining deep in the river while drinking,\nmay be time for some bath?");
        player.setHp(10);
        ui.hpLabel.setText("HP: " + player.getHp());

        nextPosE = "";
        nextPosS = "";
        nextPosW = "";
        nextPosN = "";
        nextPosI = "Sword";

    }
    public void Sword(){
        ui.mainText.setText("You dove in and found some sword...It's the sword of Gryffindor!\nI think it's time to get out of these creepy woods");
        player.setWeapon(new GryffindorSword());
        ui.weaponLabel.setText("Weapon: " + player.weapon.getName());

        nextPosE = "Voldemort";
        nextPosS = "Voldemort";
        nextPosW = "Voldemort";
        nextPosN = "Voldemort";
        nextPosI = "";
    }
    public void Voldemort(){
        ui.mainText.setText("You were just leaving the woods but some dark silhouette appeared\nto stop you...");
        nextPosE = "voldeTalk";
        nextPosS = "voldeTalk";
        nextPosW = "voldeTalk";
        nextPosN = "voldeTalk";
        nextPosI = "voldeTalk";
    }
    public void voldeTalk(){
        ui.mainText.setText("Voldemort: Finally, the boy who lived, has come to die!");
        nextPosE = "lastDecision";
        nextPosS = "lastDecision";
        nextPosW = "lastDecision";
        nextPosN = "lastDecision";
        nextPosI = "lastDecision";
    }
    public void lastDecision(){
        ui.mainText.setText("Oh no, its lord Voldemort!\nYou can either face him or run from him forever\nWhat are you gonna do?");
        nextPosE = "";
        nextPosS = "";
        nextPosW = "";
        nextPosN = "";
        nextPosI = "lastFight";

        ui.choice1.setText("");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
    }
    public void lastFight(){
        ui.mainText.setText("You stabbed him with your sword and he faded away..\nCongratulations!");
        nextPosE = "";
        nextPosS = "";
        nextPosW = "";
        nextPosN = "";
        nextPosI = "titleScreen";

        ui.choice1.setText("");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        ui.choice5.setText("Quit");

    }





}



