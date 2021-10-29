import com.google.gson.annotations.SerializedName

data class Grid(@SerializedName("cells") val cells: Array<Array<Cell>>) {

    init {
    }

    companion object {

        fun printGrid(grid: Array<Array<Int>>) {
            for (i in 0..19) {
                print("___")
            }
            println()
            grid.cells.let {
                for (row in grid.cells) {
                    for (c in row) {
                        print(c)
                    }
                    println("|")
                }
            }
            println()
        }
    }





    fun updateCellsLife() {}
}