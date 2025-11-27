package org.studyeasy.cars;
import org.springframework.stereotype.Component;
import org.studyeasy.interfaces.Car;

@Component("team")
public class Corolla implements Car{
	public String specs() {
		return "Sedan from Toyota";
	}

}
