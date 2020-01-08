package mediator;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class ConcreteMediator {
    ColleagueA colleagueA;
    ColleagueB colleagueB;
    ColleagueC colleagueC;

    public void registerColleagueA(ColleagueA colleagueA){
        this.colleagueA = colleagueA;
    }

    public void registerColleagueB(ColleagueB colleagueB){
        this.colleagueB = colleagueB;
    }

    public void registerColleagueC(ColleagueC colleagueC){
        this.colleagueC = colleagueC;
    }

    public void deliverMess(Colleague colleague, String[] mess){
        if(colleague == colleagueA){
            if(mess.length >= 2){
                colleagueB.receiverMess(colleague.getName()+mess[0]);
                colleagueC.receiverMess(colleague.getName()+mess[1]);
            }
        }else if(colleague == colleagueB){
            if(mess.length >= 2){
                colleagueA.receiverMess(colleague.getName()+mess[0]);
                colleagueC.receiverMess(colleague.getName()+mess[1]);
            }
        }else if(colleague == colleagueC){
            if(mess.length >= 2){
                colleagueA.receiverMess(colleague.getName()+mess[0]);
                colleagueB.receiverMess(colleague.getName()+mess[1]);
            }
        }
    }
}
