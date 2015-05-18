package scalaprops
package examples

import scalaprops._
import Property.property

object PropertyExample extends Scalaprops {

  val makeList = property { n: Int =>
    Bool.bool(n >= 0 && n < 10000).implies(List.fill(n)("").length == n)
  }

  val trivial = property { n: Int => Bool.bool(n == 0).implies(n == 0) }
}
