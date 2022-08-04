import java.util.Scanner;
public class Main {
    static Scanner in = new Scanner(System.in);
    public static int i, j;
    public static char x;
    public static String s;
    public static String ch;

    public static void inputFraseParola(){
        //Prendiamo in input una frase + la parola da cifrare
        System.out.print("Inserisci Frase iniziale: ");
        s = in.nextLine();
        System.out.print("Inserisci Parola da cifrare: ");
        ch = in.nextLine();
    }

    public static void codificaPolibio(){
        int lg=ch.length();
        char A[]=ch.toCharArray() ;
        for(i=0;i < lg;i++) System.out.print(A[i]+" ");
        System.out.println();
        //creo la matrice di trasposizione
        int r;
        if(s.length()%lg==0)r=s.length()/lg;
        else r=s.length()/lg+1;
        System.out.println();
        char B[][] = new char[r][lg];
        s=s.replace(" ", "");//elimino gli spazi dalla stringa da criptare
        x=0;
        for(i=0;i < B.length;i++)
            for(j=0;j < B[0].length;j++){
                if(x < s.length()){
                    B[i][j]=s.charAt(x); x++; }else B[i][j]=' ';
            }
        //stampo la matrice di trasposizione
        for(i=0;i < B.length;i++){
            for(j=0;j < B[0].length;j++) System.out.print(B[i][j]+" " );
            System.out.println();
        }//fine for i
        //ordino la chiave in modo alfabetico
        for(i=0;i < lg-1;i++)
            for(j=i;j < lg;j++) if(A[i] > A[j]){
                x=A[i];A[i]=A[j];A[j]=x;
            } //e la stampo
        for(i=0;i < lg;i++) System.out.print(A[i]+" ");

        //creo il vettore che contiene l'ordine di estrazione delle colonne
        int T[] = new int[lg];
        for(i=0;i < lg;i++) T[i]=ch.indexOf(A[i]);
        System.out.println(); //e lo stampo per verificare l'esattezza
        for(i=0;i < lg;i++)System.out.print(T[i]+" ");
        System.out.println();
        //concatenazione della stringa crittata
        s="";//reimposto s a stringa nulla
        for(j=0;j < lg;j++)
            for(i=0;i < r;i++) if(B[i][T[j]]!=' ')
                s+=B[i][T[j]];
    }

    public static void main(String[] args) {
        inputFraseParola();
        codificaPolibio();
        //stampo la stringa crittata
        System.out.print(s);
    }
}