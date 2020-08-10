package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.sound.sampled.*;
import javax.swing.table.DefaultTableModel;

import javafx.scene.input.InputMethodTextRun;
import model.Budget;
import model.BudgetList;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

// Budget application
public abstract class MyUI implements ActionListener {
    ArrayList<Budget> budgetLog = new ArrayList<>();
    private static final String Budget_File = "./data/Budget.txt";
    private static final String BudgetGui_File = "./data/BudgetGui.txt";
    private static final String Screenshot_File = "./data/Screenshot.png";
    private static final String Music_File = "./data/Chimes.wav";
    private Scanner scanner;
    double value = 0;
    String month = "";
    String value2 = "";
    String value3 = "";
    Budget budget = new Budget(month, value);
    BudgetList budgetList;
    private JFrame frame;
    private JLabel monthHere1;
    private JPanel panel;
    private JTextField userText;
    private JTextField userText1;
    private JTextField userText2;
    private JTextField userText3;
    private JTextField userText4;
    private JTextField userText5;
    private JTextField userText6;
    private JTextField userText7;
    private JLabel budgetAssistant;
    private JButton save;
    private JButton load;
    String setMonth;
    double setBudget;
    double setLiving;
    double setGrocery;
    double setRest;
    double setTrans;
    double setEntertainment;
    double setMisc;
    JLabel budgetHere1;
    JLabel livingExpensesHere1;
    JLabel groceryExpensesHere1;
    JLabel restaurantExpensesHere1;
    JLabel transportationExpensesHere1;
    JLabel entertainmentExpensesHere1;
    JLabel additionalExpensesHere1;
    JLabel percentage;
    JButton button;

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

    // GUI method, split into multiple methods due to checkstyle line constraint
    public void gui() {
        frame = new JFrame();
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        DefaultListModel<Budget> budgetModel = new DefaultListModel<>();

        JList<Budget> budgetJList = new JList<>(budgetModel);
        budgetJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JLabel monthHere = new JLabel("Enter Month Here");
        monthHere.setBounds(10, 25, 160, 30);
        panel.add(monthHere);

        JLabel budgetHere = new JLabel("Enter Budget Here");
        budgetHere.setBounds(10, 50, 160, 30);
        panel.add(budgetHere);

        JLabel livingExpensesHere = new JLabel("Enter Living Expenses Here");
        livingExpensesHere.setBounds(10, 70, 160, 30);
        panel.add(livingExpensesHere);

        gui2();
    }

    public void gui2() {
        JLabel groceryExpensesHere = new JLabel("Enter Grocery Expenses Here");
        groceryExpensesHere.setBounds(10, 90, 170, 30);
        panel.add(groceryExpensesHere);

        JLabel restaurantExpensesHere = new JLabel("Enter Restaurant Expenses Here");
        restaurantExpensesHere.setBounds(10, 110, 185, 30);
        panel.add(restaurantExpensesHere);

        JLabel transportationExpensesHere = new JLabel("Enter Transportation Expenses Here");
        transportationExpensesHere.setBounds(10, 130, 215, 30);
        panel.add(transportationExpensesHere);

        JLabel entertainmentExpensesHere = new JLabel("Enter Entertainment Expenses Here");
        entertainmentExpensesHere.setBounds(10, 150, 215, 30);
        panel.add(entertainmentExpensesHere);

        JLabel additionalExpensesHere = new JLabel("Enter Additional Expenses Here");
        additionalExpensesHere.setBounds(10, 170, 215, 30);
        panel.add(additionalExpensesHere);

        budgetAssistant = new JLabel("Budget Assistant");
        budgetAssistant.setBounds(10, 180, 1000, 30);
        budgetAssistant.setSize(600, 250);
        budgetAssistant.setFont(new Font("Verdana", Font.BOLD, 45));

        gui3();
    }

