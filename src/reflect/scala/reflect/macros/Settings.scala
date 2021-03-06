package scala.reflect
package macros

trait Settings {
  self: Context =>

  /** Exposes macro-specific settings as a list of strings.
   *  These settings are passed to the compiler via the "-Xmacro-settings:setting1,setting2...,settingN" command-line option.
   */
  def settings: List[String]

  /** Exposes current compiler settings as a list of options.
   *  Use `scalac -help`, `scalac -X` and `scalac -Y` to learn about currently supported options.
   */
  def compilerSettings: List[String]

  /** Updates current compiler settings with an option string.
   *  Use `scalac -help`, `scalac -X` and `scalac -Y` to learn about currently supported options.
   */
  def setCompilerSettings(options: String): this.type

  /** Updates current compiler settings with a list of options.
   *  Use `scalac -help`, `scalac -X` and `scalac -Y` to learn about currently supported options.
   */
  def setCompilerSettings(options: List[String]): this.type

  /** Temporarily sets compiler settings to a given option string and executes a given closure.
   *  Use `scalac -help`, `scalac -X` and `scalac -Y` to learn about currently supported options.
   */
  def withCompilerSettings[T](options: String)(op: => T): T

  /** Temporarily sets compiler settings to a given list of options and executes a given closure.
   *  Use `scalac -help`, `scalac -X` and `scalac -Y` to learn about currently supported options.
   */
  def withCompilerSettings[T](options: List[String])(op: => T): T
}