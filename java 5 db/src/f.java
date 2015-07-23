import javax.swing.*;
import java.awt.*;

/**
 * Created by cassandra on 15/7/20.
 */
public class f extends JFrame {

    JButton button = new JButton("Start");
    JLabel label = new JLabel("abc");

    public f() {
        this.setLayout(null);
        button.setBounds(5, 5, 80, 40);
        label.setBounds(90,5,200,40);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEtchedBorder());
        this.add(label);
        this.add(button);
        this.setSize(400, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
