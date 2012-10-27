import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "lsug"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "org.mongodb" % "casbah_2.9.0" % "2.4.1",
      "ca.juliusdavies" % "not-yet-commons-ssl" % "0.3.9"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here      
    )

}
