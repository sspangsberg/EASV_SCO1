import greenfoot.*;

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    private String text = "";
    
    /**
     * 
     */
    public ScoreBoard() {
        updateScoreBoard();
    }
    
    
    /**
     * 7) Scoreboard with amount of dragon kills (redundant code)
     */
    public void updateScoreBoard() 
    {
        int fontSize = 18;
        Color color = Color.BLACK;
        
        if (GameManager.isGameRunning()) {
            text = "Score:" + GameManager.getScore() + 
                   "\nTotal Game Time:" + GameManager.getTotalGameTime() + 
                   "\nSpawn Rate:" + GameManager.getSpawnRate() +
                   "\nPlayer Health:" + GameManager.getPlayer().getHealth();
            if (GameManager.getPlayer().getHealth() == 0)
                text += "\nWizard is dead. Game over... :(";
        }
                                  
        GreenfootImage image = new GreenfootImage(text, fontSize, color, new Color(0,0,0,0));
        setImage(image);
    }
    
}
