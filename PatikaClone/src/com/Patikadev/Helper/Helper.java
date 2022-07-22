package com.Patikadev.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static int centerOfWindow(String axis, Dimension dim){
        return switch (axis) {
            case "x" -> (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - dim.getWidth()) / 2);
            case "y" -> (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - dim.getHeight()) / 2);
            default -> 0;
        };
    }
    public static boolean isFieldEmpty(JTextField field){
        return field.getText().trim().isEmpty();
    }
    public static void showMessage(String msg){
        OptionPaneTR();
        String message;
        String title;
        switch (msg){
            case "fill":
                message = "Lütfen boş alanları doldurunuz!";
                title = "Hata!";
                break;
            case "done":
                message = "İşlem başarılı!";
                title = "Sonuç";
                break;
            case "error":
                message = "İşlem başarısız.";
                title = "Hata";
                break;
            default:
                message = msg;
                title = "Mesaj";
                break;
        }
        JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE);
    }
    public static void OptionPaneTR(){
        UIManager.put("OptionPane.okButton","Tamam");
    }
    public static void clearAllFields(JTextField... fields){
        for (JTextField field : fields) {
            field.setText(null);
        }
    }
}
