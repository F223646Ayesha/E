import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class PoemTable {
    String[][] data; // Array for table data
    int rowCount = 0; // Number of rows in the file

    public PoemTable() {
        JFrame frame = new JFrame("Poem Table");
        JLabel label = new JLabel("Misra Table");
        frame.getContentPane().add(label, BorderLayout.PAGE_START);
        frame.setSize(400, 300);

        // Process the file and populate the data array
        processFile("Poem.txt");

        // Define column headers
        String[] columns = {"Title", "Misra1", "Misra2"};
        JTable table = new JTable(data, columns);
        JScrollPane jscrollpane = new JScrollPane(table);
        frame.getContentPane().add(jscrollpane, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a button to change color
        JButton colorChanger = new JButton("Color Changer");
        frame.getContentPane().add(colorChanger, BorderLayout.PAGE_END);
        colorChanger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.GREEN);
            }
        });

        frame.setVisible(true);
    }

    private void processFile(String fileName) {
        // First, count the rows to determine the size of the data array
        countRows(fileName);

        // Initialize the data array based on rowCount
        data = new String[rowCount][3];

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean ignoreLines = false;
            String currentTitle = null;
            int currentRow = -1;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.equals("_________")) {
                    ignoreLines = true;
                    continue;
                }
                if (line.equals("==========")) {
                    ignoreLines = false;
                    continue;
                }
                if (ignoreLines) continue;

                if (line.startsWith("[") && line.endsWith("]")) {
                    currentRow++;
                    currentTitle = line.substring(1, line.length() - 1);
                    data[currentRow][0] = currentTitle; // Store the title
                }

                if (line.startsWith("(") && line.endsWith(")")) {
                    String verse = line.substring(1, line.length() - 1);
                    String[] misras = verse.split("\\.\\.\\.");
                    if (misras.length == 2) {
                        data[currentRow][1] = misras[0];
                        data[currentRow][2] = misras[1];
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void countRows(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean ignoreLines = false;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.equals("_________")) {
                    ignoreLines = true;
                    continue;
                }
                if (line.equals("==========")) {
                    ignoreLines = false;
                    continue;
                }
                if (ignoreLines) continue;

                if (line.startsWith("[") && line.endsWith("]")) {
                    rowCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class JTable_File_Read {
    public static void main(String[] args) {
        new PoemTable();
    }
}
