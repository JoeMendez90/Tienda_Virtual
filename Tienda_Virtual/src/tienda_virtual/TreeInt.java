/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_virtual;

/**
 *
 * @author fanat
 */
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

/*
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//  Diego Fernando Bulla Poveda, Fabián Andrés Montes Tobar, Joe Zafir Mendez León

class treeNode <T> {
    public T key;
    public treeNode<T> father;
    public treeNode<T> leftSon;
    public treeNode<T> rightSon;
    public int Height;

    public treeNode(T key, treeNode father) {
        this.key = key;
        this.father = father;
    }
    
    
}


class TreeInt {
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
        if(N.father!=null){
            if(N.key < N.father.key){
                return N.father;
            }else{
                return RightAncestor(N.father);
            }
        }
        return null;
        
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
        if(Next(N)!=null){
            treeNode<Integer> P = Next(N).father;
            Delete(N);
            if(P!=null){
                Rebalance(P);
            }
        }
        
    }
    
    private void Delete (treeNode<Integer> N) {
        
        if(N.rightSon==null){
            if(N==raiz){
                raiz= N.leftSon;
                if(N.leftSon!=null){
                    N.leftSon.father=null;
                }
                
            }
        }else{
            treeNode<Integer> X = Next(N);
            N.key=X.key;
            if(X.rightSon!=null){
                X.father.leftSon=X.rightSon;
                X.rightSon.father=X.father;
            }
            
        }
    }
    
    private void RotateRight(treeNode<Integer> X){
        treeNode<Integer> P = X.father;
        treeNode<Integer> Y = X.leftSon;
        treeNode<Integer> B = Y.rightSon;
        Y.father=P;
        if(P!=null){
            if(P.leftSon!=null){
                if(P.leftSon.equals(Y)){
                    P.leftSon=X;
                }
            }
            if (P.rightSon != null){
                if(P.rightSon.equals(Y)){
                    P.rightSon=X;
                }
            }
        }
        X.father=Y;
        Y.rightSon=X;
        if(B!= null){
            B.father=X;
            
        }
        X.leftSon=B;
        AdjustHeight(X);
        AdjustHeight(Y);
        if(P!=null){
            AdjustHeight(P);
        }
    }
    
    private void RotateLeft(treeNode<Integer> Y){
        treeNode<Integer> P = Y.father;
        treeNode<Integer> X = Y.rightSon;
        treeNode<Integer> B = X.leftSon;
        X.father=P;
        if(P!=null){
            if(P.leftSon!=null){
                if(P.leftSon.equals(Y)){
                    P.leftSon=X;
                }
            }
            if (P.rightSon != null){
                if(P.rightSon.equals(Y)){
                    P.rightSon=X;
                }
            }
        }
        
        Y.father=X;
        X.leftSon=Y;
        if(B!= null){
            B.father=Y;
            
        }
        Y.rightSon=B;
        AdjustHeight(Y);
        AdjustHeight(X);
        if(P!=null){
            AdjustHeight(P);
        }
    }

    private void Rebalance(treeNode<Integer> N) {
        treeNode<Integer> P = N.father;
        int a=0,b=0;
        if(N.leftSon != null) a= N.leftSon.Height;
        if(N.rightSon != null) b = N.rightSon.Height;
        if(a>b+1){
            RebalanceRight(N);
        }
        if(b > a+1){
            RebalanceLeft(N);
        }
        AdjustHeight(N);
        if(P != null){
            Rebalance(P);
        }      
    }

    private void RebalanceRight(treeNode<Integer> N) {
        if(N.leftSon != null){
            treeNode<Integer> M = N.leftSon;
            int a=0,b=0;
            if(M.leftSon != null) a= M.leftSon.Height;
            if(M.rightSon != null) b = M.rightSon.Height;
            if(b>a){
                RotateLeft(M);  
            }
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
        if(N.rightSon != null){
            treeNode<Integer> M = N.rightSon;
            int a=0,b=0;
            if(M.leftSon != null) a= M.leftSon.Height;
            if(M.rightSon != null) b = M.rightSon.Height;
            if(a>b){
                RotateRight(M);  
            }
        }
        RotateLeft(N);
    }
    
    
}


class Cubiculo {
    public int tamano;
    public TreeInt casLib;
    public int cant_o;
    
    public Cubiculo(int Tam){
        tamano=Tam;
        cant_o=0;
        casLib= new TreeInt(1);
        for(int i = 2;i<=Tam;i++){
            casLib.AVLInsert(i,casLib.raiz);
        }
    }
    
    public int OcuCas(){
        int F = casLib.firstNumber().key;
        casLib.AVLDelete(casLib.firstNumber());
        cant_o++;
        return F;
    }
    
    public void LibCas(int cas){        
        casLib.AVLInsert(cas,casLib.raiz);
        cant_o=cant_o-1;
    }
        
    public double Carga(){
        return (cant_o+0.0)/tamano;
    }
    
}

class Estudiante {
    public String nombre;
    public String apellido;
    public int cedula;
    public int cubiculo;
    public int cas;
    
    public Estudiante(String name,String apel, int cel, int Cub, int casi){
        nombre=name;
        apellido=apel;
        cedula=cel;
        cubiculo=Cub;
        cas=casi;
    }
    
}

class Gym {
    public Cubiculo[] cubiculos;
    public Estudiante[] estudiantes;
    public int cantEst;
    
    public Gym(int T){
        cubiculos = new Cubiculo[T];
    }
    
    public void Est(int P){
        estudiantes = new Estudiante[P];
        cantEst=0;
    }
    
    public void comand(String order, String[] details){
        if(order.equals("ingresar")){
            comand1(details);
        }else if(order.equals("salir")){
            comand2(details);
        }
    }
    
    public void comand1(String[] details){
        String nombre = details[0];
        String apellido = details[1];
        int cedula = Integer.parseInt(details[2]);
        int cub = menorCarga();
        if(cub==-1){
            System.out.println("limite alcanzado");
            return;
        }
        int cas = cubiculos[cub].OcuCas();
        cub++;
        estudiantes[cantEst]= new Estudiante(nombre,apellido,cedula,cub,cas);
        
        System.out.println(cub+" "+cas);
        
        cantEst++;
    }
    
    public int menorCarga(){
        int a=0;
        boolean t = false;
        for(int i=0;i<cubiculos.length;i++){
            if(cubiculos[i].Carga()!=1){
                t=true;
                if(cubiculos[a].Carga()>cubiculos[i].Carga()){
                    a=i;
                }
            }
        }
        if(t){
            return a;
        }else{
            return -1;
        }
    }
    
    public void comand2(String[] details){
        String ced = details[0];
        int num = Integer.parseInt(ced);
        String name = "";
        int i = 0;
        if(estudiantes[0]==null) return;
        while (i>=0){
            if (estudiantes[i].cedula == num){
                name = estudiantes[i].nombre;
                desasignarCas(estudiantes[i].cas,estudiantes[i].cubiculo-1);
                ElimEstu(i);
                break;
            }
            i++;
        }
        System.out.println(name);
    }
    

    public void desasignarCas(int cas, int cub){
        cubiculos[cub].LibCas(cas);
    }
    
    public void ElimEstu(int ub){
        if(cantEst-1!=ub){
            estudiantes[ub]=estudiantes[cantEst-1];        
        }
        estudiantes[cantEst-1]=null;
        cantEst--;
    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(1, T+1).forEach(TItr -> {
            try {
                // Print Case Here

                System.out.println("Caso #"+ TItr + ":");

                
                
                int N = Integer.parseInt(bufferedReader.readLine().trim());

                Gym gimna = new Gym(N);
                
                List<Integer> Ki = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());
                
                for(int i = 0; i<N;i++){
                    gimna.cubiculos[i]= new Cubiculo(Ki.get(i));
                }

                int P = Integer.parseInt(bufferedReader.readLine().trim());
    
                gimna.Est(P);
                
                IntStream.range(0, P).forEach(PItr -> {
                    try {

                        List<String> comand = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                            .collect(toList());
                        
                        String[] details = new String[comand.size()-1];
                        for(int i=0;i<details.length;i++){
                            details[i]=comand.get(i+1);
                        }
                        gimna.comand(comand.get(0),details);
                        
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

*/