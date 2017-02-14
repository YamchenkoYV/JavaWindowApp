
import javax.swing.*;
import java.awt.*;

/**
 * Created by Юрий on 01.08.2016.
 */
public class Loader {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setContentPane(new FirstForm(frame));

        frame.setMinimumSize(new Dimension(400,250));

        frame.setLocationRelativeTo(null);//отцентрировать окно

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("My Windows Application");
        frame.setVisible(true);
    }
}
