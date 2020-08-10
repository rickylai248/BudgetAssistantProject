package ui;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new MyUI() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
    }
}
