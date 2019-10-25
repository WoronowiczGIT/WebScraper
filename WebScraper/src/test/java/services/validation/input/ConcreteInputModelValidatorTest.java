package services.validation.input;

import models.DataModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class ConcreteInputModelValidatorTest {
    private InputModelValidator validator;
    private Map<DataModel,Boolean> conditions;

    @Before
    public void setUp(){
        validator = new ConcreteInputModelValidator();
        conditions = new HashMap<>();
    }

    @Test
    public void isValidTest(){
        addModel("www.wp.pl","10",true);
        addModel("www.wp.pl","-1",false);


        for(DataModel model : conditions.keySet()){
            Boolean actual = validator.isValid(model);
            Boolean expected = conditions.get(model);
            System.out.println(model.getUrl()+" "+model.getTime());
            Assert.assertEquals(expected,actual);
        }
    }
    private void addModel(String url, String time, Boolean result){
        DataModel model = new DataModel.DataModelBuilder()
                .setTime(time)
                .setUrl(url)
                .build();

        conditions.put(model,result);
    }


}
