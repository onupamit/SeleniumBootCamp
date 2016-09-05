package website;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import taxifareApi.TaxiFareBase;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class TaxiFareTestDropDown extends TaxiFareBase {


    @Test
    public void taxifareHomePage() throws InterruptedException, IOException {
        try {
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
            System.out.println("The Title of The web is (TaxiFareTestDropDown)" + title);

            setItems(TaxiFareTestDropDown.list);
            getItems();
            List<String> listMenu = searchDropDownMenu("#countrySelect option");
            Assert.assertEquals(listMenu, TaxiFareBase.menu);
            displayText(listMenu);
//        for(String item: listMenu){
//            typeAndEnterByCss("#twotabsearchtextbox", item);
//            sleepFor(4);
//        }

//             List<String> listCity = searchDropDownMenu("#cityselect option");
//             displayText(listCity);
//             Thread.sleep(2000);


            System.out.println("\n\n ---listMenu.size()-----" + listMenu.size());

            for (int i = 0; i < listMenu.size()-1; i++) {

//                new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));


                if (i == 0) {
                    new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));
                    List<String> listUSACity = searchDropDownMenu("#cityselect option");
                    displayText(listUSACity);
                    //   Thread.sleep(2000);
                    //  new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));


                    //  new Select(driver.findElement(By.id("countrySelect"))).selectByValue('"'+listMenu.get(0)+'"');
                    // .selectByVisibleText("United States of America");

                    //  for (int j = 0; j < listUSACity.size(); j++) {   // real
                    for (int j = 0; j < 2; j++) {     // only for test
                        if (j > 0) {
                            new Select(driver.findElement(By.id("cityselect"))).selectByVisibleText(listUSACity.get(j));

                            // new Select(driver.findElement(By.xpath(".//*[@id='cityselect']"))).selectByVisibleText(listCity.get(7));
                            //  new Select(driver.findElement(By.id("#cityselect")).selectByVisibleText();


                            driver.findElement(By.id("fromAddress")).clear();
                            driver.findElement(By.id("fromAddress")).sendKeys("1000, 5th ave, ny");

                            // new Select(driver.findElement(By.id("toDirectory"))).selectByVisibleText("1900 5th Ave, New York, NY 10065");
                            driver.findElement(By.id("toAddress")).clear();
                            driver.findElement(By.id("toAddress")).sendKeys("1900 5th Ave, New York, NY 10065");
                            driver.findElement(By.name("submit")).click();
                            Thread.sleep(1000);

                            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                            //The below method will save the screen shot in d drive with name "screenshot.png"
                            FileUtils.copyFile(scrFile, new File("/Users/shamimchy/Documents/screenshot/screenshot_" + (i + 1) + "_" + j + "_a.png"));


                            Thread.sleep(2000);

                            //

                            String from = "";
                            String to = "";

                            //----------------------------- FRom Directory---------------
                            int index = 0;
                            WebElement select1 = driver.findElement(By.id("fromDirectory"));
                            List<WebElement> options = select1.findElements(By.tagName("option"));
                            for (WebElement option : options) {
                                // if(select.getAttribute("value") != "") {
                                //         System.out.println(select.getAttribute("value"));
                                index++;

                                if (index == 3) {
                                    //  System.out.println(" First Enter" + option.getText());
                                    //   driver.findElement(By.id("fromAddress")).clear();
                                    //  driver.findElement(By.id("fromAddress")).sendKeys(select.getAttribute("value"));
                                    //  Thread.sleep(2000);
                                    // option.click();
                                    //  from = select1.getAttribute("value");
                                    from = option.getText();
                                    System.out.println(" Before Conver Select_enter  FRom : " + from);


                                }
                                if (index == 5) {
                                    System.out.println(" Select From  : " + option.getText());
                                    driver.findElement(By.id("fromAddress")).clear();
                                    //  driver.findElement(By.id("fromAddress")).sendKeys(select.getAttribute("value"));
                                    //  Thread.sleep(2000);
                                    option.click();


                                }


                                //  System.out.println( option.getText() + " ----- GetAttribute-----" + select.getAttribute("value"));System.out.print(option.getText());
                                //     System.out.println(select.getAttribute("value"));
//                  if ("Upper West Side (85th & Amst)".equals(option.getText()))
//                      System.out.print(option.getText());

//                          if(option.getLocation().equals(1)){
//                              System.out.print("");
//
//                          }
//                  option.click();
                                // }

                            }

                            //-------------------------------------- toDirectory-------------------------------------------


                            int indexTo = 0;
                            WebElement selectTo = driver.findElement(By.id("toDirectory"));
                            List<WebElement> optionsTo = selectTo.findElements(By.tagName("option"));
                            for (WebElement optionTo : optionsTo) {
                                // if(select.getAttribute("value") != "") {
                                //         System.out.println(select.getAttribute("value"));
                                indexTo++;


                                if (indexTo == 4) {
//                                System.out.print("Second Enter : " + optionTo.getText());
//                                driver.findElement(By.id("toAddress")).clear();
//                                 driver.findElement(By.id("toAddress")).sendKeys(select.getAttribute("value"));
//                              //  optionTo.click();
//
//                                driver.findElement(By.name("submit")).click();
//
//                                Thread.sleep(2000);
                                    // to = selectTo.getAttribute("value");
                                    to = optionTo.getText();
                                    System.out.println(" Before Convert Select_Enter to : " + to);

                                }

                                if (indexTo == 6) {
                                    System.out.println(" Select to : " + optionTo.getText());
                                    driver.findElement(By.id("toAddress")).clear();
                                    // driver.findElement(By.id("toAddress")).sendKeys(select.getAttribute("value"));
                                    optionTo.click();

                                    driver.findElement(By.name("submit")).click();

                                    File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                    //The below method will save the screen shot in d drive with name "screenshot.png"
                                    FileUtils.copyFile(scrFile1, new File("/Users/shamimchy/Documents/screenshot/screenshot_" + (i + 1) + "_" + j + "_b.png"));


                                    Thread.sleep(2000);

                                    Thread.sleep(1000);

                                }

                                Thread.sleep(1000);
                                //  System.out.println( option.getText() + " ----- GetAttribute-----" + select.getAttribute("value"));System.out.print(option.getText());
                                //       System.out.println(select.getAttribute("value"));
//                  if ("Upper West Side (85th & Amst)".equals(option.getText()))
//                      System.out.print(option.getText());

//                          if(option.getLocation().equals(1)){
//                              System.out.print("");
//
//                          }
//                  option.click();
                                // }

                            }

                            //-------------------------------------------------------------------------------------------


                            driver.findElement(By.id("fromAddress")).clear();
                            //  searchDropDownMenu("#fromDirectory option").isEmpty();

//                        Select droplist = new Select(driver.findElement(By.id("fromDirectory")));
//                        // .Id("selection")));
//                        droplist.selectByVisibleText("-- Select An Address --");
//
//
//                        driver.findElement(By.id("fromAddress")).sendKeys(from);
//                        System.out.println(" From--> "+ from);
//                        Thread.sleep(1000);

                            // new Select(driver.findElement(By.id("toDirectory"))).selectByVisibleText("1900 5th Ave, New York, NY 10065");
                            driver.findElement(By.id("toAddress")).clear();

                            // searchDropDownMenu("#toDirectory option").isEmpty();

//                        Select droplist1 = new Select(driver.findElement(By.id("toDirectory")));
//                        // .Id("selection")));
//                        droplist1.selectByVisibleText("-- Select An Address --");
//
//                        driver.findElement(By.id("toAddress")).sendKeys(to);
//                        System.out.println(" to---> " + to);
//                        Thread.sleep(1000);


//                        driver.findElement(By.name("submit")).click();
//                        Thread.sleep(4000);


                            //-------------------


                            Select first = new Select(driver.findElement(By.id("fromDirectory")));

                            first.selectByVisibleText(from);

                            String value = first.getFirstSelectedOption().getAttribute("value");
                            System.out.println("Enter_Select From : " + value);


                            Select droplist = new Select(driver.findElement(By.id("fromDirectory")));
                            // .Id("selection")));
                            droplist.selectByVisibleText("-- Select An Address --");


                            driver.findElement(By.id("fromAddress")).sendKeys(value);

                            Thread.sleep(1000);


                            //------------------------------

                            Select second = new Select(driver.findElement(By.id("toDirectory")));

                            second.selectByVisibleText(to);

                            String valueSecond = second.getFirstSelectedOption().getAttribute("value");
                            System.out.println("Enter_Select To : " + valueSecond);


                            Select droplist1 = new Select(driver.findElement(By.id("toDirectory")));
                            // .Id("selection")));
                            droplist1.selectByVisibleText("-- Select An Address --");

                            driver.findElement(By.id("toAddress")).sendKeys(valueSecond);

                            Thread.sleep(1000);

                            driver.findElement(By.name("submit")).click();
                            Thread.sleep(2000);

                            File scrFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                            //The below method will save the screen shot in d drive with name "screenshot.png"
                            FileUtils.copyFile(scrFile2, new File("/Users/shamimchy/Documents/screenshot/screenshot_" + (i + 1) + "_" + j + "_c.png"));


                            Thread.sleep(2000);


                        }

//                    else {
//                        System.out.println(" Start calculation");
//                        String title1 = driver.getTitle();
//                        System.out.println("The Title of The web is " + title1);
//                    }
                    }
                    Thread.sleep(2000);
                } else if (i == 1) {
                    new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));
                    List<String> listFRCity = searchDropDownMenu("#cityselect option");
                    displayText(listFRCity);
                    //   Thread.sleep(2000);

                    //    new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));


                    //  new Select(driver.findElement(By.id("countrySelect"))).selectByValue('"'+listMenu.get(0)+'"');
                    // .selectByVisibleText("United States of America");

                    for (int j = 0; j < listFRCity.size(); j++) {
                        if (j > 0) {
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
                        } else {
                            System.out.println(" Start calculation");
                            String title2 = driver.getTitle();
                            System.out.println("The Title of The web is " + title2);
                        }
                    }
                    Thread.sleep(2000);

                } else if (i == 2) {
                    new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));

                    List<String> listJPCity = searchDropDownMenu("#cityselect option");
                    displayText(listJPCity);
                    //   Thread.sleep(2000);

                    //     new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));


                    //  new Select(driver.findElement(By.id("countrySelect"))).selectByValue('"'+listMenu.get(0)+'"');
                    // .selectByVisibleText("United States of America");

                    for (int j = 0; j < listJPCity.size(); j++) {
                        if (j > 0) {
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
                        } else {
                            System.out.println("----- Start calculation-------");
                            String title3 = driver.getTitle();
                            System.out.println("The Title of The web is " + title3);
                        }
                    }
                    Thread.sleep(2000);

                } else if (i == 3) {
                    new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));
                    List<String> listUAECity = searchDropDownMenu("#cityselect option");
                    displayText(listUAECity);
                    Thread.sleep(2000);

                    //     new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));


                    //  new Select(driver.findElement(By.id("countrySelect"))).selectByValue('"'+listMenu.get(0)+'"');
                    // .selectByVisibleText("United States of America");

                    for (int j = 0; j < listUAECity.size(); j++) {
                        if (j > 0) {
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
                        } else System.out.println(" Start calculation");
                    }
                    Thread.sleep(2000);

                } else if (i == 4) {
                    new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));
                    List<String> listUKCity = searchDropDownMenu("#cityselect option");
                    displayText(listUKCity);
                    Thread.sleep(2000);

                    //    new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));


                    //  new Select(driver.findElement(By.id("countrySelect"))).selectByValue('"'+listMenu.get(0)+'"');
                    // .selectByVisibleText("United States of America");

                    for (int j = 0; j < listUKCity.size(); j++) {
                        if (j > 0) {
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
                        } else System.out.println(" Start calculation");
                    }
                    Thread.sleep(2000);

                } else if (i == 5) {
                    System.out.println(" This is number # 5");
                  //  calCulation();
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


        } catch (IOException e) {
            System.out.print("this is bad ");
        }

    }

    public void calCulation() throws InterruptedException {
       // List<String> listMenu = searchDropDownMenu("#countrySelect option");
      //  Assert.assertEquals(listMenu, TaxiFareBase.menu);

        new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(" United States of America ");
        List<String> listUSACity = searchDropDownMenu("#cityselect option");
        displayText(listUSACity);
        //   Thread.sleep(2000);
        //  new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(listMenu.get(i));


        //  new Select(driver.findElement(By.id("countrySelect"))).selectByValue('"'+listMenu.get(0)+'"');
        // .selectByVisibleText("United States of America");

        //  for (int j = 0; j < listUSACity.size(); j++) {   // real
        for (int j = 0; j < 2; j++) {     // only for test
            if (j > 0) {
                new Select(driver.findElement(By.id("cityselect"))).selectByVisibleText(listUSACity.get(j));

                // new Select(driver.findElement(By.xpath(".//*[@id='cityselect']"))).selectByVisibleText(listCity.get(7));
                //  new Select(driver.findElement(By.id("#cityselect")).selectByVisibleText();


                driver.findElement(By.id("fromAddress")).clear();
                driver.findElement(By.id("fromAddress")).sendKeys("1000, 5th ave, ny");

                // new Select(driver.findElement(By.id("toDirectory"))).selectByVisibleText("1900 5th Ave, New York, NY 10065");
                driver.findElement(By.id("toAddress")).clear();
                driver.findElement(By.id("toAddress")).sendKeys("1900 5th Ave, New York, NY 10065");
                driver.findElement(By.name("submit")).click();
                Thread.sleep(1000);

//                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//                //The below method will save the screen shot in d drive with name "screenshot.png"
//                FileUtils.copyFile(scrFile, new File("/Users/shamimchy/Documents/screenshot/screenshot_" + (i + 1) + "_" + j + "_a.png"));


                Thread.sleep(2000);

                //

                String from = "";
                String to = "";

                //----------------------------- FRom Directory---------------
                int index = 0;
                WebElement select1 = driver.findElement(By.id("fromDirectory"));
                List<WebElement> options = select1.findElements(By.tagName("option"));
                for (WebElement option : options) {
                    // if(select.getAttribute("value") != "") {
                    //         System.out.println(select.getAttribute("value"));
                    index++;

                    if (index == 3) {
                        //  System.out.println(" First Enter" + option.getText());
                        //   driver.findElement(By.id("fromAddress")).clear();
                        //  driver.findElement(By.id("fromAddress")).sendKeys(select.getAttribute("value"));
                        //  Thread.sleep(2000);
                        // option.click();
                        //  from = select1.getAttribute("value");
                        from = option.getText();
                        System.out.println(" Before Conver Select_enter  FRom : " + from);


                    }
                    if (index == 5) {
                        System.out.println(" Select From  : " + option.getText());
                        driver.findElement(By.id("fromAddress")).clear();
                        //  driver.findElement(By.id("fromAddress")).sendKeys(select.getAttribute("value"));
                        //  Thread.sleep(2000);
                        option.click();


                    }


                    //  System.out.println( option.getText() + " ----- GetAttribute-----" + select.getAttribute("value"));System.out.print(option.getText());
                    //     System.out.println(select.getAttribute("value"));
//                  if ("Upper West Side (85th & Amst)".equals(option.getText()))
//                      System.out.print(option.getText());

//                          if(option.getLocation().equals(1)){
//                              System.out.print("");
//
//                          }
//                  option.click();
                    // }

                }

                //-------------------------------------- toDirectory-------------------------------------------


                int indexTo = 0;
                WebElement selectTo = driver.findElement(By.id("toDirectory"));
                List<WebElement> optionsTo = selectTo.findElements(By.tagName("option"));
                for (WebElement optionTo : optionsTo) {
                    // if(select.getAttribute("value") != "") {
                    //         System.out.println(select.getAttribute("value"));
                    indexTo++;


                    if (indexTo == 4) {
//                                System.out.print("Second Enter : " + optionTo.getText());
//                                driver.findElement(By.id("toAddress")).clear();
//                                 driver.findElement(By.id("toAddress")).sendKeys(select.getAttribute("value"));
//                              //  optionTo.click();
//
//                                driver.findElement(By.name("submit")).click();
//
//                                Thread.sleep(2000);
                        // to = selectTo.getAttribute("value");
                        to = optionTo.getText();
                        System.out.println(" Before Convert Select_Enter to : " + to);

                    }

                    if (indexTo == 6) {
                        System.out.println(" Select to : " + optionTo.getText());
                        driver.findElement(By.id("toAddress")).clear();
                        // driver.findElement(By.id("toAddress")).sendKeys(select.getAttribute("value"));
                        optionTo.click();

                        driver.findElement(By.name("submit")).click();

//                        File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//                        //The below method will save the screen shot in d drive with name "screenshot.png"
//                        FileUtils.copyFile(scrFile1, new File("/Users/shamimchy/Documents/screenshot/screenshot_" + (i + 1) + "_" + j + "_b.png"));


                        Thread.sleep(2000);

                        Thread.sleep(1000);

                    }

                    Thread.sleep(1000);
                    //  System.out.println( option.getText() + " ----- GetAttribute-----" + select.getAttribute("value"));System.out.print(option.getText());
                    //       System.out.println(select.getAttribute("value"));
//                  if ("Upper West Side (85th & Amst)".equals(option.getText()))
//                      System.out.print(option.getText());

//                          if(option.getLocation().equals(1)){
//                              System.out.print("");
//
//                          }
//                  option.click();
                    // }

                }

                //-------------------------------------------------------------------------------------------


                driver.findElement(By.id("fromAddress")).clear();
                //  searchDropDownMenu("#fromDirectory option").isEmpty();

//                        Select droplist = new Select(driver.findElement(By.id("fromDirectory")));
//                        // .Id("selection")));
//                        droplist.selectByVisibleText("-- Select An Address --");
//
//
//                        driver.findElement(By.id("fromAddress")).sendKeys(from);
//                        System.out.println(" From--> "+ from);
//                        Thread.sleep(1000);

                // new Select(driver.findElement(By.id("toDirectory"))).selectByVisibleText("1900 5th Ave, New York, NY 10065");
                driver.findElement(By.id("toAddress")).clear();

                // searchDropDownMenu("#toDirectory option").isEmpty();

//                        Select droplist1 = new Select(driver.findElement(By.id("toDirectory")));
//                        // .Id("selection")));
//                        droplist1.selectByVisibleText("-- Select An Address --");
//
//                        driver.findElement(By.id("toAddress")).sendKeys(to);
//                        System.out.println(" to---> " + to);
//                        Thread.sleep(1000);


//                        driver.findElement(By.name("submit")).click();
//                        Thread.sleep(4000);


                //-------------------


                Select first = new Select(driver.findElement(By.id("fromDirectory")));

                first.selectByVisibleText(from);

                String value = first.getFirstSelectedOption().getAttribute("value");
                System.out.println("Enter_Select From : " + value);


                Select droplist = new Select(driver.findElement(By.id("fromDirectory")));
                // .Id("selection")));
                droplist.selectByVisibleText("-- Select An Address --");


                driver.findElement(By.id("fromAddress")).sendKeys(value);

                Thread.sleep(1000);


                //------------------------------

                Select second = new Select(driver.findElement(By.id("toDirectory")));

                second.selectByVisibleText(to);

                String valueSecond = second.getFirstSelectedOption().getAttribute("value");
                System.out.println("Enter_Select To : " + valueSecond);


                Select droplist1 = new Select(driver.findElement(By.id("toDirectory")));
                // .Id("selection")));
                droplist1.selectByVisibleText("-- Select An Address --");

                driver.findElement(By.id("toAddress")).sendKeys(valueSecond);

                Thread.sleep(1000);

                driver.findElement(By.name("submit")).click();
                Thread.sleep(2000);

//                File scrFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//                //The below method will save the screen shot in d drive with name "screenshot.png"
//                FileUtils.copyFile(scrFile2, new File("/Users/shamimchy/Documents/screenshot/screenshot_" + (i + 1) + "_" + j + "_c.png"));


                Thread.sleep(2000);


            }

//                    else {
//                        System.out.println(" Start calculation");
//                        String title1 = driver.getTitle();
//                        System.out.println("The Title of The web is " + title1);
//                    }
        }
        Thread.sleep(2000);
    }


}
