/*
 * Created by Ashee on 2017/7/5.
 */
import gurobi.*;

public class Main {
    public static void main(String[] args){

        int m=10;
        int l1=2;
        int l2=3;

        try {
            GRBEnv env = new GRBEnv("Exercise2");
            GRBModel model = new GRBModel(env);

            //variable
            GRBVar b[]=new GRBVar[m];
            GRBVar x[][] = new GRBVar[l1][m];
            GRBVar y[][] = new GRBVar[l2][m];

            for(int i=0 ; i<m; i++)
                b[i] = model.addVar(0.0,1.0,0.0,GRB.BINARY,"b");
            for(int i=0 ; i<l1 ; i++)
            {
                for(int j=0 ; j<m ;j++)
                {
                    x[i][j]=model.addVar(0.0,1.0,0.0,GRB.BINARY,"x");
                }
            }
            for(int i=0 ; i<l2 ; i++)
            {
                for(int j=0 ; j<m ; j++)
                {
                    y[i][j]=model.addVar(0.0,1.0,0.0,GRB.BINARY,"y");
                }
            }

            model.update();

            // objective

            GRBLinExpr obj = new GRBLinExpr();
            for(int i=0 ; i<m ; i++)
                obj.addTerm(1.0,b[i]);
            model.setObjective(obj,GRB.MINIMIZE);

            //constraint
            for(int i=0;i<l2 ; i++) {
                GRBLinExpr cons = new GRBLinExpr();
            }



        }
        catch(GRBException ex) {
            System.err.println(ex);
        }


    }
}
