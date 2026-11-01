package scalaprops
package examples

import scalaprops._
import scalaprops.Property.{implies, prop}

// port from https://github.com/rickynils/scalacheck/wiki/User-Guide

object PropertyExample extends Scalaprops {

  property("makeList") = Property.property { (n: Int) =>
    implies(n >= 0 && n < 10000, prop(List.fill(n)("").length == n))
  }

  property("trivial") = Property.property { (n: Int) => Bool.bool(n == 0).implies(n == 0) }
}
