data class Cell(var isAlive: Int, var hasToChange: Boolean = false) {

    override fun toString(): String = if (isAlive==1) " * " else "   "
}