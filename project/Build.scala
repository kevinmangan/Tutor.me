import sbt._
import Keys._
import play.Project._
import de.johoop.jacoco4sbt.JacocoPlugin._
 

object ApplicationBuild extends Build {

  val appName         = "TutorMe"
  val appVersion      = "1.0-SNAPSHOT"

  lazy val s = Defaults.defaultSettings ++ Seq(jacoco.settings:_*)

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    "com.typesafe" %% "play-plugins-mailer" % "2.1.0",
    "mysql" % "mysql-connector-java" % "5.1.18",
    "com.feth"	%%  "play-authenticate" % "0.2.0-SNAPSHOT",
    "play" %% "play-test" % play.core.PlayVersion.current % "test" exclude("com.novocode", "junit-interface"),
    "com.novocode" % "junit-interface" % "0.9" % "test"
  )

  val main = play.Project(appName, appVersion, appDependencies, settings = s).settings(
    // Add your own project settings here
      parallelExecution in jacoco.Config := false,
	  
      resolvers += Resolver.url("play-easymail (release)", url("http://joscha.github.com/play-easymail/repo/releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("play-easymail (snapshot)", url("http://joscha.github.com/play-easymail/repo/snapshots/"))(Resolver.ivyStylePatterns),


      resolvers += Resolver.url("play-authenticate (release)", url("http://joscha.github.com/play-authenticate/repo/releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("play-authenticate (snapshot)", url("http://joscha.github.com/play-authenticate/repo/snapshots/"))(Resolver.ivyStylePatterns)
  )

}
