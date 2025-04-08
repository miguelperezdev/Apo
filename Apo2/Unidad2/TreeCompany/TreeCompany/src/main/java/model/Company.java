package model;

public class Company {

    private String name;
    private Employee root;

    public Company(String name) {
        this.name = name;
        addIte("5","juan",5);
        addIte("3","jose",3);
        addIte("6","isabella",6);
        addIte("1","andres",1);
        addIte("4","edward",4);
    }

    public String getName() {
        return name;
    }
    public Employee getRoot() {
        return root;
    }

    public void add(String id, String name, int off){
        Employee emp = new Employee(id, name, off);
        add(root, emp);
    }

    private void add(Employee currentRoot, Employee newEmp){
        //Caso base
        if(currentRoot == null){
            root = newEmp;
        }
        else{
            //Caso recursivo 1: El nuevo nodo es menor
            if(currentRoot.compareTo(newEmp)==1){
                if(currentRoot.getLeft()==null){
                    currentRoot.setLeft(newEmp);
                    newEmp.setParent(currentRoot);
                }
                else{
                    add(currentRoot.getLeft(),newEmp);
                }
            }
            //Caso recursivo 2: El nuevo nodo es mayor
            else if(currentRoot.compareTo(newEmp)==-1){
                if(currentRoot.getRight()==null){
                    currentRoot.setRight(newEmp);
                    newEmp.setParent(currentRoot);
                }
                else{
                    add(currentRoot.getRight(),newEmp);
                }
            }
        }
    }

    public void addIte(String id, String name, int off){
        Employee newEmp = new Employee(id, name, off);
        //Caso base
        if(root == null){
            root = newEmp;
        }
        else{

            Employee currentRoot = root;
            boolean added = false;
            while(currentRoot!=null && !added) {
                //Caso Iterativo 1: El nuevo nodo es menor
                if (currentRoot.compareTo(newEmp) == 1) {
                    if (currentRoot.getLeft() == null) {
                        currentRoot.setLeft(newEmp);
                        newEmp.setParent(currentRoot);
                        added=true;
                    }
                    currentRoot = currentRoot.getLeft();
                    //Caso Iterativo 2: El nuevo nodo es mayor
                } else if (currentRoot.compareTo(newEmp) == -1) {
                    if (currentRoot.getRight() == null) {
                        currentRoot.setRight(newEmp);
                        newEmp.setParent(currentRoot);
                        added=true;
                    }
                    currentRoot = currentRoot.getRight();
                }
            }
        }
    }

    public Employee search(String ident){
        return search(ident, root);
    }

    public Employee search(String ident, Employee currentRoot) {
        // Caso base 1: nodo no encontrado
        if(currentRoot == null) {
            return null;
        }
        // Caso base 2: nodo encontrado
        if(currentRoot.getId().equals(ident)) {
            return currentRoot;
        }
        // Caso recursivo 1: buscar en subárbol izquierdo
        if(currentRoot.getId().compareTo(ident) > 0) {
            return search(ident, currentRoot.getLeft());
        }
        // Caso recursivo 2: buscar en subárbol derecho
        else {
            return search(ident, currentRoot.getRight());
        }
    }

    public Employee searchIterative(String ident) {
        Employee current = root;
        while(current != null) {
            if(current.getId().equals(ident)) {
                return current;
            } else if(current.getId().compareTo(ident) > 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null; // No encontrado
    }
    public Employee minimum() {
        return minimum(root);
    }

    private Employee minimum(Employee currentRoot) {
        if(currentRoot == null) return null;
        if(currentRoot.getLeft() == null) return currentRoot;
        return minimum(currentRoot.getLeft());
    }

    public Employee minimumIterative() {
        if(root == null) return null;
        Employee current = root;
        while(current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public Employee maximum() {
        return maximum(root);
    }

    private Employee maximum(Employee currentRoot) {
        if(currentRoot == null) return null;
        if(currentRoot.getRight() == null) return currentRoot;
        return maximum(currentRoot.getRight());
    }

    public Employee maximumIterative() {
        if(root == null) return null;
        Employee current = root;
        while(current.getRight() != null) {
            current = current.getRight();
        }
        return current;
    }

    public Employee remove(String ident) {
        Employee empRem = search(ident);
        if(empRem != null) {
            remove(empRem);
        }
        return empRem;
    }

    private void remove(Employee empRem) {
        // Caso 1: Nodo hoja
        if(empRem.getLeft() == null && empRem.getRight() == null) {
            if(empRem.getParent() == null) {
                root = null; // Era el único nodo
            } else {
                if(empRem.getParent().getLeft() == empRem) {
                    empRem.getParent().setLeft(null);
                } else {
                    empRem.getParent().setRight(null);
                }
            }
        }
        // Caso 2: Tiene solo hijo izquierdo
        else if(empRem.getRight() == null) {
            if(empRem.getParent() == null) {
                root = empRem.getLeft();
                root.setParent(null);
            } else {
                if(empRem.getParent().getLeft() == empRem) {
                    empRem.getParent().setLeft(empRem.getLeft());
                } else {
                    empRem.getParent().setRight(empRem.getLeft());
                }
                empRem.getLeft().setParent(empRem.getParent());
            }
        }
        // Caso 3: Tiene solo hijo derecho
        else if(empRem.getLeft() == null) {
            if(empRem.getParent() == null) {
                root = empRem.getRight();
                root.setParent(null);
            } else {
                if(empRem.getParent().getLeft() == empRem) {
                    empRem.getParent().setLeft(empRem.getRight());
                } else {
                    empRem.getParent().setRight(empRem.getRight());
                }
                empRem.getRight().setParent(empRem.getParent());
            }
        }
        // Caso 4: Tiene ambos hijos
        else {
            Employee successor = minimum(empRem.getRight());
            // Copiar los datos del sucesor
            empRem.setId(successor.getId());
            empRem.setName(successor.getName());
            empRem.setOffice(successor.getOffice());
            // Eliminar el sucesor (que será un caso 1 o 2)
            remove(successor);
        }
    }

    public int weight() {
        return weight(root);
    }

    private int weight(Employee currentRoot) {
        if(currentRoot == null) {
            return 0;
        }
        return 1 + Math.max(weight(currentRoot.getLeft()), weight(currentRoot.getRight()));
    }

}
