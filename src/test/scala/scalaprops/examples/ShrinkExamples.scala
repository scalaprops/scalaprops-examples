package scalaprops
package examples

import scalaprops._
import Gen._
import scalaz._
import scalaz.std.stream._

object ShrinkExample extends Scalaprops {

  def shrinkTuple2[T1, T2](implicit T1: Shrink[T1], T2: Shrink[T2]): Shrink[(T1, T2)] =
    Shrink.shrink { case (t1, t2) => Apply[Stream].tuple2(T1(t1), T2(t2)) }

  val origShrink = Property.forall0(Gen.tuple2[Int, Int], shrinkTuple2[Int, Int]) { case (t1, t2) =>
    Property.prop(t1 >= t2)
  }
}
