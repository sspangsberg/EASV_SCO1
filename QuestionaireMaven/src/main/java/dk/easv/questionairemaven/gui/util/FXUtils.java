package dk.easv.questionairemaven.gui.util;

// Java imports
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import java.util.ArrayList;
import java.util.List;

public class FXUtils {

    /**
     *
     * @param root
     * @return
     */
    public static List<RadioButton> getAllRadioButtons(Parent root) {
        List<RadioButton> radioButtons = new ArrayList<>();
        traverse(root, radioButtons);
        return radioButtons;
    }

    /**
     *
     * @param node
     * @param list
     */
    private static void traverse(Node node, List<RadioButton> list) {
        if (node instanceof RadioButton) {
            list.add((RadioButton) node);
        }
        if (node instanceof Parent) {
            for (Node child : ((Parent) node).getChildrenUnmodifiable()) {
                traverse(child, list);
            }
        }
    }
}
