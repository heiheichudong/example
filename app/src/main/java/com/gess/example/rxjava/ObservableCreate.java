package com.gess.example.rxjava;

public class ObservableCreate<T> extends Observable<T>{

    private final ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }

    @Override
    public void subscribeActual(Observer<T> observer) {
        observer.onSubscribe();
        CreateEmitter<T> emitter = new CreateEmitter<>(observer);
        source.subscribe(emitter);
    }

    static class CreateEmitter<T> implements Emitter<T>{
        private Observer<T> observer;
        private boolean done;

        public CreateEmitter(Observer<T> observer) {
            this.observer = observer;
        }

        @Override
        public void onNext(T t) {
            if (done) return;
            this.observer.onNext(t);
        }

        @Override
        public void onComplete() {
            if (!done)
                this.observer.onComplete();
            done = true;
        }

        @Override
        public void onError(Throwable t) {
            if (!done)
                this.observer.onError(t);
            done = true;
        }
    }

}
