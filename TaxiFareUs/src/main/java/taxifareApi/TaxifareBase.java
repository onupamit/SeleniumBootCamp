package taxifareApi;

import base.baseApi.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;





public class TaxiFareBase extends Base {
    public static List<String> menu = new ArrayList<String>();

    public static String [] list = {
            " United States of America ",
            " France",
            "Japan",
            "United Arab Emirates",
            " Unied Kingdom",
            " United States of America "        ,

    } ;
    public void setItems(String [] list){
        for(String st:list){
            menu.add(st);
        }
    }
    public List<String> getItems(){
        return menu;
    }
    public void search(String locator, String value){
        typeByCss(locator, value);
    }

    public List<String> searchDropDownMenu(String locator){
        List<String> menuList = getListOfTextByCss(locator);

        return menuList;



    }
//    public List<String> searchDropDownMenuXpath(String locator){
//        //  List<String> menuList = getWebElementsByXpath(locator);
//
//        List<String> menuList = getListOfTextByXpath(locator);
//
//        return menuList;
//
//
//
//    }


}
