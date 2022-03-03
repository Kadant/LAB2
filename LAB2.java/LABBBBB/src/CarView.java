import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class CarView extends JFrame{
    private static final int X = 800;
    private static final int Y = 800;

    static DrawPanel drawPanel = new DrawPanel(X, Y-240);

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton addRandomCarButton = new JButton("Add Car");
    JButton removeRandomCarButton = new JButton("Remove Car");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarView(String framename){
       initComponents(framename);
    }

    private void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        addSpinnerModule();
        drawStartButton();
        drawStopButton();
        drawGasButton();
        drawAddButton();
        drawRemoveButton();
        drawControlPanel();

        this.pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void drawAddButton() {
        addRandomCarButton.setBackground(Color.GRAY);
        addRandomCarButton.setForeground(Color.BLUE);
        addRandomCarButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(addRandomCarButton);
    }

    private void drawRemoveButton() {
        removeRandomCarButton.setBackground(Color.darkGray);
        removeRandomCarButton.setForeground(Color.LIGHT_GRAY);
        removeRandomCarButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(removeRandomCarButton);
    }

    private void drawStartButton() {
        startButton.setBackground(Color.green);
        startButton.setForeground(Color.black);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(startButton);
    }

    private void drawStopButton() {
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(stopButton);
    }

    private void drawGasButton() {
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);
    }

    private void drawControlPanel(){
        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(removeRandomCarButton, 6);
        controlPanel.add(addRandomCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.PINK);
    }

    private void addSpinnerModule() {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0,
                        0,
                        100,
                        1);
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });
    }
}