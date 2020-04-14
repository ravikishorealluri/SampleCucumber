package com.ravi.personal.steps;

import com.ravi.personal.utils.confUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.Collections;

public class Test_Steps extends confUtils {
    public Integer addInt =0;
    public double addDbl =0;
//* Adding Two Double Values
    @Then("^I find addition of Integers (\\d+) and (\\d+)$")
    public Integer Addition(int Int1, int Int2) {
        addInt = Int1 + Int2;
        System.out.println("Addition of Two Integers is: "+addInt);
        return addInt;
    }
//* Adding Two Double Values
    @Given("^I find addition of Double Values \"([^\"]*)\" and \"([^\"]*)\"$")
    public double Addition(double Int1, double Int2) {
        addDbl = Int1 + Int2;
        System.out.println("Addition of Two Double Values is: "+addDbl);
        return addInt;
    }

    @Given("^Numbers (\\d+) and (\\d+), find the Random Number$")
    public void numbersAndFindTheRandomNumber(int StartRange, int EndRange) {
        System.out.println("Random Number Between "+StartRange +" and "+EndRange+" is: "+getRandomNum(StartRange, EndRange));

    }


    public void iFindAdditionOfDoubleValuesAnd(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    @Given("^I split the Sentence \"([^\"]*)\" and put all words in Ascending Order$")
    public void iSplitTheSentenceAndPutAllWordsInAscendingOrder(String Input) throws Throwable {

//        String[] WordsArray = Input.split(" ");
//
//        for(String Word:WordsArray){
//            System.out.println("Unsorted ArrayList: " + Word);
//        }
//        Arrays.sort(WordsArray);
//        for(String Word:WordsArray){
//            System.out.println("Sorted ArrayList in Ascending Order : " + Word);
//        }


        ArrayList<String> countryList = new ArrayList<>();
        countryList.add("France");
        countryList.add("USA");
        countryList.add("india");
        countryList.add("Spain");
        countryList.add("England");

        System.out.println("Unsorted ArrayList: " + countryList);

        Collections.sort(countryList);
        System.out.println("Sorted ArrayList in Ascending Order : " + countryList);

        Collections.sort(countryList, Collections.reverseOrder());
        System.out.println("Sorted ArrayList in Descending Order : " + countryList);
    }

}//* Close class

