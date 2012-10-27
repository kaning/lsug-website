package models
import play.api.libs.concurrent.Promise
import play.api.libs.ws.Response
import play.api.libs.ws.WS
import play.api.libs.json.Json
import play.api.libs.json.JsValue
import play.api.libs.json.JsArray

object Repo {
  def getRepos() : List[Repo] = List(Repo("lsug-dojo/lsug-website",
       "https://api.github.com/repos/lsug-dojo/lsug-website",
       "2012-10-27T09:50:36Z"))
       
  def getReposRawJson() = {
    val result: Promise[Response] = WS.url("https://api.github.com/orgs/lsug-dojo/repos").get()
      
    val asJson = result.map { response => repoJson(response.body) }
    
  }
    
  def repoJson(entireJson: String) : List[String] = {
    val json: JsValue = Json.parse(entireJson)
    
    val repoNames:Seq[JsValue] = (json \\ "full_name")
    val repoUrls:Seq[JsValue] = (json \\ "git_url")
    val createAt:Seq[JsValue] = (json \\ "created_at")
    
    val valuesAsJs = (repoNames, repoUrls, createAt).zipped.toList
    
    valuesAsJs.map { each => println("Zipped: " + each) }
    
    List("done")
  }
  
}

case class Repo(fullName: String, url: String, createdAt: String) { }
