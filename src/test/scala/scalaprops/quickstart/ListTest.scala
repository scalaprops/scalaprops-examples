package scalaprops
package quickstart

import scalaprops._

object ListTest extends Scalaprops {

  val revAndRevIsOriginal =
    Property.forAll { xs: List[Int] => xs.reverse.reverse == xs }

  val revIsOriginal =
    Property.forAll { xs: List[Int] => xs.reverse == xs }

  val empty =
    Property.forAll { xs: List[Int] => xs.isEmpty }
      .ignore("ignore a test")
}
