package com.example.TreesAndGraph

//Input: userSongs = {
//    "David": ["song1", "song2", "song3", "song4", "song8"],
//    "Emma":  ["song5", "song6", "song7"]
//},
//songGenres = {
//    "Rock":    ["song1", "song3"],
//    "Dubstep": ["song7"],
//    "Techno":  ["song2", "song4"],
//    "Pop":     ["song5", "song6"],
//    "Jazz":    ["song8", "song9"]
//}
//Output: {
//    "David": ["Rock", "Techno"],
//    "Emma":  ["Pop"]
//}
//Explanation:
//David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
//Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
//https://leetcode.com/discuss/interview-question/373006

//class Favorite_Genres_Amazon {
    fun main(args: Array<String>) {
        var userMap = mapOf("David" to arrayOf("song1", "song2", "song3", "song4", "song8"),
              "Emma" to arrayOf("song5", "song6", "song7"))

        var genreMap = mapOf("Rock" to arrayOf("song1", "song3"),
              "Dubstep" to arrayOf("song7"),
              "Techno" to arrayOf("song2", "song4"),
              "Pop" to arrayOf("song5", "song6"),
              "Jazz" to arrayOf("song8", "song9"))
      var result = favoritegenre(userMap,  genreMap)
    }

   // mapping of song to genre
   // user to genre[song] count
   // user to max count
   // res[user] genre
fun favoritegenreTest(userMap: Map<String, Array<String>>, genreMap: Map<String, Array<String>>): Map<String, MutableList<String?>>? {
   var songToGenreMap: HashMap<String, String>  = HashMap()
   for (genre in genreMap.keys) {
       var songs = genreMap.get(genre)
       if (songs == null) continue
       for (song in songs) {
           songToGenreMap.put(song, genre)
       }
   }
   var countMap:HashMap<String, Int>
   var res = HashMap<String, MutableList<String?>>()
   var max = 0
   for (user in userMap.keys) {
       var userSongs = userMap.get(user)
       if (userSongs == null) continue
       countMap = HashMap()
       max = 0
       for (song in userSongs) {
          var genre = songToGenreMap.get(song)
          if (genre == null) continue
           countMap.put(genre, countMap.getOrDefault(genre, 0).plus(1))
           max = Math.max(max, countMap.get(genre)!!)
       }

       for (genre in countMap.keys) {
           if (max == countMap.get(genre)) {
               res.putIfAbsent(user, mutableListOf())
               res[user]?.add(genre)
           }
       }
   }
   return res
}

    fun favoritegenre(userMap: Map<String, Array<String>>, genreMap: Map<String, Array<String>>): Map<String, MutableList<String?>>? {
        val res: MutableMap<String, MutableList<String?>> = HashMap()
        val songstogenre: MutableMap<String?, String?> = HashMap()
        for (genre in genreMap.keys) {
            val songs = genreMap[genre]!!
            for (song in songs) {
                songstogenre[song] = genre
            }
        }
        var count: MutableMap<String?, Int>
        var max = 0
        for (user in userMap.keys) {
            count = HashMap()
            max = 0
            res[user] = ArrayList()
            val songs = userMap[user]!!
            for (song in songs) {
                val genre = songstogenre[song]
                val c = count.getOrDefault(genre, 0) + 1
                count[genre] = c
                max = Math.max(c, max)
            }
            for (key in count.keys) {
                if (count[key] == max) {
                    res[user]!!.add(key)
                }
            }
        }
        return res
    }
//}