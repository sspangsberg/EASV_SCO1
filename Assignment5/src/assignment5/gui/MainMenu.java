package assignment5.gui;

/**
 *
 * @author smsj
 */
public class MainMenu extends Menu
{

    public MainMenu()
    {
        super("Main menu", "Menu Item #1", "Menu Item #2", "Menu Item #3");
    }

    @Override
    protected void doAction(int option)
    {
        switch(option)
        {
            case 1:
                System.out.println("You chose Menu Item #1");
                break;
            case 2:
                System.out.println("You chose Menu Item #2");
                break;
            case 3:
                System.out.println("You chose Menu Item #3");
                break;
            case 0:
                System.out.println("Exit to press 0");
                break;

            default:
                System.out.println("This should not happen");
                break;
        }
    }
}