import javax.swing.*;
import java.util.List;

public abstract class Decor extends JFrame{

    public static String inputPane(String s){
        return JOptionPane.showInputDialog(null,s);
    }
    public  static  boolean confirmPane(String message){
        int is = JOptionPane.showConfirmDialog(null,message,"Выберите Да/Нет",
                JOptionPane.YES_NO_OPTION);
        return is == JOptionPane.YES_OPTION;
    }
    public static void messagePane (String message){
        JOptionPane.showMessageDialog(null,message);

    }
  //  public static List<?> list()

}
