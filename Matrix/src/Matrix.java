public class Matrix {
   double[][] elements;


   public Matrix(){

   }

   public Matrix(double[][] elements){
      this.elements = elements;
   }

   private double determinant(double[][] matrix){
      if (matrix.length==2){
         return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
      }else{
         int swit = 1;
         double determinant = 0;
         for (int i = 0; i < matrix.length; i++) {
            determinant+= matrix[0][i] * determinant(coFactor(matrix, i)) * swit;
            swit = - swit;
         }
         return determinant;
      }
   }

   private double[][] coFactor(double[][] matrix, int i){
      double[][] co = new double[matrix.length-1][matrix.length-1];
      int x = 0;
      int y = 0;
      all:for (int j = 1; j < matrix.length; j++) {
         for (int k = 0; k < matrix.length; k++) {
            if (i!=k){
               co[x][y] = matrix[j][k];

               y++;
               if (y==matrix.length-1){
                  x++;
                  y=0;
               }
               if (x==matrix.length-1)
                  break all;
            }
         }
      }
      return co;

   } // for determinant

   private Matrix matrixMul(Matrix B) {
      double[][] a = this.getElements();
      double [][] b = B.getElements();
      int rowA = a.length;
      int colARowB = a[0].length;
      int colB = b[0].length;
      double[][] result = new double[rowA][colB];
      int x = 0;
      int y = 0;
      double sum = 0;
      all:
      for (double[] ints : a) {
         for (int j = 0; j < colB; j++) {
            for (int k = 0; k < colARowB; k++) {
               sum += ints[k] * b[k][j];
            }
            result[x][y] = sum;
            sum = 0;
            y++;
            if (y == colB) {
               x++;
               if (x == rowA) {
                  break all;
               }
               y = 0;
            }
         }

      }
      return new Matrix(result);
   }

   public double[][] getElements() {
      return elements;
   }

   public void setElements(double[][] elements) {
      this.elements = elements;
   }





}
