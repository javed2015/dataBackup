package test;

import java.io.File;

public class MoveFileOrDir {

    private static void doMove() {

        // File (or Directory) to be moved
        File file = new File("C:\\VOTSH\\TesJav\\InstantWinApp");

        // Destination directory
        File dir = new File("C:\\VOTSH\\NewRepoTest");

        // Move file to a new directory
        boolean success = file.renameTo(new File(dir, file.getName()));

        if (success) {
            System.out.println("File was successfully moved.\n");
        } else {
            System.out.println("File was not successfully moved.\n");
        }


    }


    /**
     * Sole entry point to the class and application.
     * @param args Array of String arguments.
     */
    public static void main(String[] args) {
        doMove();
    }

}
