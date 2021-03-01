package algorithms;

public class HamiltonianCycle {
    private int numberOfVertexes;
    private int[] hamiltonianPath;
    private int[][] matrix;

    public HamiltonianCycle(int[][] matrix) {
        this.matrix = matrix;
        this.hamiltonianPath = new int[matrix.length];
        this.numberOfVertexes = matrix.length;
        this.hamiltonianPath[0] = 0;



    }
    public void solve(){
        if (findGoodSolution(1)) {
            showHamiltonianPath();
        } else {
            System.out.println("No good solution...");

        }
    }

    private boolean findGoodSolution(int position) {

        if (position == numberOfVertexes) {
            if (matrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1) {
                return true;
            }else return false;
        }
        for(int vertexIndex=1;vertexIndex<numberOfVertexes;++vertexIndex){
            if(isFeasible(vertexIndex,position)){
                hamiltonianPath[position]=vertexIndex;
                if(findGoodSolution(position+1)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isFeasible(int vertexIndex, int actualPosition) {
        if(matrix[hamiltonianPath[actualPosition-1]][vertexIndex]==0)
            return false;
        for(int i=0;i<actualPosition;i++){
            if(hamiltonianPath[i]==vertexIndex){
                return false;
            }
        }
        return true;
    }

    private void showHamiltonianPath() {
        System.out.print("Hamiltonian cycle: ");

        for (int i = 0; i < hamiltonianPath.length; i++) {
            System.out.print(hamiltonianPath[i] + " ");
        }
        System.out.print(hamiltonianPath[0]);
    }
}
