import java.util.Arrays;
import java.util.Random;

public class TabuleiroSudoku {

    Integer[][] quadrante = new Integer[3][3];

    public TabuleiroSudoku(){}

    public TabuleiroSudoku[][] geraTab(TabuleiroSudoku[][] tabuleiro){
        Random random = new Random();

        for(int c = 0; c < tabuleiro.length; c++) {
            for (int z = 0; z < tabuleiro.length; z++) {
                tabuleiro[c][z] = new TabuleiroSudoku();
                for (int x = 0; x < quadrante.length; x++) {
                    for (int y = 0; y < quadrante[x].length; y++) {

                        tabuleiro[c][z].quadrante[x][y] = random.nextInt(10);
                    }
                }
            }
        }
        return tabuleiro;
    }
    private boolean verificaLinha(TabuleiroSudoku[][] tabuleiro, int linha, int input,int coordenadasX){

            for(int x = 0; x < tabuleiro.length; x++){
                for(int y = 0; y < tabuleiro[coordenadasX].length; y++){
                        if (tabuleiro[coordenadasX][x].quadrante[linha][y] == input) {
                            return false;
                        }
                }
            }
            return true;
    }

    private boolean verificaColuna(TabuleiroSudoku[][] tabuleiro, int coluna, int input, int coordenadasY){
        for(int x = 0; x < tabuleiro.length; x++){
            for(int y = 0; y < tabuleiro.length; y++){
                    if (tabuleiro[x][coordenadasY].quadrante[y][coluna] == input) {
                        return false;
                    }
            }
        }
        return true;
    }

    private boolean verificaQuadrante(TabuleiroSudoku[][] tabuleiro, int coordenadasX, int coordenadasY, int input){
        for(int x = 0; x < tabuleiro.length; x++){
            for(int y = 0; y < tabuleiro[coordenadasX].length; y++){
                    if (tabuleiro[coordenadasX][coordenadasY].quadrante[x][y] == input) {
                        return false;
                    }
            }
        }
        return true;
    }

    public boolean comparador(TabuleiroSudoku[][] tabuleiro,int linha, int coluna, int input,
                              int coordenadasX, int coordenadasY){
        if(verificaColuna(tabuleiro, coluna, input,coordenadasY)
           &&
           verificaLinha(tabuleiro, linha, input,coordenadasX)
           &&
           verificaQuadrante(tabuleiro,coordenadasX, coordenadasY, input)
           &&input>0&&input<10){
            return true;
        }
        return false;
    }
    public TabuleiroSudoku[][] addTabuleiro(TabuleiroSudoku[][] tabuleiro,int coordenadasX, int coordenadasY,
                                            int linha, int coluna, int input){
        tabuleiro[coordenadasX][coordenadasY].quadrante[linha][coluna] = input;
        return tabuleiro;
    }
    public void verTabuleiro(TabuleiroSudoku[][] tabuleiro){ //lógica insana de print
        for(int x =0; x<tabuleiro.length;x++){
            for(int y = 0;y< tabuleiro[x].length;y++){
                for(int z = 0;z < tabuleiro[x][y].quadrante.length;z++){
                    for(int c = 0; c < tabuleiro[x][y].quadrante[z].length; c++){
                         if(tabuleiro[x][z].quadrante[y][c]!=0){
                             System.out.print("|" + tabuleiro[x][z].quadrante[y][c] + "|");
                         }else{
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
