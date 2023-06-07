import java.util.Scanner;

public class Player {
    public int posicaoTab(int inputTab){
        switch (inputTab){
            case 1,2,3: return 0;
            case 4,5,6: return 1;
            case 7,8,9: return 2;
            default:
                return -1;
        }
    }
    public int posicao(int inputQuadrante){
        switch (inputQuadrante){
            case 1,4,7: return 0;
            case 2,5,8: return 1;
            case 3,6,9: return 2;
            default:
                return -1;
        }
    }
}
