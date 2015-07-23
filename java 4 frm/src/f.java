import javax.swing.*;

/**
 * Created by cassandra on 15/7/20.
 */
public class f extends JFrame {

    JLabel l = new JLabel("a");
    public f()
    {

        l.setHorizontalAlignment(JTextField.CENTER);
        this.add(l);
        this.setSize(100,60);
        this.setLocation(200,200);
        this.setTitle("[f]");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void i()   {
        for(int i=0;i<10000;i++)
        {
            this.l.setText(i + "");

            this.repaint();

            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }



        }

    }
}
