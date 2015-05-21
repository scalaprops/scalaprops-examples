package scalaprops
package examples

import scalaprops._
import Property.{property, implies, prop}

object PropertyExample extends Scalaprops {

  val makeList = property { n: Int =>
    implies(n >= 0 && n < 10000, prop(List.fill(n)("").length == n))
  }

  val trivial = property { n: Int => Bool.bool(n == 0).implies(n == 0) }
}
