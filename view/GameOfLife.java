package life.view;

import life.model.GameModel;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

public class GameOfLife extends JFrame implements GameView {
    private final JLabel genLabel = new JLabel();
    private final JLabel aliveLabel = new JLabel();
    private JPanel fieldPanel;

    public GameOfLife() {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(525, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        genLabel.setName("GenerationLabel");
        genLabel.setBounds(20, 10, 100, 20);
        genLabel.setText("Generation #0"); // required to pass tests
        add(genLabel);

        aliveLabel.setName("AliveLabel");
        aliveLabel.setBounds(20, 30, 100, 20);
        aliveLabel.setText("Alive: 0"); // required to pass tests
        add(aliveLabel);
    }

    @Override
    public void update(GameModel model) {
        genLabel.setText("Generation #" + model.getGen());
        aliveLabel.setText("Alive: " + model.getAliveCount());

        var field = model.getField();

        if (fieldPanel == null) {
            fieldPanel = new JPanel();
            fieldPanel.setBounds(5, 50, 500, 500);
            fieldPanel.setLayout(new GridLayout(field.length, field[0].length));
            for (boolean[] row : field) {
                for (boolean cell : row) {
                    var jCell = new JPanel();
                    jCell.setBackground(cell ? Color.GRAY : Color.WHITE);
                    jCell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    fieldPanel.add(jCell);
                }
            }
            add(fieldPanel);
            setVisible(true);
        } else {
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    fieldPanel.getComponent(i * field[i].length + j).setBackground(field[i][j] ? Color.GRAY : Color.WHITE);
                }
            }
        }
    }
}
