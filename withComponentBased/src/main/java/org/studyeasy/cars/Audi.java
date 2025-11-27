package org.studyeasy.cars;
import org.springframework.stereotype.Component;
import org.studyeasy.interfaces.Car;
@Component("audi")
public class Audi implements Car {
	  @Override
	public String specs() {
		return "Audi is from xyz";
	}
}
