package global.goit.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tests {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("D:\\Java\\IDEProjects\\Developer\\DevClassModule9\\app\\src\\main\\resources\\index.html"));

        while (sc.hasNext()) {
            System.out.println("sc.nextLine() = " + sc.nextLine());
        }
    }

}
