package preciado.francisco.digimind_205371

import java.io.Serializable

data class Reminder (
    var days : String,
    var time : String,
    var name : String
): Serializable