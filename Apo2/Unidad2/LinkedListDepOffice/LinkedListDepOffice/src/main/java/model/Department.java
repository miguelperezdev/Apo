package model;

public class Department {

    private Office firstOffice;
    private int totalOffices;


    public Department(){
        this.firstOffice = null;
    }

    public void addOffice(String code, int floor) {
        Office newOffice = new Office(code, floor);
        //caso base
        if (firstOffice == null) {
            firstOffice = newOffice;
            totalOffices++;
        //caso iterativo
        } else {
            Office current = firstOffice;
            while(current.getNextOffice()!=null){
                current = current.getNextOffice();
            }
            current.setNextOffice(newOffice);
            totalOffices++;
        }
    }

    public Office searchOffice(String code){
        Office current = firstOffice;
        while(current!=null){
            if(current.getCode().equals(code)){
                return current;
            }
            current = current.getNextOffice();
        }
        return null;
    }

    public void removeOffice(String code){
        //caso base
        if(firstOffice.getCode().equals(code)){
            Office temp = firstOffice.getNextOffice();
            firstOffice = temp;
        }
        //caso iterativo
        else{
            Office current = firstOffice;
            while(current!=null){
                if (current.getNextOffice() != null) {
                    if(current.getNextOffice().getCode().equals(code)){
                        Office temp = current.getNextOffice().getNextOffice();
                        current.setNextOffice(temp);
                    }
                }
                current = current.getNextOffice();
            }
        }
    }

    public void sortByCode(){
        int i, j;
        boolean swapped;
        Office temp;
        Office current = firstOffice;
        for (i = 0; i < totalOffices; i++) {
            swapped = false;
            for (j = 0; j < totalOffices - i - 1; j++) {
                if (current.compareTo(current.getNextOffice()) == 1) {
                    temp = current;
                    current = current.getNextOffice();
                    current.setNextOffice(temp);
                    swapped = true;
                }
            }
            current = current.getNextOffice();
        }
    }

    public void removeEvenFloor(){

    }
}
