package scalaprops
package examples

// port from https://github.com/rickynils/scalacheck/wiki/User-Guide

object ShrinkExample extends Scalaprops {

  val origShrink = Property.property{ (t1: Int, t2: Int) =>
    Property.prop(t1 >= t2)
  }

}
