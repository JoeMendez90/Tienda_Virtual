package tienda_virtual;

public class TreeInt {
    public treeNode<Integer> raiz;

    public TreeInt(int raiz) {
        this.raiz = new treeNode<>(raiz,null);
    }
    
    public treeNode<Integer> Find(int k, treeNode<Integer> R){
        if(R.key == k){
            return R;
        }else if(R.key > (k)){
            if(R.leftSon != null){
                return Find(k,R.leftSon);
            }
            return R;
        }else{
            if(R.rightSon != null){
                return Find(k,R.rightSon);
            }
            return R;
        }    
    }
    
    public treeNode<Integer> Next(treeNode<Integer> N){
        if(N.rightSon != null){
            return LeftDescendant(N.rightSon);
        }else{
            return RightAncestor(N);
        }
    }

    public treeNode<Integer> LeftDescendant(treeNode N) {
        if(N.leftSon == null){
            return N;
        }else{
            return LeftDescendant(N.leftSon);
        }
    }

    public treeNode<Integer> RightAncestor(treeNode<Integer> N) {
        if(N.key < N.father.key){
            return N.father;
        }else{
            return RightAncestor(N.father);
        }
    }
    
    public treeNode<Integer> firstNumber(){
        return LeftDescendant(raiz);
    }
    
    public void AVLInsert(int k, treeNode<Integer> R){
        Insert(k, R);
        treeNode<Integer> N = Find(k,R);
        Rebalance(N);
    }
    
    
    
    private void Insert(int k, treeNode<Integer> R){
        treeNode<Integer> P = Find(k, R);
        if(P.key==k){
        }else if(P.key>k){
            P.leftSon= new treeNode<>(k,P);
        }else{
            P.rightSon= new treeNode<>(k,P);
        }
        
    }
    
    public void AVLDelete (treeNode<Integer> N){
        treeNode<Integer> P = Next(N).father;
        Delete(N);
        Rebalance(P);
    }
    
    private void Delete (treeNode<Integer> N) {
        if(N.rightSon==null){
            if(N==raiz){
                raiz= N.leftSon;
                N.leftSon.father=null;
            }
        }else{
            treeNode<Integer> X = Next(N);
            N.key=X.key;
            
            X.father.leftSon=X.rightSon;
            X.rightSon.father=X.father;
        }
    }
    
    private void RotateRight(treeNode<Integer> X){
        treeNode<Integer> P = X.father;
        treeNode<Integer> Y = X.leftSon;
        treeNode<Integer> B = Y.rightSon;
        
        Y.father=P;
        if(P.leftSon.equals(X)){
            P.leftSon=Y;
        }else{
            P.rightSon=Y;
        }
        X.father=Y;
        Y.rightSon=X;
        B.father=X;
        X.leftSon=B;
        AdjustHeight(X);
        AdjustHeight(Y);
        AdjustHeight(P);
    }
    
    private void RotateLeft(treeNode<Integer> Y){
        treeNode<Integer> P = Y.father;
        treeNode<Integer> X = Y.rightSon;
        treeNode<Integer> B = X.leftSon;
        
        X.father=P;
        if(P.leftSon.equals(Y)){
            P.leftSon=X;
        }else{
            P.rightSon=X;
        }
        Y.father=X;
        X.leftSon=Y;
        B.father=Y;
        Y.rightSon=B;
        AdjustHeight(Y);
        AdjustHeight(X);
        AdjustHeight(P);
    }

    private void Rebalance(treeNode<Integer> N) {
        treeNode<Integer> P = N.father;
        if(N.leftSon.Height>N.rightSon.Height+1){
            RebalanceRight(N);
        }
        if(N.rightSon.Height > N.leftSon.Height+1){
            RebalanceLeft(N);
        }
        AdjustHeight(N);
        if(P != null){
            Rebalance(P);
        }      
    }

    private void RebalanceRight(treeNode<Integer> N) {
        treeNode<Integer> M = N.leftSon;
        if(M.rightSon.Height>M.leftSon.Height){
            RotateLeft(M);  
        }
        RotateRight(N);
    }

    private void AdjustHeight(treeNode<Integer> N) {
        int a=0,b=0;
        if(N.rightSon != null) a = N.rightSon.Height;
        if(N.leftSon != null) b = N.leftSon.Height;
        if(a<b) a=b;
        N.Height = 1 + a;
    }

    private void RebalanceLeft(treeNode<Integer> N) {
        treeNode<Integer> M = N.rightSon;
        if(M.leftSon.Height>M.rightSon.Height){
            RotateRight(M);  
        }
        RotateLeft(N);
    }
    
    
}