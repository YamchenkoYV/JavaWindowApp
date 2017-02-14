import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.StringContent;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Юрий on 03.09.2016.
 */
public class FIOForm extends JFrame{
    private JPanel rootPanel;
    private JFrame jFrame;
    private JFormattedTextField fioField;
    private int fioFieldMaxLength = 30;
    private JButton acceptButton;
    private JProgressBar fioLoadProgressBar;

    public FIOForm(){
        jFrame = this;

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFirstForm();
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyTyped(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER && (e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0){
                    setFirstForm();
                }
            }
        });

        fioField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(fioField.getText().length() > fioFieldMaxLength) {
                    fioField.setText(fioField.getText().substring(0, fioFieldMaxLength));
                }
                fioLoadProgressBar.setValue((int)((100.0 * fioField.getText().length() ) / fioFieldMaxLength));
            }
        });
    }

    private void setFirstForm(){
        FirstForm form = new FirstForm(jFrame);
        String fio[] = fioField.getText().split(" +");
        if(fio.length == 3) {
            form.setLastNameFieldText(fio[0]);
            form.setFirstNameFieldText(fio[1]);
            form.setSecondNameFieldText(fio[2]);
        }
        jFrame.setMinimumSize(new Dimension(400,250));
        jFrame.setSize(400,250);
        jFrame.setContentPane(form);
        jFrame.revalidate();//внести изменения в древо
        jFrame.repaint();//перерисовать
    }

    public void setFioFieldText(String fioField) {
        this.fioField.setText(fioField);
    }

    public void setFioLoadProgressBarVal(int value) {
        this.fioLoadProgressBar.setValue(value);
    }

    public int getFioFieldMaxLength() {
        return fioFieldMaxLength;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //rootPanel = this.getContentPane();
    }
}
