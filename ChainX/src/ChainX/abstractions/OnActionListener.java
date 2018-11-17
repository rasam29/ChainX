package ChainX.abstractions;

import ChainX.Chain;

public interface OnActionListener<T> {
    void onNext(T minedData, Chain nextChain);
    void onfinish(BaseState baseState);


}
