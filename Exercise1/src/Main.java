/*
 * Created by Ashee on 2017/7/5.
 */
import gurobi.*;

public class Main {
    public static void main(String[] args){

        int m=10;
        int l1=3;
        int l2=2;

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
            model.setObjective(obj,GRB.MAXIMIZE);

            //constraint 1
            GRBLinExpr cons = new GRBLinExpr();
            for(int i=0;i<l2 ; i++) {
                for(int j=0 ; j<m ;j++){
                    cons.addTerm(1.0,y[i][j]);
                }
            }
            model.addConstr(cons,GRB.LESS_EQUAL,l2,"c0");

            //constraint 2
            GRBLinExpr cons2 = new GRBLinExpr();
            for(int i=0 ; i<l1 ; i++){
                for(int j=0 ; j<m ;j++){
                    cons.addTerm(1.0, x[i][j]);
                }
            }
            model.addConstr(cons2,GRB.LESS_EQUAL,l1,"c1");

            //constraint 3


        }
        catch(GRBException ex) {
            System.err.println(ex);
        }


    }
}
