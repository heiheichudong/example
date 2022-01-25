package com.gess.example.rxjava;

public class ObservableFlatMap<T,U> extends AbstractObservableWithUpStream<T,U> {

    private Function<T,ObservableSource<U>> function;

    public ObservableFlatMap(ObservableSource<T> source, Function<T, ObservableSource<U>> function) {
        super(source);
        this.function = function;
    }

    @Override
    protected void subscribeActual(Observer<U> observer) {
        observer.onSubscribe();
        FlatMapObserver<T,U> flatMapObserver = new FlatMapObserver<>(function,observer);
        source.subscribe(flatMapObserver);
    }

    static class FlatMapObserver<T,U> implements Observer<T>{

        private Function<T,ObservableSource<U>> function;
        private Observer observer;

        public FlatMapObserver(Function<T, ObservableSource<U>> function, Observer observer) {
            this.function = function;
            this.observer = observer;
        }

        @Override
        public void onSubscribe() {

        }

        @Override
        public void onNext(T t) {
            ObservableSource<U> observableSource = function.apply(t);
            observableSource.subscribe(new Observer<U>() {
                @Override
                public void onSubscribe() {

                }

                @Override
                public void onNext(U u) {
                    observer.onNext(u);
                }

                @Override
                public void onComplete() {
                    observer.onComplete();
                }

                @Override
                public void onError(Throwable t) {
                    observer.onError(t);
                }
            });
        }

        @Override
        public void onComplete() {

        }

        @Override
        public void onError(Throwable t) {

        }
    }
}
