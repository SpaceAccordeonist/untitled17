public class Situation {
    Situation[] direction;
    String subject,text;
    int dK,dA = 0,dR;
    public Situation (String subject, String text, int variants, int dk,int da,int dr){
        this.subject=subject;
        this.text=text;
        dK=dk;
        dA=da;
        direction=new Situation[5];
    }
}