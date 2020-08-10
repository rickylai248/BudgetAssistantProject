package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.*;
import javax.sound.sampled.*;

import javafx.scene.input.InputMethodTextRun;
import model.Budget;
import model.BudgetList;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

// Budget application
public abstract class MyUI implements ActionListener {
    ArrayList<Budget> budgetLog = new ArrayList<>();
    private static final String Budget_File = "./data/Budget.txt";
    private static final String Music_File = "./data/Chimes.wav";
    private Scanner scanner;
    double value = 0;
    String month = "";
    String value2 = "";
    String value3 = "";
    Budget budget = new Budget(month, value);
    BudgetList budgetList;

    // EFFECTS: runs the budget assistant application
    public MyUI() throws IOException, ClassNotFoundException {
        budgetList = new BudgetList();
        scanner = new Scanner(System.in);
        gui();
        runUI();
        ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(Budget_File)));
        out.writeObject(budgetLog);

        out.close();
    }

    // MODIFIES: this
    // EFFECTS: loads the previous budget from Budget.txt if selected

    // MODIFIES: this
    // EFFECTS: processes user input
    public void runUI() throws IOException, ClassNotFoundException {
        boolean going = true;

        while (going) {
            System.out.println("\nChoose from:");
            System.out.println("\tb -> create new budget");
            System.out.println("\tl -> load previous budget");
            value2 = scanner.next();
            if (value2.equals("l")) {
                ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(Budget_File)));
                ArrayList<Budget> budgetArrayList = (ArrayList<Budget>) in.readObject();
                for (Budget budget1 : budgetArrayList) {
                    System.out.println("Month : " + budget1.getMonth());
                    budget1.overBudget();
                }
            } else {
                value3 = scanner.nextLine();
                System.out.println("Please enter the month.");
                month = scanner.nextLine();
                budget.setMonth(month);

                runUI2();
            }
            going = false;
        }
    }

    //Separated runUI into three parts due to the line checkstyle constraint
    public void runUI2() throws IOException {
        System.out.println("Please enter your monthly budget.");
        value = scanner.nextDouble();

        System.out.println("Your budget for " + month + " is $ " + value);
        budget.setBudget(value);

        System.out.println("Please enter your Living Expenses for " + month + " (e.g. Rent, Insurance).");
        value = scanner.nextDouble();

        System.out.println("Your Living Expenses this month is $ " + value);
        budget.setLivingExpenses(value);

        System.out.println("Please enter your Grocery Expenses for " + month);
        value = scanner.nextDouble();
        System.out.println("Your grocery expense this month is $ " + value);
        budget.setGroceries(value);

        System.out.println("Please enter your Restaurant Expenses for " + month);
        value = scanner.nextDouble();
        System.out.println("Your Living Expense budget this month is $ " + value);
        budget.setRestaurants(value);

        System.out.println("Please enter your Transportation Expenses for " + month);
        value = scanner.nextDouble();
        System.out.println("Your transportation expense this month is $ " + value);
        budget.setTransportation(value);

        runUI3();
    }

    public void runUI3() throws IOException {
        System.out.println("Please enter your Entertainment Expenses for " + month);
        value = scanner.nextDouble();

        System.out.println("Your entertainment expense this month is $ " + value);
        budget.setEntertainment(value);

        System.out.println("Please enter your Additional Expenses for " + month);
        value = scanner.nextDouble();
        System.out.println("Your miscellaneous expense this month is $ " + value);
        budget.setMiscellaneous(value);

        budget.setTotalExpenses();

        budget.setBalance();

        budget.setBalancePercent();

        budget.overBudget();

        budgetList.addBudget(budget);
        budgetLog.add(budget);
    }

    public void gui() {
        JFrame frame = new JFrame();
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        JLabel monthHere = new JLabel("Enter Month Here");
        monthHere.setBounds(10, 25, 160, 30);
        panel.add(monthHere);

        JLabel budgetHere = new JLabel("Enter Budget Here");
        budgetHere.setBounds(10, 50, 160, 30);
        panel.add(budgetHere);

        JLabel livingExpensesHere = new JLabel("Enter Living Expenses Here");
        livingExpensesHere.setBounds(10, 70, 160, 30);
        panel.add(livingExpensesHere);

        JLabel groceryExpensesHere = new JLabel("Enter Grocery Expenses Here");
        groceryExpensesHere.setBounds(10, 90, 160, 30);
        panel.add(groceryExpensesHere);

        JLabel restaurantExpensesHere = new JLabel("Enter Restaurant Expenses Here");
        restaurantExpensesHere.setBounds(10, 110, 160, 30);
        panel.add(restaurantExpensesHere);

        JLabel transportationExpensesHere = new JLabel("Enter Transportation Expenses Here");
        transportationExpensesHere.setBounds(10, 130, 160, 30);
        panel.add(transportationExpensesHere);

        JLabel entertainmentExpensesHere = new JLabel("Enter Entertainment Expenses Here");
        entertainmentExpensesHere.setBounds(10, 150, 160, 30);
        panel.add(entertainmentExpensesHere);

        JLabel additionalExpensesHere = new JLabel("Enter Additional Expenses Here");
        additionalExpensesHere.setBounds(10, 170, 160, 30);
        panel.add(additionalExpensesHere);

        JTextField userText = new JTextField(20);
        userText.setBounds(200, 25, 190, 30);
        panel.add(userText);
        budget.setMonth(userText.toString());

        JTextField userText1 = new JTextField(20);
        userText1.setBounds(200, 45, 190, 30);
        panel.add(userText1);

        JTextField userText2 = new JTextField(20);
        userText2.setBounds(200, 65, 190, 30);
        panel.add(userText2);

        JTextField userText3 = new JTextField(20);
        userText3.setBounds(200, 85, 190, 30);
        panel.add(userText3);

        JTextField userText4 = new JTextField(20);
        userText4.setBounds(200, 105, 190, 30);
        panel.add(userText4);

        JTextField userText5 = new JTextField(20);
        userText5.setBounds(200, 125, 190, 30);
        panel.add(userText5);

        JTextField userText6 = new JTextField(20);
        userText6.setBounds(200, 145, 190, 30);
        panel.add(userText6);

        JTextField userText7 = new JTextField(20);
        userText7.setBounds(200, 165, 190, 30);
        panel.add(userText7);

        JButton button = new JButton(new AbstractAction("Submit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //InputMethodTextRun monthText = null;
                //String month = monthText.getText();
                try {
                    budget.setMonth(userText.getText());
                    AudioInputStream audioInput =
                            AudioSystem.getAudioInputStream(new File(Music_File).getAbsoluteFile());
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.start();
                    clip.loop(3);
                    playSound(Music_File);
                } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                    unsupportedAudioFileException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (LineUnavailableException lineUnavailableException) {
                    lineUnavailableException.printStackTrace();
                }
                //System.out.println("Month Entered :" + month);

            }
        }
        );
        button.setBounds(10, 200, 85, 25);
        panel.add(button);
        button.addActionListener(this);

        /*String monthEntered = userText.getText();
        JLabel monthHere1 = new JLabel("Month: " + monthEntered);
        monthHere1.setBounds(400, 25, 160, 30);
        panel.add(monthHere1);

        JLabel budgetHere1 = new JLabel("Budget: ");
        budgetHere1.setBounds(400, 50, 160, 30);
        panel.add(budgetHere1);

        JLabel livingExpensesHere1 = new JLabel("Living Expenses: ");
        livingExpensesHere1.setBounds(400, 70, 160, 30);
        panel.add(livingExpensesHere1);

        JLabel groceryExpensesHere1 = new JLabel("Grocery Expenses: ");
        groceryExpensesHere1.setBounds(400, 90, 160, 30);
        panel.add(groceryExpensesHere1);

        JLabel restaurantExpensesHere1 = new JLabel("Restaurant Expenses: ");
        restaurantExpensesHere1.setBounds(400, 110, 160, 30);
        panel.add(restaurantExpensesHere1);

        JLabel transportationExpensesHere1 = new JLabel("Transportation Expenses: ");
        transportationExpensesHere1.setBounds(400, 130, 160, 30);
        panel.add(transportationExpensesHere1);

        JLabel entertainmentExpensesHere1 = new JLabel("Entertainment Expenses: ");
        entertainmentExpensesHere1.setBounds(400, 150, 160, 30);
        panel.add(entertainmentExpensesHere1);

        JLabel additionalExpensesHere1 = new JLabel("Additional Expenses: ");
        additionalExpensesHere1.setBounds(400, 170, 160, 30);
        panel.add(additionalExpensesHere1);*/

        frame.setTitle("Budget Assistant");
        frame.setVisible(true);
    }

    public static void playSound(String filepath) throws IOException {
        InputStream music;
        music = new FileInputStream(new File(filepath));
        AudioStream audios = new AudioStream(music);
        AudioPlayer.player.start(audios);
    }

    /*    @Override
    public void actionPerformed(ActionEvent e) {
        //InputMethodTextRun monthText = null;
        //String month = monthText.getText();

        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File(Music_File).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            clip.loop(3);
            playSound(Music_File);
        } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
            unsupportedAudioFileException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (LineUnavailableException lineUnavailableException) {
            lineUnavailableException.printStackTrace();
        }
        //System.out.println("Month Entered :" + month);

    }*/


    /*    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        jan = new Budget("Jan", 145.00);
        feb = new Budget("feb", 256.50);
        march = new Budget("march", 256.50);
        april = new Budget("april", 256.50);
        may = new Budget("may", 256.50);
        june = new Budget("june", 256.50);
        july = new Budget("july", 256.50);
        aug = new Budget("aug", 256.50);
        sept = new Budget("sept", 256.50);
        oct = new Budget("oct", 256.50);
        nov = new Budget("nov", 256.50);
        dec = new Budget("dec", 256.50);
    }

    // MODIFIES: this
    // EFFECTS: loads accounts from ACCOUNTS_FILE, if that file exists;
    // otherwise initializes accounts with default values
    private void loadAccounts() {
        try {
            List<Budget> accounts = DataReader.readBudgets(new File(Budget_File));
            jan = accounts.get(0);
            feb = accounts.get(1);
        } catch (IOException e) {
            init();
        }
    }*/
}
