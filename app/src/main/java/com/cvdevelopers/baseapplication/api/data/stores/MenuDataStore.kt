package com.cvdevelopers.baseapplication.api.data.stores

import android.app.Application
import com.cvdevelopers.baseapplication.api.models.MenuSchema
import com.cvdevelopers.baseapplication.utils.FileReader
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MenuDataStore @Inject constructor(application: Application,  fileReader: FileReader) {

    private val menuForLocationMap: HashMap<String, MenuSchema> = HashMap()
    private val publishMenus = BehaviorSubject.create<Map<String, MenuSchema>>()

    init {
        val list = application.assets.list("/")
        val menuForLocation = fileReader.loadJson( "menu/menu_location_1.json", MenuSchema::class.java)
        menuForLocationMap["1"] = menuForLocation
        publishMenus.onNext(menuForLocationMap)
    }

    fun observeMenus() = publishMenus as Observable<Map<String, MenuSchema>>
}