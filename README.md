# ChainX
MAKE CHAIN OF RESPONSIBILITY GREAT AGAIN

Do a set of Task in Easy Way
# Example
public class TestChain extends Chain<Void, String> {


    @Override
    protected void doYourjob(Void inputData, OnActionListener<String> onActionListener) {
        String name = "Rasam Arabzadeh"; // has been retrieved some how;
        onActionListener.onNext(name,new Test2Chain());
    }
}




public class Test2Chain extends Chain<String,Void> {

    @Override
    protected void doYourjob(String inputData, OnActionListener<Void> onActionListener) {
        System.out.println("Hello my Name is "+inputData);
        onActionListener.onfinish(new NameQueriedState(inputData));
    }
}


      Chain.initiateTheChain(new TestChain(), baseState -> {
            System.out.println(baseState instanceof NameQueriedState);
        });




