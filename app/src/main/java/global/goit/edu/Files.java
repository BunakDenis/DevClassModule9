package global.goit.edu;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringJoiner;

public class Files {

    public static String getFileByPath(String path) throws IOException {
        String result = "";
        if (path.equals("/")) {
            result = readHtmlFiles("\\index.html");
            //System.out.println("result = " + result);
            return result;
        } else {
            System.out.println("read " + path);
            result = readHtmlFiles(path);
            //System.out.println("result = " + result);
            return result;
        }

    }

    public static String readHtmlFiles(String path) throws IOException {
        File file = new File("D:\\Java\\IDEProjects\\Developer\\DevClassModule9\\app\\src\\main\\resources" + path);
        Scanner sc = new Scanner(file);
        StringJoiner result = new StringJoiner("\n");

        while (sc.hasNext()) {
            result.add(sc.nextLine());
        }

/*        String result = java.nio.file.Files.readString(
                Paths.get("D:\\Java\\IDEProjects\\Developer\\DevClassModule9\\app\\src\\main\\resources", path)
        );*/

        return result.toString();
    }
}
