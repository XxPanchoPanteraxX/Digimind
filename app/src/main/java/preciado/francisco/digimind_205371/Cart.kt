package preciado.francisco.digimind_205371

import java.io.Serializable

class Cart : Serializable{
    var reminders = ArrayList<Reminder>()

    fun add(r:Reminder): Boolean {
        return reminders.add(r)
    }
}