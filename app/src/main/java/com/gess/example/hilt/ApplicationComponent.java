package com.gess.example.hilt;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetModule.class,SubComponentModule.class})
public interface ApplicationComponent {

//    void inject(DaggerActivity activity);

    SubComponent.Factory subFactory();
}
