package com.cvdevelopers.baseapplication.dependencyinjection.modules;

import com.cvdevelopers.checklist.utils.poweradapter.adapter.RecyclerDataSource;
import com.cvdevelopers.checklist.utils.poweradapter.item.ItemRenderer;
import com.cvdevelopers.checklist.utils.poweradapter.item.RecyclerItem;
import dagger.Module;
import dagger.Provides;

import java.util.Map;

@Module
public class RecyclerDataSourceModule {

    @Provides
    static RecyclerDataSource provideDataSource(Map<String, ItemRenderer<? extends RecyclerItem>> map) {
        return new RecyclerDataSource(map);
    }
}
