fun main() {
    println("=== StudentApp ===")
    println("Type 'quit' for the name to exit.\n")

    // Continuous input loop until the user types "quit" for the name
    while (true) {
        // 1) Read name; using 'quit' ends the program
        print("Enter student name: ")
        val name = readLine()?.trim().orEmpty()
        if (name.equals("quit", ignoreCase = true)) {
            println("Goodbye!")
            break
        }

        // 2) Read remaining fields as plain strings
        print("Enter student ID: ")
        val id = readLine()?.trim().orEmpty()

        print("Enter student course: ")
        val course = readLine()?.trim().orEmpty()

        // 3) Read mark as Double with a tiny validation loop
        var mark: Double? = null
        while (mark == null) {
            print("Enter student mark (e.g. 72.5): ")
            // toDoubleOrNull() returns null on invalid input instead of crashing
            mark = readLine()?.trim()?.toDoubleOrNull()
            if (mark == null) println("Please enter a valid number.")
        }

        // 4) Build the data object and show a friendly summary
        val s = Student(id = id, name = name, course = course, mark = mark)
        // Student.toString() is overridden to show name, course, and mark only
        println("Created -> $s\n")
    }
}
