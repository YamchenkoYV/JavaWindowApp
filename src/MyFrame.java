import javax.swing.*;
import java.awt.*;

/**
 * Created by Юрий on 05.09.2016.
 */
public class MyFrame extends JFrame {
    private FirstForm firstForm;
    private FIOForm fioForm;

    public MyFrame(){
//        firstForm = new FirstForm();
//        fioForm = new FIOForm();

        setContentPane(firstForm);

        setMinimumSize(new Dimension(400, 250));

        setLocationRelativeTo(null);//отцентрировать окно
    }

    public void setNextForm(){
        if(getContentPane() == firstForm){
            setContentPane(fioForm);
        }else{
            setContentPane(firstForm);
        }
    }
}
