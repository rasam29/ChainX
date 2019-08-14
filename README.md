# ChainX

MAKE CHAIN OF RESPONSIBILITY GREAT AGAIN

Do a set of Task in Easy Way
Its Just A LinkList With Benefits.

# Example

// void is stance for the input data to The chan
// String would be output of the chain
```java
    public class TestChain extends Chain<Void, String> {

    @Override
    protected void doYourjob(Void inputData, OnActionListener<String> onActionListener) {
        // has been retrieved some how;
        //DataBase , Network , etc.....
        String name = "Rasam Arabzadeh"; 
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

        
  # Building the Chains
  
        //initiateChain will take the first chain of event
        //and another callback for onFinish
        
      Chain.initiateTheChain(new TestChain(), baseState -> {
            System.out.println(baseState instanceof NameQueriedState);
        });
```
   # UnitTests
   _you can easily test each chain seperatly because both onNext and onFinish takes polymorphic objects
   




