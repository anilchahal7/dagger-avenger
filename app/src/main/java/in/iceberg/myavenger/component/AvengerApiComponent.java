package in.iceberg.myavenger.component;

import javax.inject.Singleton;

import dagger.Component;
import in.iceberg.myavenger.activity.MainActivity;
import in.iceberg.myavenger.module.AvengerApiModule;
import in.iceberg.myavenger.module.AvengerAppModule;

@Singleton
@Component(modules = {AvengerAppModule.class, AvengerApiModule.class})
public interface AvengerApiComponent {
    void inject(MainActivity mainActivity);
}
