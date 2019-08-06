package in.iceberg.myavenger.application;

import android.app.Application;

import in.iceberg.myavenger.component.AvengerApiComponent;
import in.iceberg.myavenger.component.DaggerAvengerApiComponent;
import in.iceberg.myavenger.module.AvengerApiModule;
import in.iceberg.myavenger.module.AvengerAppModule;

public class AvengerApplication extends Application {

    private AvengerApiComponent avengerApiComponent;

    @Override
    public void onCreate(){
        super.onCreate();
        avengerApiComponent = DaggerAvengerApiComponent.builder()
                .avengerAppModule(new AvengerAppModule(this))
                .avengerApiModule(new AvengerApiModule("https://simplifiedcoding.net/demos/"))
                .build();
    }

    public AvengerApiComponent getAvengerComponent() {
        return avengerApiComponent;
    }
}
