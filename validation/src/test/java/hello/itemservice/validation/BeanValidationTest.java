package hello.itemservice.validation;

import hello.itemservice.domain.item.Item;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

public class BeanValidationTest {

  @Test
  void beanValidation() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    Item item = new Item();
    item.setItemName(" ");
    item.setPrice(0);
    item.setQuantity(10_000);

    Set<ConstraintViolation<Item>> validate = validator.validate(item);
    for (ConstraintViolation<Item> violation : validate) {
      System.out.println("violation = " + violation);
    }
  }
}
