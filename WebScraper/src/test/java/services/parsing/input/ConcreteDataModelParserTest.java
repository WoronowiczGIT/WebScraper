package services.parsing.input;

import models.DataModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ConcreteDataModelParserTest {
    private DataModelParser parser;
    private Set<String[]> conditions;

    @Before
    public void setUp(){
        this.parser = new ConcreteDataModelParser();
        this.conditions = new HashSet();
    }

    @Test
    public void parseCorrect() {
        String url = "http://url";
        String time = "time";
        String[] goodArgs = {url,time};
        conditions.add(goodArgs);

        for(String[] key: conditions){
            DataModel model = parser.parse(key);
            Assert.assertTrue(model.getUrl().equals(url));
            Assert.assertTrue(model.getTime().equals(time));
        }
    }

    @Test
    public void parseIncorrect() {

        String[] toManyArgs = {"url","time","extras"};
        conditions.add(toManyArgs);

        String[] toFewArgs = {"url"};
        conditions.add(toFewArgs);

        String[] noArgs = {};
        conditions.add(noArgs);

        String[] nullArray = null;
        conditions.add(nullArray);

        for(String[] key: conditions){
            DataModel model= null;
            try{

                model = parser.parse(key);
                System.out.println(model.getTime()+" "+model.getUrl());
            }catch (IllegalArgumentException e){
                System.out.println("failed to parse");
            }
            Assert.assertNull(model);
        }
    }
}
