import java.util.concurrent.TimeUnit

fun main() {

    val cells = arrayOf(
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    )

    val grid = Grid(cells)

    for (i in 0..29) {
        Grid.printGrid(cells)
        development(grid.cells)
        grid.updateCellsLife()
        TimeUnit.SECONDS.sleep(1)
    }
}


    fun development(cells: Array<Array<Cell>>){
        val length = 20
        val width = 20
        var tmp = 0
        var tmp2 = 0
        var neighbourAlive=0
        for(i in 0..length){
            for(j in 0..width){
                neighbourAlive=0
                if(cells[(i+1)%length][j].isAlive==1) neighbourAlive++
                if(cells[i][(j+1)%width].isAlive==1) neighbourAlive++
                if(cells[(i+1)%length][(j+1)%width].isAlive==1) neighbourAlive++

                if(i==0){
                    tmp = length-1
                    tmp2 = width - 1
                } else{
                    tmp = i-1
                    tmp2= j-1
                }

                if(cells[ tmp ][j].isAlive==1) neighbourAlive++
                if(cells[ tmp ][(j+1)%width].isAlive==1) neighbourAlive++


                if(cells[i][tmp2].isAlive==1) neighbourAlive++
                if(cells[(i+1)%length][tmp2].isAlive==1) neighbourAlive++
                if(cells[tmp][tmp2].isAlive==1) neighbourAlive++

                if(cells[i][j].isAlive==1){
                    if(neighbourAlive!=2 && neighbourAlive!=3) cells[i][j].hasToChange = !cells[i][j].hasToChange
                }else{
                    if(neighbourAlive==3) cells[i][j].hasToChange = !cells[i][j].hasToChange
                }

            }
        }
    }