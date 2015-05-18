package scalaprops
package examples

import scalaprops._

object GenExample extends Scalaprops {

  val genSmallInt = Gen.choose(0, 100)

  val smallInt = Property.forAllG(genSmallInt)((n: Int) => n >= 0 && n <= 100)
}
