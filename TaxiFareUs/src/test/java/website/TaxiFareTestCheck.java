package website;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import taxifareApi.TaxiFareBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;


public class TaxiFareTestCheck extends TaxiFareBase{


    @Test
    public void taxifareHomePage()throws InterruptedException, IOException{
        System.out.println(driver.getCurrentUrl());
//      //  typeAndEnterByCss("#countrySelect", "book");
//       // sleepFor(4);
//        List<String> list = getListOfTextByCss("#countrySelect option");
//        displayText(list);
//        // List<WebElement> bookNavBar = getWebElements("#nav-subnav .nav-a");
//        for(int i=1; i<list.size(); i++){
//           clickByText(list.get(i));
//            sleepFor(2);
//        }
//        sleepFor(5);
        String title = driver.getTitle();
        System.out.println("The Title of The website is (TaxiFareTestCheck) : " + title);

        setItems(TaxiFareTestCheck.list);
        getItems();
        List<String> listCountry = searchDropDownMenu("#countrySelect option");
        Assert.assertEquals(listCountry, TaxiFareBase.menu);
        System.out.println("\n\n Total Countries-----"+ listCountry.size());
        displayText(listCountry);
//        for(String item: listMenu){
//            typeAndEnterByCss("#twotabsearchtextbox", item);
//            sleepFor(4);
//        }

//             List<String> listCity = searchDropDownMenu("#cityselect option");
//             displayText(listCity);
//             Thread.sleep(2000);
        System.out.println("----- finsh Countries Count-------" );



           // for (int i = 0; i< listCountry.size(); i++ ){
            for (int i = 0; i< 5; i++ ){


            new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listCountry.get(i));

            //    System.out.println("\n-----Country Calculation-----"+ listCountry.get(i)+ " Total City"+listUSACity.size() );

            if(i== 0) {
                List<String> listUSACity = searchDropDownMenu("#cityselect option");

                System.out.println("\n -> Country : "+ listCountry.get(i)+ " Total Cities :"+listUSACity.size() );

                displayText(listUSACity);
                Thread.sleep(2000);
                //  new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));



                //  new Select(driver.findElement(By.id("countrySelect"))).selectByValue('"'+listMenu.get(0)+'"');
                // .selectByVisibleText("United States of America");

                //  for (int j = 0; j < listUSACity.size(); j++) {
                for (int j = 0; j < 5; j++) {
                    if(j>0){
                        System.out.println("\n City:-->  "+listUSACity.get(j)  );

                        new Select(driver.findElement(By.id("cityselect"))).selectByVisibleText(listUSACity.get(j));

                        // new Select(driver.findElement(By.xpath(".//*[@id='cityselect']"))).selectByVisibleText(listCity.get(7));
                        //  new Select(driver.findElement(By.id("#cityselect")).selectByVisibleText();


                        driver.findElement(By.id("fromAddress")).clear();
                        driver.findElement(By.id("fromAddress")).sendKeys("1000, 5th ave, ny");

                        // new Select(driver.findElement(By.id("toDirectory"))).selectByVisibleText("1900 5th Ave, New York, NY 10065");
                        driver.findElement(By.id("toAddress")).clear();
                        driver.findElement(By.id("toAddress")).sendKeys("1900 5th Ave, New York, NY 10065");
                        driver.findElement(By.name("submit")).click();
                        Thread.sleep(2000);


                        //------------------------------------------

                        WebElement select = driver.findElement(By.id("fromDirectory"));
                        List<WebElement> options = select.findElements(By.tagName("option"));
                        for (WebElement option : options) {
                            // if(select.getAttribute("value") != "") {
                            //         System.out.println(select.getAttribute("value"));

                            //  System.out.println( option.getText() + " ----- GetAttribute-----"+ " "+"  " + select.getAttribute("value"));
                            System.out.print(option.getText());
                            //   System.out.println(select.getAttribute("value"));
//                  if ("Upper West Side (85th & Amst)".equals(option.getText()))
//                      System.out.print(option.getText());

//                          if(option.getLocation().equals(1)){
//                              System.out.print("");
//
//                          }
                            //  option.click();
                            // }


                        }



                    }

                    else {

                        System.out.println(driver.getCurrentUrl());
                        String title0 = driver.getTitle();
                        System.out.println("The Title of The web is " + title0);
                    }
                }
                Thread.sleep(2000);
            }
            else if(i==1){
                List<String> listFRCity = searchDropDownMenu("#cityselect option");
                System.out.println("\n -> Country : "+ listCountry.get(i)+ " | Total Cities :"+listFRCity.size() +"\n");
                displayText(listFRCity);
                Thread.sleep(2000);

                //    new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));



                //  new Select(driver.findElement(By.id("countrySelect"))).selectByValue('"'+listMenu.get(0)+'"');
                // .selectByVisibleText("United States of America");

                for (int j = 0; j < listFRCity.size(); j++) {
                    if(j>0){
                        System.out.println(" City : ->"+ listFRCity.get(j)  );

                        new Select(driver.findElement(By.id("cityselect"))).selectByVisibleText(listFRCity.get(j));

                        // new Select(driver.findElement(By.xpath(".//*[@id='cityselect']"))).selectByVisibleText(listCity.get(7));
                        //  new Select(driver.findElement(By.id("#cityselect")).selectByVisibleText();


                        driver.findElement(By.id("fromAddress")).clear();
                        driver.findElement(By.id("fromAddress")).sendKeys("1000, 5th ave, ny");

                        // new Select(driver.findElement(By.id("toDirectory"))).selectByVisibleText("1900 5th Ave, New York, NY 10065");
                        driver.findElement(By.id("toAddress")).clear();
                        driver.findElement(By.id("toAddress")).sendKeys("1900 5th Ave, New York, NY 10065");
                        driver.findElement(By.name("submit")).click();
                        Thread.sleep(2000);
                    }

                    else {

                        System.out.println(driver.getCurrentUrl());
                        String title1 = driver.getTitle();
                        System.out.println("The Title of The web is " + title1);
                    }
                }
                Thread.sleep(2000);

            }
            else if(i==2){

                List<String> listJPCity = searchDropDownMenu("#cityselect option");

                System.out.println("\n -> Country : "+ listCountry.get(i)+ " Total Cities :"+listJPCity.size() );

                displayText(listJPCity);
                Thread.sleep(2000);

                //     new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));


                //  new Select(driver.findElement(By.id("countrySelect"))).selectByValue('"'+listMenu.get(0)+'"');
                // .selectByVisibleText("United States of America");

                for (int j = 0; j < listJPCity.size(); j++) {
                    if(j>0){

                        System.out.println(" City: -->"+ listJPCity.get(j));
                        new Select(driver.findElement(By.id("cityselect"))).selectByVisibleText(listJPCity.get(j));

                        // new Select(driver.findElement(By.xpath(".//*[@id='cityselect']"))).selectByVisibleText(listCity.get(7));
                        //  new Select(driver.findElement(By.id("#cityselect")).selectByVisibleText();


                        driver.findElement(By.id("fromAddress")).clear();
                        driver.findElement(By.id("fromAddress")).sendKeys("1000, 5th ave, ny");

                        // new Select(driver.findElement(By.id("toDirectory"))).selectByVisibleText("1900 5th Ave, New York, NY 10065");
                        driver.findElement(By.id("toAddress")).clear();
                        driver.findElement(By.id("toAddress")).sendKeys("1900 5th Ave, New York, NY 10065");
                        driver.findElement(By.name("submit")).click();
                        Thread.sleep(2000);

                        //--------------------------------------------

//                        Select period = new Select(driver.findElement(By.id("fromDirectory")));
//
//                        period.selectByVisibleText("LaGuardia Airport");
//
//                        String value = period.getFirstSelectedOption().getAttribute("value");
//
//                        System.out.println("\n \n ----------------------"+ value +"---------------------");
                        //----------------------------------------------
                    }

                    else {

                        System.out.println(driver.getCurrentUrl());
                        String title2 = driver.getTitle();
                        System.out.println("The Title of The web is " + title2);
                    }
                }
                Thread.sleep(2000);

            }
            else if(i==3){
                List<String> listUAECity = searchDropDownMenu("#cityselect option");
                System.out.println("\n -> Country : "+ listCountry.get(i)+ " Total Cities :"+listUAECity.size() );

                displayText(listUAECity);
                Thread.sleep(2000);

                //     new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));


                //  new Select(driver.findElement(By.id("countrySelect"))).selectByValue('"'+listMenu.get(0)+'"');
                // .selectByVisibleText("United States of America");

                for (int j = 0; j < listUAECity.size(); j++) {
                    if(j>0){
                        System.out.println("City: ->" + listUAECity.get(j) );

                        new Select(driver.findElement(By.id("cityselect"))).selectByVisibleText(listUAECity.get(j));

                        // new Select(driver.findElement(By.xpath(".//*[@id='cityselect']"))).selectByVisibleText(listCity.get(7));
                        //  new Select(driver.findElement(By.id("#cityselect")).selectByVisibleText();


                        driver.findElement(By.id("fromAddress")).clear();
                        driver.findElement(By.id("fromAddress")).sendKeys("1000, 5th ave, ny");

                        // new Select(driver.findElement(By.id("toDirectory"))).selectByVisibleText("1900 5th Ave, New York, NY 10065");
                        driver.findElement(By.id("toAddress")).clear();
                        driver.findElement(By.id("toAddress")).sendKeys("1900 5th Ave, New York, NY 10065");
                        driver.findElement(By.name("submit")).click();
                        Thread.sleep(2000);
                    }
                    else {

                        System.out.println(driver.getCurrentUrl());
                        String title3 = driver.getTitle();
                        System.out.println("The Title of The web is " + title3);
                    }
                }
                Thread.sleep(2000);

            }
            else if(i==4){
                List<String> listUKCity = searchDropDownMenu("#cityselect option");
                System.out.println("\n -> Country : "+ listCountry.get(i)+ " Total Cities :"+listUKCity.size() );

                displayText(listUKCity);
                Thread.sleep(2000);

                //    new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));


                //  new Select(driver.findElement(By.id("countrySelect"))).selectByValue('"'+listMenu.get(0)+'"');
                // .selectByVisibleText("United States of America");

                for (int j = 0; j < listUKCity.size(); j++) {
                    if (j > 0) {

                        System.out.println(" City: -->" + listUKCity.get(j) );

                        new Select(driver.findElement(By.id("cityselect"))).selectByVisibleText(listUKCity.get(j));

                        // new Select(driver.findElement(By.xpath(".//*[@id='cityselect']"))).selectByVisibleText(listCity.get(7));
                        //  new Select(driver.findElement(By.id("#cityselect")).selectByVisibleText();


                        driver.findElement(By.id("fromAddress")).clear();
                        driver.findElement(By.id("fromAddress")).sendKeys("1000, 5th ave, ny");

                        // new Select(driver.findElement(By.id("toDirectory"))).selectByVisibleText("1900 5th Ave, New York, NY 10065");
                        driver.findElement(By.id("toAddress")).clear();
                        driver.findElement(By.id("toAddress")).sendKeys("1900 5th Ave, New York, NY 10065");
                        driver.findElement(By.name("submit")).click();
                        Thread.sleep(2000);
                    } else {

                        System.out.println(driver.getCurrentUrl());
                        String title4 = driver.getTitle();
                        System.out.println("The Title of The web is " + title4);
                    }
                }
                Thread.sleep(2000);

            }

            else if(i== 5) {
                List<String> listUSACity5 = searchDropDownMenu("#cityselect option");

                System.out.println("\n -> Country : "+ listCountry.get(i)+ " Total Cities :"+listUSACity5.size() );

                displayText(listUSACity5);
                Thread.sleep(2000);
                //  new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));



                //  new Select(driver.findElement(By.id("countrySelect"))).selectByValue('"'+listMenu.get(0)+'"');
                // .selectByVisibleText("United States of America");

                //  for (int j = 0; j < listUSACity.size(); j++) {
                for (int j = 0; j < 5; j++) {
                    if(j>0){
                        System.out.println("\n City:-->  "+listUSACity5.get(j)  );

                        new Select(driver.findElement(By.id("cityselect"))).selectByVisibleText(listUSACity5.get(j));

                        // new Select(driver.findElement(By.xpath(".//*[@id='cityselect']"))).selectByVisibleText(listCity.get(7));
                        //  new Select(driver.findElement(By.id("#cityselect")).selectByVisibleText();


                        driver.findElement(By.id("fromAddress")).clear();
                        driver.findElement(By.id("fromAddress")).sendKeys("1000, 5th ave, ny");

                        // new Select(driver.findElement(By.id("toDirectory"))).selectByVisibleText("1900 5th Ave, New York, NY 10065");
                        driver.findElement(By.id("toAddress")).clear();
                        driver.findElement(By.id("toAddress")).sendKeys("1900 5th Ave, New York, NY 10065");
                        driver.findElement(By.name("submit")).click();
                        Thread.sleep(2000);


                        //------------------------------------------

                        WebElement select = driver.findElement(By.id("fromDirectory"));
                        List<WebElement> options = select.findElements(By.tagName("option"));
                        for (WebElement option : options) {
                            // if(select.getAttribute("value") != "") {
                            //         System.out.println(select.getAttribute("value"));

                            //  System.out.println( option.getText() + " ----- GetAttribute-----"+ " "+"  " + select.getAttribute("value"));
                            System.out.print(option.getText());
                            //   System.out.println(select.getAttribute("value"));
//                  if ("Upper West Side (85th & Amst)".equals(option.getText()))
//                      System.out.print(option.getText());

//                          if(option.getLocation().equals(1)){
//                              System.out.print("");
//
//                          }
                            //  option.click();
                            // }


                        }



                    }

                    else {

                        System.out.println(driver.getCurrentUrl());
                        String title0 = driver.getTitle();
                        System.out.println("The Title of The web is " + title0);
                    }
                }
                Thread.sleep(2000);
            }




//            new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i+1));
//
//
//                //  new Select(driver.findElement(By.id("countrySelect"))).selectByValue('"'+listMenu.get(0)+'"');
//                // .selectByVisibleText("United States of America");
//
//                for (int j = 0; j < listAmeCity.size(); j++) {
//                    if(j>0){
//                    new Select(driver.findElement(By.id("cityselect"))).selectByVisibleText(listCity.get(j));
//
//                    // new Select(driver.findElement(By.xpath(".//*[@id='cityselect']"))).selectByVisibleText(listCity.get(7));
//                    //  new Select(driver.findElement(By.id("#cityselect")).selectByVisibleText();
//
//
//                    driver.findElement(By.id("fromAddress")).clear();
//                    driver.findElement(By.id("fromAddress")).sendKeys("1000, 5th ave, ny");
//
//                    // new Select(driver.findElement(By.id("toDirectory"))).selectByVisibleText("1900 5th Ave, New York, NY 10065");
//                    driver.findElement(By.id("toAddress")).clear();
//                    driver.findElement(By.id("toAddress")).sendKeys("1900 5th Ave, New York, NY 10065");
//                    driver.findElement(By.name("submit")).click();
//                    Thread.sleep(2000);
//               }
//
//                    else System.out.print(" Start calculation");
//            }
//             Thread.sleep(2000);
        }

