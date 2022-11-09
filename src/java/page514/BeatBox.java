package page514;

public class BeatBox {

    public static void main(String[] args)
    {
        new BeatBox().buildGUI();
    }

    private void buildGUI()
    {
        MainFrame frame = new MainFrame();
        BackgroundPanel background = new BackgroundPanel();
        frame.getContentPane().add(background);
        
        frame.go();
    }
}
