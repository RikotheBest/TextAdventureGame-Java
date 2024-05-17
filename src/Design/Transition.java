package Design;

public class Transition {
    UI ui;
    public Transition(UI ui){
        this.ui = ui;

    }
    public void showTitleScreen(){
        ui.titlePanel.setVisible(true);
        ui.startPanel.setVisible(true);

        ui.mainPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);

    }
    public void showGameScreen(){


        ui.titlePanel.setVisible(false);
        ui.startPanel.setVisible(false);

        ui.mainPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }
}
