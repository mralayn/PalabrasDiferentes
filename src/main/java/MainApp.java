import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MainApp {
    static int palabrasTotales;
    public static void main(String args[]) {
        palabrasTotales =0;

        if (args.length == 0){
            System.out.println("falta el nombre del archivo");
            System.exit(1);

        }
        String fileName = args[0];

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("el nombre del archivo no se encuentra");
            System.exit(2);
        }

        BufferedReader in = new BufferedReader(fileReader);
        String textLine = null;
        int contador = 0;
        while (true) {
            try {
                if (!((textLine = in.readLine())   != null))

                    break;
            } catch (IOException e) {
                System.out.println("error al leer el archivo");
                System.exit(3);
            }
            contador++;
            StringTokenizer st = new StringTokenizer(textLine);
            palabrasTotales = palabrasTotales + st.countTokens();

        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("el archivo " + fileName + " tiene " + contador + " lineas ");
        System.out.println("");
        System.out.println("el archivo tiene "+palabrasTotales+" palabras");


    }
}

