package MovieDetail_TestNG.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MovieContents {
    WebDriver driver;
    String urlImdb = "https://www.imdb.com/title/tt9389998";
    String urlWiki = "https://en.wikipedia.org/wiki";

    public MovieContents(WebDriver driver){
        this.driver = driver;

    }
    
    public void NavigateToIMDBPage(){
        if(!this.driver.getCurrentUrl().equals(this.urlImdb)){
            this.driver.get(this.urlImdb);
        }
    }

    public void NavigateToWikiPage(){
        if(!this.driver.getCurrentUrl().equals(this.urlWiki)){
            this.driver.get(this.urlWiki);
        }
    }

    public boolean SearchMovieInImdbSite(String movieName){
       try{
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='suggestion-search']"));
        searchBox.clear();
        searchBox.sendKeys(movieName);
        WebElement searchClick = driver.findElement(By.xpath("//div[@class='sc-d2740ffb-1 duOqOv']"));
        searchClick.click();
        return true;
       }
       catch(Exception ex){
        System.out.println("Error while searching for movie name"+ex.getMessage());
        return false;
       }
       
    }


   public boolean verifyMovieDetailIMDB(String releaseDateLbl,String releaseDateTxt,String countryOfOriginLbl,String CountryOriginTxt){
       //TODO: Validate details of movie 
     try{
       WebElement releaseDateLabel = driver.findElement(By.xpath("//a[text()='Release date']"));
       WebElement releaseDate = driver.findElement(By.xpath("//li[@data-testid='title-details-releasedate']//child::div"));
       WebElement countryOfOriginLabel = driver.findElement(By.xpath("//*[text()='Country of origin']"));
       WebElement countryOfOrigin = driver.findElement(By.xpath("//li[@data-testid='title-details-origin']//child::div"));

      if(releaseDateLabel.getText().equals(releaseDateLbl) && releaseDate.getText().equals(releaseDateTxt) ){
        System.out.println(releaseDateLabel.getText()+" : "+releaseDate.getText());
      }
      if(countryOfOriginLabel.getText().equals(countryOfOriginLbl) && countryOfOrigin.getText().equals(CountryOriginTxt)){
        System.out.println(countryOfOriginLabel.getText()+" : "+countryOfOrigin.getText());
      }
      return true;
     }catch(Exception e){
        System.out.println("movie contents is not found"+e.getMessage());
        return false;
     }
}

public boolean SearchMovieInWikipediaSite(String movieName){
  try{
      WebElement searchBox = driver.findElement(By.xpath("//input[@name='search']"));
      searchBox.clear();
      searchBox.sendKeys(movieName);
      WebElement searchClick = driver.findElement(By.xpath("(//div[@class='suggestions-results']//a)[1]"));
      searchClick.click();
     
  }catch(Exception e){
      System.out.println("Error while searching for movie"+e.getMessage());
      return false;
  }
  return true;
 }

 public boolean verifyMovieDetailWiki(String releaseDateLbl,String releaseDateTxt,String countryOfOriginLbl,String countryOfOriginTxt){
    try{
      WebElement releaseDateLabel = driver.findElement(By.xpath("//div[text()='Release date']"));
      WebElement releaseDate = driver.findElement(By.xpath("//div[text()='Release date']//parent::th//following-sibling::td[@class='infobox-data']//li"));
      System.out.println("hello........."+releaseDateLabel.getText());
      WebElement countryOfOriginLabel = driver.findElement(By.xpath("//th[text()='Country']"));
      WebElement countryOfOrigin = driver.findElement(By.xpath("//th[text()='Country']//following-sibling::td"));
      if(releaseDateLabel.getText().equals(releaseDateLbl) && releaseDate.getText().equals(releaseDateTxt)){
          System.out.println(releaseDateLabel.getText()+":"+releaseDate.getText());
      }
      if( countryOfOriginLabel.getText().equals(countryOfOriginLbl) && countryOfOrigin.getText().equals(countryOfOriginTxt)){
          System.out.println( countryOfOriginLabel.getText()+" : "+countryOfOrigin.getText());
      }
      return true;
    }
     catch(Exception e){
      System.out.println("movie contents not found"+e.getMessage());
      return false;
     }

 }
}