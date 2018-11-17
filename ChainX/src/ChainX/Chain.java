package ChainX;

/**
 * Created by R.Arabzadeh on 9/21/2018.
 */

import ChainX.abstractions.BaseState;
import ChainX.abstractions.OnActionListener;

/**
 * T is stance for input data From the Class
 * X would be OutPut
 **/
public abstract class Chain<T, X> implements OnActionListener<X> {
    private static OnFinishedListener onFinishedListener;
    private Chain nextChain;

    public static void initiateTheChain(Chain chain, OnFinishedListener onFinished) {
        onFinishedListener = onFinished;
        chain.handleResponibilities(null);

    }

    private void setNextResponsibility(Chain nextJob) {
        if (nextJob != null) {
            this.nextChain = nextJob;
        }
    }

    private void handleResponibilities(T x) {
        doYourjob(x, this);
    }

    protected abstract void doYourjob(T inputData, OnActionListener<X> onActionListener);

    @Override
    public void onNext(X minedData, Chain nextChain) {
        if (nextChain != null) {
            setNextResponsibility(nextChain);
            nextChain.handleResponibilities(minedData);
        }

    }

    @Override
    public void onfinish(BaseState baseState) {
        onFinishedListener.onfinish(baseState);
    }

}
