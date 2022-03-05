package com.gess.example.hilt;


import dagger.Subcomponent;

@Subcomponent(modules = SubModule.class)
public interface SubComponent {

    @Subcomponent.Factory
    interface Factory {
        SubComponent create();
    }

    void inject(DaggerActivity activity);

    void inject(Dagger2Activity activity);
}
