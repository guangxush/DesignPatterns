package facade;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class ClientServerFacade {
    private CheckWord checkWord;
    private Charge charge;
    private TypeSeting typeSeting;
    private String advertisement;

    public ClientServerFacade(String advertisement) {
        this.advertisement = advertisement;
        checkWord = new CheckWord(advertisement);
        charge = new Charge(checkWord);
        typeSeting = new TypeSeting(advertisement);
    }

    public void doAdversitisement(){
        checkWord.setChargeAmount();
        charge.giveCharge();
        typeSeting.typeSeting();
    }
}
