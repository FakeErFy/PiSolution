import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class PiFinalCompleted {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		JOptionPane.showMessageDialog(null,
				"In this application, you can find:\n1-The position(s) of PI digits.\n2-How many time x number has occurred",
				"Application Information", JOptionPane.INFORMATION_MESSAGE);

		String str = JOptionPane.showInputDialog("Search for a digit from 0-9");

		if (str == null) {
			JOptionPane.showMessageDialog(null, "You cancelled the program :/", "Application cancelled",
					JOptionPane.WARNING_MESSAGE);
		} else {
			if (str.matches("[0-9]")) {

				int intNum = Integer.parseInt(str);

				try {
					File file = new File("piiii.txt");
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					int num;
					int count = 0;
					int position = 1;
					while ((num = br.read()) != -1) {
						if (Character.getNumericValue(num) == intNum) {
							System.out.println(intNum + " occurred in " + position + " digit of PI");
							count++;
						}
						position++;
					}
					JOptionPane.showMessageDialog(null,
							intNum + " was found " + count + " times in " + position + " digits", "Result",
							JOptionPane.INFORMATION_MESSAGE);
					br.close();
					fr.close();
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, str + " not a valid number", "Error, invalid number",
						JOptionPane.ERROR_MESSAGE);
				main(args);
			}
		}

	}
}
