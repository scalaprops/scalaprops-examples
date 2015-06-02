package scalaprops
package examples

import scalaprops._
import scalaz._

// port from https://github.com/rickynils/scalacheck/wiki/User-Guide

object GenExample extends Scalaprops {

  val genSmallInt = Gen.choose(0, 100)

  val smallInt = Property.forAllG(genSmallInt)((n: Int) => n >= 0 && n <= 100)

  val myGen = for {
    n <- Gen.choose(10, 20)
    m <- Gen.choose(2 * n, 500)
  } yield (n, m)

  val oneOfChar = Gen.oneOf(Gen.value('A'), List('E', 'I', 'O', 'U', 'Y').map(Gen.value(_)) :_*)
  val freqChar = Gen.frequency(
    (3, Gen.value('A')),
    (4, Gen.value('E')),
    (2, Gen.value('I')),
    (3, Gen.value('O')),
    (1, Gen.value('U')),
    (1, Gen.value('Y'))
  )

  sealed abstract class Tree[A]
  final case class Node[A](left: Tree[A], value: A, right: Tree[A]) extends Tree[A]
  final case class Leaf[A]() extends Tree[A]

  def genLeaf[A]: Gen[Tree[A]] = Gen.value(Leaf())

  def genNode[A: Gen]: Gen[Tree[A]] = for {
    left <- genTree[A]
    value <- Gen[A]
    right <- genTree[A]
  } yield Node(left, value, right)

  def genTree[A: Gen]: Gen[Tree[A]] = Gen.oneOf(genLeaf, genNode)

  def matrix[T](g: Gen[T]): Gen[IList[IList[T]]] = Gen.sized { size =>
    val side = scala.math.sqrt(size).asInstanceOf[Int]
    Gen.listOf(Gen.listOf(g, side), side)
  }

  lazy val smallEvenInteger: Gen[Int] =
    Gen.choose(0, 200).flatMap(i => if(i % 2 == 0) Gen.value(i) else smallEvenInteger)

  val squares = Gen.genIntAll.map(x => x * x)
}
