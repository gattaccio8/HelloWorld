import sbt._
import Keys._

object HelloWorldInAmazon extends Build {
  import scala.collection._
  import Dependency._
  import Resolvers._
  import BuildSettings._

  lazy val root = Project(id = "HelloWorldInAmazon", base = file("."), settings = standardBuildSettings ++ Seq(
  resolvers := Seq(jettyRepo, resolver, Classpaths.typesafeResolver),
  libraryDependencies ++= jetty ++ scalaTest
  ))
}

object BuildSettings {
  val standardBuildSettings: Seq[sbt.Project.Setting[_]] = Defaults.defaultSettings ++ Seq[Setting[_]](
      organization := "HelloWorldInAmazon",     //TODO these 3 lines are ignored here and picked from build.sbt instead
      version := "1.0",
      scalaVersion := "2.10.4"
  )
}

object Resolvers {
  val jettyRepo = "jetty repo" at "http://siasia.github.com/maven2"
  val resolver = "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
}


object Dependency {

  val jettyVersion = "7.5.4.v20111024"
//  val seleniumVersion = "2.6.0"
//  val scalaTestVersion = "2.1.0"

  val jetty = Seq (
      "org.eclipse.jetty" % "jetty-server" % "9.2.2.v20140723",
      "org.eclipse.jetty" % "jetty-webapp" % "9.2.2.v20140723"
    )

  val scalaTest = Seq("org.scalatest" % "scalatest_2.10" % "2.0" % "test")
}