    public void gui3() {
        panel.add(budgetAssistant);

        userText = new JTextField(20);
        userText.setBounds(230, 25, 190, 30);
        panel.add(userText);
        setMonth = userText.getText();

        userText1 = new JTextField(20);
        userText1.setBounds(230, 45, 190, 30);
        panel.add(userText1);
        setBudget = parseDouble(userText1.getText());

        userText2 = new JTextField(20);
        userText2.setBounds(230, 65, 190, 30);
        panel.add(userText2);


        userText3 = new JTextField(20);
        userText3.setBounds(230, 85, 190, 30);
        panel.add(userText3);


        userText4 = new JTextField(20);
        userText4.setBounds(230, 105, 190, 30);
        panel.add(userText4);

        gui4();
    }

    public void gui4() {
        userText5 = new JTextField(20);
        userText5.setBounds(230, 125, 190, 30);
        panel.add(userText5);


        userText6 = new JTextField(20);
        userText6.setBounds(230, 145, 190, 30);
        panel.add(userText6);

        userText7 = new JTextField(20);
        userText7.setBounds(230, 165, 190, 30);
        panel.add(userText7);

        monthHere1 = new JLabel("Month Name: ");
        monthHere1.setBounds(430, 25, 450, 30);
        panel.add(monthHere1);

        budgetHere1 = new JLabel("Budget Amount: $");
        budgetHere1.setBounds(430, 50, 450, 30);
        panel.add(budgetHere1);

        livingExpensesHere1 = new JLabel("Living Expenses: $");
        livingExpensesHere1.setBounds(430, 70, 450, 30);
        panel.add(livingExpensesHere1);

        gui5();
    }

    public void gui5() {
        groceryExpensesHere1 = new JLabel("Grocery Expenses: $");
        groceryExpensesHere1.setBounds(430, 90, 450, 30);
        panel.add(groceryExpensesHere1);

        restaurantExpensesHere1 = new JLabel("Restaurant Expenses: $");
        restaurantExpensesHere1.setBounds(430, 110, 450, 30);
        panel.add(restaurantExpensesHere1);

        transportationExpensesHere1 = new JLabel("Transportation Expenses: $");
        transportationExpensesHere1.setBounds(430, 130, 450, 30);
        panel.add(transportationExpensesHere1);

        entertainmentExpensesHere1 = new JLabel("Entertainment Expenses: $");
        entertainmentExpensesHere1.setBounds(430, 150, 450, 30);
        panel.add(entertainmentExpensesHere1);

        additionalExpensesHere1 = new JLabel("Additional Expenses: $");
        additionalExpensesHere1.setBounds(430, 170, 450, 30);
        panel.add(additionalExpensesHere1);

        percentage = new JLabel("Percent Spent: %");
        percentage.setBounds(430, 190, 200, 30);
        panel.add(percentage);

        gui6();
    }

