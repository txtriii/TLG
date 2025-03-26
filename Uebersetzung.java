public class Uebersetzung extends ComparableContent{
    private String deutsch;
    private String taubisch;
    public Uebersetzung(String pDeutsch, String pTaubisch){
        this.deutsch = pDeutsch;
        this.taubisch = pTaubisch;
    }
    public String getDeutsch(){
        return deutsch;
    }
    public String getTaubisch(){
        return taubisch;
    }
}
