package Design;

import Units.Player;
import Units.Troll;
import Units.Unit;

public class Game {
    Player player = new Player();
    UI ui = new UI();
    Transition transition = new Transition(ui);
    Troll troll = new Troll();
    Choice choice = new Choice(transition, ui,this, player, troll);












    Game(){
        ui.startGame(choice, player);
        transition.showTitleScreen();
    }





    public static void main(String[] args){
        new Game();

    }




}