import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveUserMessage {

    public static Map<String, String> mapMessagesUsers = new HashMap<String, String>();
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String command="";
        while (!command.equals("exit")) {
            System.out.println("To save the data, enter 'save'");
            System.out.println("To display messages on the screen, enter 'message'");
            System.out.println("To end the program, enter 'exit'");
             command = reader.readLine();
            if (command.equals("save")) {
                saveCommand();
            } else if (command.equals("message")) {
                messageCommand();
            }
        }
    }
    public static void saveCommand() throws IOException {
            System.out.println("Enter name: ");
            String name = reader.readLine();
            System.out.println("Enter message: ");
            String message = reader.readLine();
            if (mapMessagesUsers.containsKey(name)) {
                String m = mapMessagesUsers.get(name);
                mapMessagesUsers.put(name, m + "---" + message);
            } else mapMessagesUsers.put(name, message);
    }
    public static void messageCommand() throws IOException {
        System.out.println("Enter name: ");
        String name = reader.readLine();
        if (mapMessagesUsers.containsKey(name)) {
            System.out.println("User '" + name + "' has saved the following messages: ");
            List<String> messagesList = Arrays.asList(mapMessagesUsers.get(name).split("---"));
            for (String s : messagesList)
                System.out.println(s);
        } else
            System.out.println("This user does not exist, please try again: ");
    }
}
