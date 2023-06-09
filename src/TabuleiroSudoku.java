import java.util.Arrays;
import java.util.Random;

public class TabuleiroSudoku {

    Integer[][] quadrante = new Integer[3][3];

    public TabuleiroSudoku(){}


    // GERADOR DO TABULEIRO
    public TabuleiroSudoku[][] geraTab(TabuleiroSudoku[][] tabuleiro){
        Random random = new Random();
        int numRandom;
        for(int c = 0; c < tabuleiro.length; c++) {
            for (int z = 0; z < tabuleiro.length; z++) {
                tabuleiro[c][z] = new TabuleiroSudoku();
                for (int x = 0; x < quadrante.length; x++) {
                    for (int y = 0; y < quadrante[x].length; y++) {
                        tabuleiro[c][z].quadrante[x][y] = 0;
                        numRandom = random.nextInt(9) + 1;
                        if(comparador(tabuleiro,x,y,numRandom,c,z)){
                            tabuleiro[c][z].quadrante[x][y] = numRandom;
                        }

                    }
                }
            }
        }
        return tabuleiro;
    }

    // VERIFICADORES
    private boolean verificaLinha(TabuleiroSudoku[][] tabuleiro, int linha, Integer input,int coordenadasX){

            for(int x = 0; x < tabuleiro.length; x++){
                if(tabuleiro[coordenadasX][x]!=null) {
                    for (int y = 0; y < tabuleiro[coordenadasX].length; y++) {
                        if (input.equals(tabuleiro[coordenadasX][x].quadrante[linha][y])) {
                            return false;
                        }
                    }
                }
            }
            return true;
    }

    private boolean verificaColuna(TabuleiroSudoku[][] tabuleiro, int coluna, Integer input, int coordenadasY){
        for(int x = 0; x < tabuleiro.length; x++){
            if (tabuleiro[x][coordenadasY] != null) {
                for (int y = 0; y < tabuleiro.length; y++) {
                    if (input.equals(tabuleiro[x][coordenadasY].quadrante[y][coluna])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean verificaQuadrante(TabuleiroSudoku[][] tabuleiro, int coordenadasX, int coordenadasY, Integer input){
        for(int x = 0; x < tabuleiro.length; x++){
            for(int y = 0; y < tabuleiro[coordenadasX].length; y++){
                if(input.equals(tabuleiro[coordenadasX][coordenadasY].quadrante[x][y])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean comparador(TabuleiroSudoku[][] tabuleiro,int linha, int coluna, Integer input,
                              int coordenadasX, int coordenadasY){
        if(verificaColuna(tabuleiro, coluna, input,coordenadasY)
           &&
           verificaLinha(tabuleiro, linha, input,coordenadasX)
           &&
           verificaQuadrante(tabuleiro,coordenadasX, coordenadasY, input)
           &&input!=null){
            return true;
        }
        return false;
    }

    // ADICIONA NOVOS ELEMENTOS AO TABULEIRO
    public TabuleiroSudoku[][] addTabuleiro(TabuleiroSudoku[][] tabuleiro,int coordenadasX, int coordenadasY,
                                            int linha, int coluna, int input){
        tabuleiro[coordenadasX][coordenadasY].quadrante[linha][coluna] = input;
        return tabuleiro;
    }

    // IMPRIME O TABULEIRO FORMATADO
    public void verTabuleiro(TabuleiroSudoku[][] tabuleiro){ //lógica insana de print
        for(int x =0; x<tabuleiro.length;x++){
            for(int y = 0;y< tabuleiro[x].length;y++){
                for(int z = 0;z < tabuleiro[x][y].quadrante.length;z++){
                    for(int c = 0; c < tabuleiro[x][y].quadrante[z].length; c++){
                         if(tabuleiro[x][z].quadrante[y][c]!=0){
                             System.out.print("|" + tabuleiro[x][z].quadrante[y][c] + "|");
                         }else {
                             System.out.print("|" + " |");
                         }

                    }
                    System.out.print(" ");
                }
                System.out.println("");
            }
            System.out.println(" ");
        }

    }



}
