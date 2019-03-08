package scalaprops
package examples

import scalaprops._
import Gen._

// port from https://github.com/rickynils/scalacheck/wiki/User-Guide

object ShrinkExample extends Scalaprops {

  def shrinkTuple2[T1, T2](implicit T1: Shrink[T1], T2: Shrink[T2]): Shrink[(T1, T2)] =
    Shrink.shrink { case (t1, t2) => T1(t1) zip T2(t2) }

  val origShrink = Property.forall0(Gen.tuple2[Int, Int], shrinkTuple2[Int, Int]) { case (t1, t2) =>
    Property.prop(t1 >= t2)
  }
}
