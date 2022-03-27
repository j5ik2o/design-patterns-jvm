/* (C) 2022 */
package s.flyweight

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import scala.jdk.CollectionConverters._

class BigChar(charname: Char) {

  private val fontData: String =
    try {
      val filename = "data/" + "big" + charname + ".txt"
      val sb = new StringBuilder
      for (line <- Files.readAllLines(Path.of(filename)).asScala) {
        sb.append(line)
        sb.append("\n")
      }
      sb.toString
    } catch {
      case _: IOException => charname + "?"
    }

  def print(): Unit = {
    scala.Predef.print(fontData)
  }
}