        Thread.sleep(2000);

//        List<String> listCity = searchDropDownMenu("#cityselect option");
//        displayText(listCity);
//        Thread.sleep(2000);


//        List<String> listFromDirectory = searchDropDownMenu("#fromDirectory option[value]");
//        displayText(listFromDirectory);
//        Thread.sleep(2000);

        System.out.println("----------------------- first-----------------------");
//        Select archiveList = new Select(driver.findElement(By.id("fromDirectory")));
//        archiveList.selectByVisibleText("LaGuardia Airport");
//        String selectedValue = archiveList.getFirstSelectedOption().getText();
//        System.out.print(selectedValue + " This is the text");

        System.out.println("///////////////// last//////////////////////////");

//        WebElement select = driver.findElement(By.id("fromDirectory"));
//        List<WebElement> options = select.findElements(By.tagName("option"));
//        for (WebElement option : options) {
//           // if(select.getAttribute("value") != "") {
//
//                //  System.out.println(option.getText() + " ----- GetAttribute-----" + select.getAttribute("value"));
//
//              System.out.println(select.getAttribute("value"));
//                  if ("Upper West Side (85th & Amst)".equals(option.getText()))
//                      System.out.print(option.getText());
//                  option.click();
//                  // }
//
//        }

   /*
        Select period = new Select(driver.findElement(By.id("fromDirectory")));

        period.selectByVisibleText("LaGuardia Airport");

        String value = period.getFirstSelectedOption().getAttribute("value");

        System.out.println("\n \n ----------------------"+ value +"---------------------");
        */

    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
