package info.androidhive.listviewfeed.data;

/**
 * Created by Umme on 03-Mar-17.
 */

public class AddCard {
    public String cardtype;
    public String cardnumber;
    public String nameoncard;
    public String expirydate;
    public String cvvnumber;

    public AddCard(String cardtype,String cardnumber,String nameoncard,String expirydate,String cvvnumber){
        this.cardnumber=cardnumber;
        this.cardtype=cardtype;
        this.nameoncard=nameoncard;
        this.expirydate=expirydate;
        this.cvvnumber=cvvnumber;
    }

}
