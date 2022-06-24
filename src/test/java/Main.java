import github.grovre.saves.SaveFile;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File src = new File("C:\\Users\\lando\\IdeaProjects\\Save-Scummer\\src\\test\\java\\words.txt");
        SaveFile saveFile = new SaveFile(src);
        System.out.println(saveFile);
        saveFile.scumSave();
    }
}
