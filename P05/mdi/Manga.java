package mdi;

public class Manga {
    public static void main(String[] args) {
        String name = "";


        if (args.length > 0) {
            for (String a : args) {
                name += a + " ";
            }
            name = name.trim();
        }
        else {
            name = "MANGA Store";
        }

        Controller controller = new Controller(name);
        controller.mdi();
    }
}
