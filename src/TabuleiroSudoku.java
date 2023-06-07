import java.util.Arrays;

public class TabuleiroSudoku {

    Integer[][] quadrante = new Integer[3][3];



    public Integer[][] getQuadrante() {
        return quadrante;
    }

    public void setQuadrante(Integer[][] quadrante) {
        this.quadrante = quadrante;
    }

    public TabuleiroSudoku[][] geraTab(TabuleiroSudoku[][] tabuleiro){

        for(int c = 0; c < tabuleiro.length; c++) {
            for (int z = 0; z < tabuleiro.length; z++) {
                tabuleiro[c][z] = new TabuleiroSudoku();
                for (int x = 0; x < tabuleiro.length; x++) {
                    for (int y = 0; y < tabuleiro.length; y++) {

                        tabuleiro[c][z].quadrante[x][y] = 2;
                    }
                }
            }
        }
        return tabuleiro;
    }
    private boolean verificaLinha(TabuleiroSudoku[][] tabuleiro, int linha, int input,int coordenadasX){

            for(int x = 0; x < tabuleiro.length; x++){
                for(int y = 0; y < tabuleiro[coordenadasX].length; y++){
                  if(tabuleiro[coordenadasX][x].quadrante[linha][y] == input){
                      return false;
                  }
                }
            }
            return true;
    }

    private boolean verificaColuna(TabuleiroSudoku[][] tabuleiro, int coluna, int input, int coordenadasY){
        for(int x = 0; x < tabuleiro.length; x++){
            for(int y = 0; y < tabuleiro.length; y++){
                if(tabuleiro[x][coordenadasY].quadrante[y][coluna] == input){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean verificaQuadrante(TabuleiroSudoku[][] tabuleiro, int coordenadasX, int coordenadasY, int input){
        for(int x = 0; x < tabuleiro.length; x++){
            for(int y = 0; y < tabuleiro[coordenadasX].length; y++){
                if(tabuleiro[coordenadasX][coordenadasY].quadrante[x][y] == input){
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
           verificaQuadrante(tabuleiro,coordenadasX, coordenadasY, input)){
            return true;
        }
        return false;
    }
    public TabuleiroSudoku[][] addTabuleiro(TabuleiroSudoku[][] tabuleiro,int coordenadasX, int coordenadasY,
                                            int linha, int coluna, int input){

        tabuleiro[coordenadasX][coordenadasY].quadrante[linha][coluna] = input;
        return tabuleiro;
    }
    @Override
    public String toString(){
        return Arrays.deepToString(quadrante);
    }
}
