import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

object Parser {
    var gson: Gson = Gson();

    fun parseGrid() {
        val file = File("../resources/grid.json")
    }
}
