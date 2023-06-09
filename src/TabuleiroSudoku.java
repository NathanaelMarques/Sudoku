import java.util.*;

public class TabuleiroSudoku {

    Integer[][] quadrante = new Integer[3][3];

    public TabuleiroSudoku(){}
    private Integer gerarNum(TabuleiroSudoku[][] tabuleiro, int x,int y,int z,int c){
        LinkedList<Integer> numAleatorios = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        Random random = new Random();
        for(int i = 0;i<numAleatorios.size();i++){
            int num = numAleatorios.get(random.nextInt(numAleatorios.size()-1));
            numAleatorios.remove(numAleatorios.indexOf(num));
            if(comparador(tabuleiro,x,y,num,c,z)){
                return num;
            }
        }
        return 0;
    }

    // GERADOR DO TABULEIRO
    private TabuleiroSudoku[][] geraTab(TabuleiroSudoku[][] tabuleiro){
        for(int c = 0; c < tabuleiro.length; c++) {
            for (int z = 0; z < tabuleiro.length; z++) {
                tabuleiro[c][z] = new TabuleiroSudoku();
                for (int x = 0; x < quadrante.length; x++) {
                    for (int y = 0; y < quadrante[x].length; y++) {
                            tabuleiro[c][z].quadrante[x][y] = gerarNum(tabuleiro,x,y,z,c);
                    }
                }
            }
        }
        return tabuleiro;
    }

    public TabuleiroSudoku[][] validTabuleiro(TabuleiroSudoku[][] tabuleiro){
        geraTab(tabuleiro);
        if(resolveTabuleiro(tabuleiro) == null){
            return validTabuleiro(tabuleiro);
        }
        return tabuleiro;
    }

    private TabuleiroSudoku[][] resolveTabuleiro(TabuleiroSudoku[][] tabuleiro){
        for(int cx = 0; cx < tabuleiro.length; cx++){
            for(int cy = 0; cy < tabuleiro[cx].length; cy++){
                for(int x = 0; x <tabuleiro[cx][cy].quadrante.length; x++){
                    for(int y = 0; y < tabuleiro[cx][cy].quadrante[x].length; y++){
                        for(int num = 1; num <= 9;num++){
                            if(tabuleiro[cx][cy].quadrante[x][y] < 1 && comparador(tabuleiro,x,y,num,cx,cy)){
                                tabuleiro[cx][cy].quadrante[x][y] = num;
                            }
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
