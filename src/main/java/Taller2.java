import org.junit.platform.commons.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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


    private static String[] transformarPalabra(String[] a) {
        for (int i=0; i<a.length; i++) {
            a[i] = a[i].replace(" ", "").toLowerCase();
        }
        return a;
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
