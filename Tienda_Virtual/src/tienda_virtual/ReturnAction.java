package tienda_virtual;

/**
 * La clase ReturnAction genera la lista de acciones anteriores por medio de una pila de acciones grandes
 * @author fanat
 */
public class ReturnAction {
    private Stack<BigActions> Actions;

    /**
     * el constructor crea el stack de grandes acciones y genera una que es la de por busqueda por defecto;
     */
    
    public ReturnAction() {
        Actions = new Stack<>();
        Actions.Push(new BigActions("Search|"));
    }
    
    /**.
     *  la funcion Action busca entre las grandes acciones, si esta vacia o la actual era la ultima, 
     * manda a salir, en caso e ser la primera gran accion pero no ser la ultima de sus pequeñas acciones pone la ultima,
     * en el caso de ser cualquier otra gran accion si esta tiene una o ninguna acccion pequeña accion se borra manda una 
     * accion de crear la anterior gran accion y luego realiza su ultima pequeña accion, en totro caso simplemente realiza 
     * la ultima pequeña accion de la ultima gran accion
     * @return  action anterior por la que cambiar
     */
    
    public String Action(){
        if(Actions.isEmpty()){
            return "out";
        }else if(Actions.length==1){
            if(Actions.Peek().isFirst()){
                return "out";
            }
            String Action = Actions.Peek().getLastAction();
            return "Center|"+Action;
        }
        if(Actions.Peek().isFirst()){
            Actions.Pop();
            return Actions.Peek().getBigAction()+"|Center|"+Actions.Peek().getLastAction();
            
        }else{
            String Action = Actions.Peek().getLastAction();
            return "Center|"+Action;
        }
    }
    
    /**
     * la funcion addAction agrega una accion nueva, si esta pertenece al panel central (contiene la orden "Center")
     * revisa entre las acciones del ultimo gran action para que no sea la misma (aunque en algunos casos esto se revisa
     * antes de mandarlo, puede haber casos que no), si no es la ultima qpequña accion pues la agrega, en el caso de no ser 
     * una accion para el panel central, revisa que no sea la misma que la ultima gran accion, si lo es agrega una accion 
     * pequeña por defecto para la gran accion, si es otra la crea como una nueva gran accion y la agrega a la pila
     * @param action action a añadir
     */
    
    public void addAction(String action){
        if(action.contains("Center|")){
            String actionSub = action.substring(7);
            if(!Actions.Peek().repeatS(actionSub)){
                Actions.Peek().addAction(actionSub);
                System.out.println("subActionAdd");
                return;
            }
            System.out.println("subActionRepeat");
        }else if(Actions.Peek().repeatB(action)){
            Actions.Peek().addAction("");
            System.out.println("BigActionIn");
        }else{
            BigActions newBig = new BigActions(action);
            Actions.Push(newBig);
            System.out.println("NewBigAction");
        }
    }
    
}
