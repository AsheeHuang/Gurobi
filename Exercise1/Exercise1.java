import gurobi.*;

public class Exercise1
{
    public static void main(String[] args)
    {
        int n=10;
        int m=10;
        int k=0;

        try
        {
            GRBEnv env=new GRBEnv("Exercise1");
            GRBModel model=new GRBModel(env);


            //Variable
            GRBVar x[]=new GRBVar[m];
            GRBVar y[]=new GRBVar[n];

            for(int i=0;i<m;i++)
                model.addVar(0.0,1.0,0.0,GRB.BINARY,"x");
            for(int i=0;i<n;i++)
                model.addVar(0.0,1.0,0.0,GRB.BINARY,"y");

            //Set Objective

            GRBLinExpr obj=new GRBLinExpr();
            for(int j=0;j<n;j++)
                obj.addTerm(1.0,y[j]);
            model.setObjective(obj,GRB.MINIMIZE);

            //Constraint
            GRBLinExpr cons=new GRBLinExpr();
            for(int i=0;i<m;i++)
                cons.addTerm(1.0,x[i]);
            model.addConstr(cons,GRB.EQUAL,k,"c0");

        }
        catch(GRBException ex)
        {
            System.out.println(ex);
        }
    }
}
