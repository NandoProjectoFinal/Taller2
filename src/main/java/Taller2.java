import org.junit.platform.commons.util.StringUtils;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;


public class Taller2 {
    static String ruta = "C:\\Users\\HP\\blabla\\cadenas.txt";
    public static void main(String[] args) {
        String[] a = ingresarPalabra();
        String[] b= transformarPalabra(a);
        validar(b);

    }
    public static boolean validar(String s[]) {
        int c = 0;
        for (int i=0; i<s.length; i++){
            int fin = s[i].length()-1;
            int ini=0;
            boolean b=true;
            while(ini < fin){
                if(s[i].charAt(ini)!=s[i].charAt(fin)){
                    b=false;
                }
                ini++;
                fin--;
            }
            if(b){
                System.out.print("\nEs palindromo.");
                System.out.println(s[i]);
                b=true;
                c++;
            }
            else{
                System.out.print("\nNo es palindromo.");
                b = false;
            }

        }
        if (c==s.length){
            return true;
        }
        else{return false;}
    }


    public static String[] transformarPalabra(String[] a) {
        String[] b = new String[a.length];
         for (int i=0; i<a.length; i++) {
             b = a[i].toLowerCase().replace(" ", "").split("");
             for (int j=0; j<b.length;j++){
                 b[j] = b[j].replace("ú", "u");
                 b[j] = b[j].replace("á", "a");
                 b[j] = b[j].replace("é", "e");
                 b[j] = b[j].replace("í", "i");
                 b[j] = b[j].replace("+ó", "o");
                 System.out.print(b[j]);
             }
         }
        return b;
    }

    private static String[] ingresarPalabra() {
        Path archivo = Paths.get(ruta);
        String contenido = "";
        try {
            contenido = new String(Files.readAllBytes(archivo));
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
        }
        String[] palabra = contenido.split("\n");
        return palabra;
    }
}
