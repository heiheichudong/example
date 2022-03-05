package com.gess.example.hilt;

import dagger.Module;
import dagger.Provides;

@Module
public class SubModule {

    @Provides
    SubBean getSubBean(){
        return new SubBean();
    }


}
