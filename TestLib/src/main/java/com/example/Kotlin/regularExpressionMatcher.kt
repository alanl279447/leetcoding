package com.example.Kotlin

var stack12: MutableList<Char> = mutableListOf()

fun main (args: Array<String>) {
    matchPattern("book".toRegex(RegexOption.IGNORE_CASE), mutableListOf("book", "gbhsf", "writebook", "bookTest"))
    patternFind("fox".toRegex(), "I saw a fox in the wood. The fox had red fur.")

    val content = """
Foxes are omnivorous mammals belonging to several genera
of the family Canidae. Foxes have a flattened skull, upright triangular ears,
a pointed, slightly upturned snout, and a long bushy tail. Foxes live on every
continent except Antarctica. By far the most common and widespread species of
fox is the red fox."""
    matchWords("\\w+".toRegex(), content)
}

 fun matchWords(pattern: Regex, content: String) {

     val words = pattern.findAll(content)
     val counts = words.count()

     println("total count is $counts")
     words.forEach {
         println(it.value)
         println(it.range)
     }
 }

 fun patternFind(pattern: Regex, input: String) {
      var match = pattern.find(input)
      val idx = match?.range
     println("${match?.value} found at indexes: $idx")
 }

 fun matchPattern(pattern: Regex, lists: MutableList<String>) {
     lists.forEach {
         if (pattern.matches(it)) {
           System.out.println("Exact match $it")
         }
         if (pattern.containsMatchIn(it)) {
             System.out.println("Contains match $it")
         }
     }
 }