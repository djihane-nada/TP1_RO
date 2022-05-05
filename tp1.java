import java.util.Arrays;
public class matrice {
	
    public matrice(int nbr_lig, int nbr_cln) {
    public  (int nbr_lig, int nbr_cln) {
    public float [][];
    public int nbr_lig;
    public int nbr_cln;
    
    public matrice (int nbr_lig, int nbr_cln) {
    	this.nbr_lig = nbr_lig;
    	this.nbr_cln = nbr_cln;
    public matrice(int nbr_lig, int nbr_cln) {
    
    	this. matrice = new float[nbr_lig][nbr_cln];
    }


    public float[][] iteration_GJ(float [][] A, int r, int s) throws Exception {
    	
        float Pivot = A[r][s];

        if(Pivot == 0) {
        	throw new Exception(" not possible ");
        }
        else {
        
	        for(int j = 0; j < A[0].length; j++) {
	            A[r][j] = A[r][j] / Pivot;
	        }
	        
	        for(int i = 0; i < A.length; i++) {
	            if(i != r) {
	                float Ais = A[i][s];
	                for(int j = 0; j < A[0].length; j++) {
	                	float Arj = A[r][j];
	                    A[i][j] = A[i][j] - Ais * Arj;
	                }
	            }
	        }
	    
	        return A;
        }
    }
   

	public  matrice inverse () {
		
	     matrice M = new  matrice (this.nbr_lig, this.nbr_cln *2);
	    
 	    for (int i = 0; i < this.nbr_lig; i++) {
 			for (int j = 0; j < this.nbr_cln; j++) {
 				M.matrice[i][j] = this.matrice[i][j];
 				M.matrice[i][j + this.nbr_cln] =  i == j ? 1 : 0;
 			}
 		}
 	    
	    return M;
	}
	
    /// en utulisante Gauss-Jordan :
	
    public void GaussJordanInverse() throws Exception {
    	
    	 matrice M = new  matrice(this.matrice);
    	
    	M = M.inverse();
    	int l;
    	if(matrice[0].length%2 == 0)
    	{
    		l = (int)matrice[0].length/2+1;
    	}
    	else 
    	{
    		l = (int)matrice[0].length/2 +1+1;
    	}
    	
    	
    	for(int i = 0; i < M.matrice.length; i++) {
    		M.matrice = this.iteration_GJ(M.matrice, i, i);
    	}
    	for(int i = 0; i < M.matrice.length; i++) {
    		for(int j = 0; j < M.matrice.length; j++) {
        		M.matrice[i][j] = M.matrice[i][j+l];
        	}
    	}
    	

    	this.nbr_cln = l;
    	this.nbr_lig = l;
    	this.matrice= M.matrice;
    }

    
    /// simplex 
    
    public float[] simplex(float[] Z , float[] B , objectif objectif ) throws Exception {
    	
	float[][] M = this.matrice;
	    
    	float[][] N = new float[A.length+1][A.length + Z.length + 1];
    	 
    	String[] D = new String[A.length +1];
    	
    	EcartStandarisation(Z,D,B,M,N);
    	
    	for (int iteration = 1; EstOptimal(N, objectif); iteration++) {
    		
    		System.out.println("iteration = " + iteration);
    		tableauSimplex(N, D);
    		int c = variable_E(N, objectif);
    		int r = variable_S(N, c);
    		S[r]="x" + (c+1);
    		
    		System.out.println("s =" + c + "r = " + r);
    		iteration_GJ(N, r , c);

         }
    	
    	tableauSimplex(M, S);
	    System.out.println("Z = " + M[M.length-1][M[0].length-1]*(-1));
    	return Solution(Z, N ,D );
    	

    }
	
	
	 private static void tableauSimplex(float[][] A , String[] Variable_b){
    	
    	System.out.print("| V B |");
    	
    	for(int i = 1 ; i < A[0].length; i++)
    		System.out.print(" x"+i+" |");
    	
    	System.out.print(" b  |");
    	System.out.println();
    	
    	for(int i = 0 ; i < A.length; i++) {
    		
    		System.out.print("| "+Variable_b[i]+"  |");
    		for (int j = 0 ; j< A[0].length; j++) {
    			System.out.print(String.format("%,1.1f", A[i][j]) + " |");
    			
    		}
    		
    		System.out.println();
    	}
    	
    	System.out.println();
    }

		/// qst4 test 

        float[][] A = {{2,-1,0},{-1,2,-1},{0,-1,2}};
		float[][] B = {{2,1},{3,1}};
		 
		matrice matrice_A = new matrice (A);
		matrice_A.GaussJordanInverse();
		System.out.println("l'inverse de la matrice A :");
		matrice_A.Afficher();
		
		matrice matrice_B = new matrice(B);
		matrice_B.GaussJordanInverse();
		System.out.println("l'inverse de la matrice B :");
		matrice_B.Afficher();
  
		
		float[] z = {60,30,20};
		float[][] A = {{8,6,1},{4,2,1},{2,1,0}};
		matrice matrice_A = new matrice(A);
		float[] b = {48,20,8};
		
		float[] solution  = matrice_A.simplex( z,b,objectif.MAX );
		
		 
		
	}

}
  