    public void gui6() {
        button = new JButton(new AbstractAction("Submit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBudget = parseDouble(userText1.getText());
                setLiving = parseDouble(userText2.getText());
                setGrocery = parseDouble(userText3.getText());
                setRest = parseDouble(userText4.getText());
                setTrans = parseDouble(userText5.getText());
                setEntertainment = parseDouble(userText6.getText());
                setMisc = parseDouble(userText7.getText());
                try {
                    gui65();
                } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                    unsupportedAudioFileException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (LineUnavailableException lineUnavailableException) {
                    lineUnavailableException.printStackTrace();
                }
            }
        }
        );
        gui7();
    }

    public void gui65() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        budget.setMonth(setMonth);
        monthHere1.setText("Month Name: " + userText.getText());
        budget.setBudget(setBudget);
        budgetHere1.setText("Budget Amount: $" + setBudget);
        budget.setLivingExpenses(setLiving);
        livingExpensesHere1.setText("Living Expenses: $" + setLiving);
        budget.setGroceries(setGrocery);
        groceryExpensesHere1.setText("Grocery Expenses: $" + setGrocery);
        budget.setRestaurants(setRest);
        restaurantExpensesHere1.setText("Restaurant Expenses: $" + setRest);
        budget.setTransportation(setTrans);
        transportationExpensesHere1.setText("Transportation Expenses: $" + setTrans);
        budget.setEntertainment(setEntertainment);
        entertainmentExpensesHere1.setText("Entertainment Expenses: $" + setEntertainment);
        budget.setMiscellaneous(setMisc);
        additionalExpensesHere1.setText("Additional Expenses: $" + setMisc);
        budget.setTotalExpenses();
        gui66();
    }

    public void gui66() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        budget.setBalance();
        budget.getBalance();
        budget.setBalancePercent();
        budget.getBalancePercent();
        percentage.setText("Percentage Spent: " + budget.getBalancePercent() + "%");
        AudioInputStream audioInput =
                AudioSystem.getAudioInputStream(new File(Music_File).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInput);
        clip.start();
        clip.loop(3);
        playSound(Music_File);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    public void gui7() {
        button.setBounds(10, 200, 85, 25);
        panel.add(button);
        button.addActionListener(this);
        save = new JButton(new AbstractAction("Save") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setMonth = userText.getText();
                    setBudget = parseDouble(userText1.getText());
                    gui77();
                    FileOutputStream outFile = new FileOutputStream(BudgetGui_File);
                    ObjectOutputStream outObject = new ObjectOutputStream(outFile);
                    budgetLog.add(budget);
                    outObject.writeObject(budgetLog);
                    outObject.close();
                    saveImg();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
        );
        gui8();
    }

    public void saveImg() throws IOException {
        BufferedImage img = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        frame.paint(img.getGraphics());
        File outputFile = new File(Screenshot_File);
        ImageIO.write(img, "png", outputFile);
    }

    @SuppressWarnings("checkstyle:Indentation")
    public void gui77() {
        setLiving = parseDouble(userText2.getText());
        setGrocery = parseDouble(userText3.getText());
        setRest = parseDouble(userText4.getText());
        setTrans = parseDouble(userText5.getText());
        setEntertainment = parseDouble(userText6.getText());
        setMisc = parseDouble(userText7.getText());

        budget.setMonth(setMonth);
        budget.setBudget(setBudget);
        budget.setLivingExpenses(setLiving);
        budget.setGroceries(setGrocery);
        budget.setRestaurants(setRest);
        budget.setTransportation(setTrans);
        budget.setEntertainment(setEntertainment);
        budget.setMiscellaneous(setMisc);
        budget.setTotalExpenses();
        budget.setBalance();
        budget.getBalance();
        budget.setBalancePercent();
        budget.getBalancePercent();
    }

    public void gui8() {
        save.setBounds(100, 200, 85, 25);
        panel.add(save);
        save.addActionListener(this);

        load = new JButton(new AbstractAction("Load") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gui88();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        );
        load.setBounds(190, 200, 85, 25);
        panel.add(load);
        load.addActionListener(this);


        frame.setTitle("Budget Assistant");
        frame.setVisible(true);
    }

    public void gui88() throws IOException, ClassNotFoundException {
        FileInputStream inFile = new FileInputStream(BudgetGui_File);
        ObjectInputStream is = new ObjectInputStream(inFile);
        ArrayList<Budget> inList = (ArrayList<Budget>) is.readObject();
        for (Budget budget2 : inList) {
            monthHere1.setText("Month Name: " + budget2.getMonth());
            budgetHere1.setText("Budget Amount: $" + budget2.getBudget());
            livingExpensesHere1.setText("Living Expenses: $" + budget2.getLivingExpenses());
            groceryExpensesHere1.setText("Grocery Expenses: $" + budget2.getGroceries());
            restaurantExpensesHere1.setText("Restaurant Expenses: $" + budget2.getRestaurants());
            transportationExpensesHere1.setText("Transportation Expenses: $" + budget2.getTransportation());
            entertainmentExpensesHere1.setText("Entertainment Expenses: $" + budget2.getEntertainment());
            additionalExpensesHere1.setText("Additional Expenses: $" + budget2.getMiscellaneous());
            budget2.setTotalExpenses();
            budget2.setBalance();
            budget2.getBalance();
            budget2.setBalancePercent();
            budget2.getBalancePercent();
            percentage.setText("Percentage Spent: " + budget2.getBalancePercent() + "%");
            frame.setVisible(true);
        }
    }

    public double parseDouble(String str) {
        if (str != null) {
            try {
                return Double.parseDouble(str);
            } catch (Exception e) {
                return 0; // wrong value
            }
        } else {
            return -1;
        }
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
