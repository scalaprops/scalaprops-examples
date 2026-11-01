package scalaprops
package quickstart

import scalaprops._

// port from http://www.scalacheck.org/

object ListTest extends Scalaprops {

  property("revAndRevIsOriginal") =
    Property.forAll { (xs: List[Int]) => xs.reverse.reverse == xs }

  property("revIsOriginal") =
    Property.forAll { (xs: List[Int]) => xs.reverse == xs }

  property("empty") =
    Property.forAll { (xs: List[Int]) => xs.isEmpty }
      .ignore("ignore a test")
}
