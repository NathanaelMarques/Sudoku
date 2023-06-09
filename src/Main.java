import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("SUDOKU");
        TabuleiroSudoku[][] tabuleiro = new TabuleiroSudoku[3][3];
        TabuleiroSudoku tabuleiroSudoku = new TabuleiroSudoku();
        Player player = new Player();

        tabuleiroSudoku.validTabuleiro(tabuleiro);
        tabuleiroSudoku.verTabuleiro(tabuleiro);


        int tempLinha;
        int tempColuna;
        int num;
        while(true) {
            System.out.println("Insira Linha:");
            tempLinha = sc.nextInt();
            System.out.println("Insira Coluna:");
            tempColuna = sc.nextInt();
            System.out.println("Insira Número:");
            num = sc.nextInt();

            int posicaoLinha = player.posicao(tempLinha);
            int posicaoColuna = player.posicao(tempColuna);
            int posicaoTabLinha = player.posicaoTab(tempLinha);
            int posicaoTabColuna = player.posicaoTab(tempColuna);
            if (tabuleiroSudoku.comparador(tabuleiro, posicaoLinha, posicaoColuna, num, posicaoTabLinha, posicaoTabColuna)) {
                tabuleiro = tabuleiroSudoku.addTabuleiro(tabuleiro, posicaoTabLinha, posicaoTabColuna, posicaoLinha, posicaoColuna, num);
            } else {
                System.out.println("Errou!!!");
            }

            tabuleiroSudoku.verTabuleiro(tabuleiro);
        }
    }
}