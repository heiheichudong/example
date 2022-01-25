package com.gess.example.rxjava;


public class ObservableMap<T,U> extends AbstractObservableWithUpStream<T,U>{


    private Function<T,U> function;

    public ObservableMap(ObservableSource<T> source, Function<T, U> function) {
        super(source);
        this.function = function;
    }

    @Override
    protected void subscribeActual(Observer<U> observer) {
        observer.onSubscribe();
        MapObserver<T,U> mapObserver = new MapObserver<>(function,observer);
        source.subscribe(mapObserver);
    }

    static class MapObserver<T,U> implements Observer<T> {

        private Function<T,U> function;
        private Observer<U> observer;

        public MapObserver(Function<T, U> function, Observer<U> observer) {
            this.function = function;
            this.observer = observer;
        }

        @Override
        public void onSubscribe() {

        }

        @Override
        public void onNext(T t) {
            U u = function.apply(t);
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
    }
}
