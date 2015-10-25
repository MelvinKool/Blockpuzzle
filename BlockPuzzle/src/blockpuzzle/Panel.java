/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockpuzzle;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author kjeld
 */
public class Panel extends JPanel{
    public Panel(Color color){
        setBackground(color);
        setVisible(true);
    }
}
