import javax.swing.*;
import java.awt.event.*;
import java.awt.Image;
import javax.imageio.ImageIO;

public class AnimalChooserApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pet Chooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JRadioButton dogButton = new JRadioButton("Dog", true);
        JRadioButton catButton = new JRadioButton("Cat");
        JRadioButton rabbitButton = new JRadioButton("Rabbit");
        JRadioButton birdButton = new JRadioButton("Bird");
        JRadioButton hamsterButton = new JRadioButton("Hamster");

        ButtonGroup petGroup = new ButtonGroup();
        petGroup.add(dogButton);
        petGroup.add(catButton);
        petGroup.add(rabbitButton);
        petGroup.add(birdButton);
        petGroup.add(hamsterButton);

        dogButton.setBounds(20, 20, 120, 30);
        catButton.setBounds(20, 50, 120, 30);
        rabbitButton.setBounds(20, 80, 120, 30);
        birdButton.setBounds(20, 110, 120, 30);
        hamsterButton.setBounds(20, 140, 120, 30);

        JButton displayButton = new JButton("Show Pet");
        displayButton.setBounds(150, 80, 120, 30);

        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(150, 120, 200, 150);
        updateImage(imageLabel, "/animalchooserapp/images/dog.jpg"); 

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedPet = "";

                if (dogButton.isSelected()) {
                    selectedPet = "Dog";
                    updateImage(imageLabel, "/animalchooserapp/images/dog.jpg");
                } else if (catButton.isSelected()) {
                    selectedPet = "Cat";
                    updateImage(imageLabel, "/animalchooserapp/images/cat.jpg");
                } else if (rabbitButton.isSelected()) {
                    selectedPet = "Rabbit";
                    updateImage(imageLabel, "/animalchooserapp/images/rabbit.jpg");
                } else if (birdButton.isSelected()) {
                    selectedPet = "Bird";
                    updateImage(imageLabel, "/animalchooserapp/images/bird.jpg");
                } else if (hamsterButton.isSelected()) {
                    selectedPet = "Hamster";
                    updateImage(imageLabel, "/animalchooserapp/images/hamster.jpg");
                }

                JOptionPane.showMessageDialog(frame, "You selected: " + selectedPet);
            }
        });

        frame.add(dogButton);
        frame.add(catButton);
        frame.add(rabbitButton);
        frame.add(birdButton);
        frame.add(hamsterButton);
        frame.add(displayButton);
        frame.add(imageLabel);

        frame.setVisible(true);
    }

    private static void updateImage(JLabel label, String imagePath) {
        try {
            Image image = ImageIO.read(AnimalChooserApp.class.getResource(imagePath));
            if (image != null) {
                ImageIcon icon = new ImageIcon(image.getScaledInstance(200, 150, Image.SCALE_SMOOTH));
                label.setIcon(icon); 
                label.revalidate(); 
                label.repaint();   
            }
        } catch (Exception ex) {
            label.setIcon(null);
            ex.printStackTrace();
        }
    }
}
