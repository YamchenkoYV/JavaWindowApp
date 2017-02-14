import javax.swing.*;
import javax.swing.text.html.Option;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by Юрий on 03.09.2016.
 */
public class FirstForm extends JPanel{
    private JPanel rootPanel;
    private JFrame jFrame;
    private JTextField lastNameField;
    private JTextField secondNameField;
    private JTextField firstNameField;
    private JTextField birthDateField;
    private JTextField countryField;
    private JButton acceptButton;


    public FirstForm(JFrame frame) {
        jFrame = frame;
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(rootPanel, "Не заполнено поле Имя или Фамилия","",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(secondNameField.getText().isEmpty()) {
                    int option = JOptionPane.showConfirmDialog(
                            rootPanel,
                            "Вы уверены, что не хотите заполнять поле Отчество?",
                            "Warning",
                            JOptionPane.YES_NO_OPTION
                    );
                    if(option == JOptionPane.YES_OPTION)
                        setFioForm();
                    else
                        secondNameField.requestFocus();
                        return; 
                }

                setFioForm();
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyTyped(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER && (e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0){
                    setFioForm();
                }
            }
        });
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
        rootPanel = this;
    }

    private void setFioForm(){
        FIOForm form = new FIOForm(jFrame);
        String strToInsert = lastNameField.getText()  + " " + firstNameField.getText() + " " + secondNameField.getText();
        form.setFioFieldText(strToInsert);
        form.setFioLoadProgressBarVal((int)((100.0 * strToInsert.length() ) / form.getFioFieldMaxLength()));
        jFrame.setMinimumSize(new Dimension(600,200));
        jFrame.setSize(600,120);
        jFrame.setContentPane(form);
        jFrame.revalidate();//внести изменения в древо
        jFrame.repaint();//перерисовать
    }

    public void setFirstNameFieldText(String firstNameField) {
        this.firstNameField.setText(firstNameField);
    }

    public void setLastNameFieldText(String lastNameField) {
        this.lastNameField.setText(lastNameField);
    }

    public void setSecondNameFieldText(String secondNameField) {
        this.secondNameField.setText(secondNameField);
    }
}
