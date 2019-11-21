package tienda_virtual;

/**
 * La clase BigActions guarda una accion grande (el nombre del panel central normalmente)
 * y un stack de pequeñas acciones. esto sirve para saber retroceder entre partes cuando 
 * cambias entre grandes saber cual fue tu ultimo paso pequeño
 * tiene un booleano add que funciona como marcador, 
 * si lo ultimo que se hizo fue adicionar algo es verdadera,y se veulve falsa al sacar algo
 * 
 * @author fanat
 */
public class BigActions {
    private String bigAction;
    private Stack<String> smallActions;
    private boolean add;

    /**
     * inicia la gran accion con su nombre, inicia el stack 
     * @param bigAction  nombre de la gran accion
     */
    
    public BigActions(String bigAction) {
        this.bigAction = bigAction;
        smallActions = new Stack<>();
        BigIn();
        if(bigAction.contains("Search")){
            smallActions.Push("set|0");
        }
        
    }
    
    private void BigIn(){
        smallActions.Push("0");
        add=true;
    }
    /**
     * inicia la gran accion con su nombre, inicia el stack y le añade la primera accion
     * @param bigAction  nombre de la gran accion
     * @param firstAction primera accion
     */
    
    public BigActions(String bigAction,String firstAction) {
        this.bigAction = bigAction;
        smallActions = new Stack<>();
        smallActions.Push(firstAction);
    }
    /**
     * get gran action
     * @return bigAction
     */
    
    public String getBigAction(){
        return bigAction;
    }
    
    /**
     * retorna el pico de la pila y elimina este 
     * @return el pico de la pila
     */
    
    public String getLastAction(){
        String last;
        if(!add){
             last = smallActions.Peek();
            smallActions.Pop();
        }else{
            smallActions.Pop();
            last = smallActions.Peek();
            smallActions.Pop();
            add=false;
        }
        
        return last;
    }
    
    /**
     * 
     * @return  ultima accion pequeña sin quitarla de la lista.
     */
    
    public String getLastActionNoPop(){
        String last = smallActions.Peek();
        return last;
    }
    
    /**
     * añade una ´pequeña accion
     * @param hey action a añadir
     */
    
    public void addAction(String hey){
        smallActions.Push(hey);
        add=true;
    }
    
    /**
     * revisa si el string recbido es igual a el pico de la pila
     * @param news action a revisar
     * @return es igual a la pila?
     * 
     */
    
    public boolean repeatS(String news){
        return news.equals(smallActions.Peek());
    }
    
    /**
     * revisa si el string resivido es igual a la gran accion
     * @param news string a comparar
     * @return es igual a la gran action?
     */
    public boolean repeatB(String news){
        return news.equals(bigAction);
    }
    
    /** 
     * revisa si la pila esta vacia, o solo tiene la accion por defecto
     * @return longitud igual a 1 o lista vacia;
     */
    
    public boolean isFirst(){
        if(add){
            return smallActions.length<=2||smallActions.isEmpty();
        }else{
            return smallActions.length==1||smallActions.isEmpty();
        }
    }
    
    /**
     * esta vacia las acciones pequeñas?
     * @return esta vacio?
     */
    
    public boolean isEmpty(){
        return smallActions.isEmpty();
    }
}
