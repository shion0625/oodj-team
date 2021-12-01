package Class;

import java.io.*;

public class OverrideOfFile {
    private String target;
    private String fileName;
    private int array_num;
    private String textToInclude;
    public OverrideOfFile() {}

    public OverrideOfFile(String target, String fileName,int array_num, String textToInclude) {
        this.target = target;
        this.fileName = fileName;
        this.array_num = array_num;
        this.textToInclude = textToInclude;
    }

    public boolean Override() {
        try{
            File mainFile = new File(this.fileName);
            File tempFile = new File("centerTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(mainFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null){
                String[] UsersArray = currentLine.split(" ");
                if(UsersArray[0].equals(this.target)) {
                    UsersArray[this.array_num] = this.textToInclude;
                    String UserString = String.join(" ", UsersArray);
                    writer.write(UserString);
                    writer.write("\n");
                    continue;
                }
                writer.write(currentLine);
                writer.write("\n");
            }
            writer.close();
            return tempFile.renameTo(mainFile);
        } catch (IOException ex){
            return false;
        }
    }
}
