public class Uebersetzung implements ComparableContent<Uebersetzung>{
    private String deutsch;
    private TaubischString taubisch;
    //private int taubischZahl;
    //private int iD;
    // public Uebersetzung(String pDeutsch, TaubischString pTaubisch, int pID){
    //     this.deutsch = pDeutsch;
    //     this.taubisch = pTaubisch;
    //     this.iD = pID;
    //     //this.taubischZahl = pTaubischZahl;
    // }
    public Uebersetzung(String pDeutsch, TaubischString pTaubisch){
        this.deutsch = pDeutsch;
        this.taubisch = pTaubisch;
    }
    public Uebersetzung(String pDeutsch){
        this.deutsch = pDeutsch;
    }

    public String getDeutsch(){
        return this.deutsch;
    }
    public String getTaubischString(){
        return this.taubisch.getValue();
    }
    public TaubischString getTaubischTString(){
        return this.taubisch;
    }
    // public int getID(){
    //     return this.iD;
    // }
    // public int getTaubischZahl(){
    //     return this.taubischZahl;
    // }
    @Override
    public boolean isEqual(Uebersetzung pContent) {
        return this.deutsch.equals(pContent.getDeutsch());
    }
    @Override
    public boolean isGreater(Uebersetzung pContent) {
        return this.deutsch.compareTo(pContent.getDeutsch()) > 0;
    }
    @Override
    public boolean isLess(Uebersetzung pContent) {
        return this.deutsch.compareTo(pContent.getDeutsch()) < 0;
    }



}
