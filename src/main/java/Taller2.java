import java.util.Scanner;
import java.util.StringJoiner;

public class Taller2 {
    public static void main(String[] args) {
        String a = ingresarPalabra();
        String b= transformarPalabra(a);
        validar(b);
    }
    public static boolean validar(String s) {
        int fin = s.length()-1;
        int ini=0;
        boolean b=true;

        while(ini < fin){
            if(s.charAt(ini)!=s.charAt(fin)){
                b=false;
            }
            ini++;
            fin--;
        }
        if(b)
            System.out.print("\nEs palindromo.");
        else
            System.out.print("\nNo es palindromo.");

        return b;
    }


    private static String transformarPalabra(String a) {
        String palabra2= a.replace(" ","");
        return palabra2;
    }

    private static String ingresarPalabra() {
        Scanner teclado= new Scanner(System.in);
        String palabra = teclado.next()+teclado.nextLine();
        return palabra;
    }



}
