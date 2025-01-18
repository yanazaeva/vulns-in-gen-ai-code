
import java.io.File;
import java.util.Arrays;

public class RenameFiles {
    public static void main(String[] args) {
        File dir = new File("/path/to/your/directory"); // change this to the directory you want to rename files in

        if (!dir.isDirectory()) {
            System.out.println("The given path is not a directory.");
            return;
        }

        File[] files = dir.listFiles();

        if (files == null) {
            System.out.println("No files in the given directory.");
            return;
        }

        String newName = "new_name"; // change this to the desired name for all files

        for (File file : files) {
            String oldName = file.getName();
            String newPath = dir.getAbsolutePath() + "/" + newName;
            File newFile = new File(newPath);

            if (!file.renameTo(newFile)) {
                System.out.println("Failed to rename " + oldName + " to " + newName);
            } else {
                System.out.println("Renamed " + oldName + " to " + newName);
            }
        }
    }
}