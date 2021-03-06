/* NSC -- new Scala compiler
 * Copyright 2005-2012 LAMP/EPFL
 * @author  Martin Odersky
 */

package scala.reflect
package base

/**
 * Defines the type hierachy for compile-time constants.
 *
 * @see [[scala.reflect]] for a description on how the class hierarchy is encoded here.
 */
trait Constants {
  self: Universe =>

  /** The type of compile-time constants.
   */
  type Constant >: Null <: AnyRef

  /** A tag that preserves the identity of the `Constant` abstract type from erasure.
   *  Can be used for pattern matching, instance tests, serialization and likes.
   */
  implicit val ConstantTag: ClassTag[Constant]

  /** The constructor/deconstructor for `Constant` instances. */
  val Constant: ConstantExtractor

  /** An extractor class to create and pattern match with syntax `Constant(value)`
   *  where `value` is the Scala value of the constant.
   */
  abstract class ConstantExtractor {
    def apply(value: Any): Constant
    def unapply(arg: Constant): Option[Any]
  }
}
