@file:JvmName(name = "Model")
package nl.group9.app

import com.google.inject.Singleton
import tornadofx.ItemViewModel
import tornadofx.getProperty
import tornadofx.property

/**
 * Created by ronsmi on 12/14/2016.
 */

@Singleton class Model() {
    val activeModel = PersonModel()
}

class Person (firstname : String, lastname : String) {
    var lastname by property<String>(lastname)
    fun lastnameProperty() = getProperty(Person::lastname)
    var firstname by property<String>(firstname)
    fun firstnameProperty() = getProperty(Person::firstname)
}

class PersonModel : ItemViewModel<Person>() {
    val lastname = bind { item?.lastnameProperty() }
    val firstname = bind { item?.firstnameProperty() }
}

