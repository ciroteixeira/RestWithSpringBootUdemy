package br.com.erudio;

import java.text.DecimalFormat;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.MathException;

@RestController
public class MathController {

	
	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathException("Please, set a numeric value!");
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);		
		return sum;
		
	}
	
	@RequestMapping("/sub/{numberOne}/{numberTwo}")
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathException("Please, set a numeric value!");
		}
		Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);		
		return sub;
		
	}
	
	@RequestMapping("/mult/{numberOne}/{numberTwo}")
	public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathException("Please, set a numeric value!");
		}
		Double mult = convertToDouble(numberOne) * convertToDouble(numberTwo);		
		return mult;
		
	}
	
	@RequestMapping("/div/{numberOne}/{numberTwo}")
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathException("Please, set a numeric value!");
		}
		Double div = convertToDouble(numberOne) / convertToDouble(numberTwo);		
		return div;
		
	}
	
	@RequestMapping("/sqrt/{number}")
	public Double sqrt(@PathVariable("number") String number) throws Exception {
		
		if(!isNumeric(number)) {
			throw new MathException("Please, set a numeric value!");
		}
		Double sqrt = Math.sqrt(convertToDouble(number));		
		return sqrt;
		
	}
	
	@RequestMapping("/avg/{numberOne}/{numberTwo}/{numberThree}")
	public Double avg(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo,
					  @PathVariable("numberThree") String numberThree)	
			throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo) || !isNumeric(numberThree)) {
			throw new MathException("Please, set a numeric value!");
		}
		Double avg = (convertToDouble(numberOne) + convertToDouble(numberTwo) + convertToDouble(numberThree))
					 / 3;	
		
		return avg;
		
	}

	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	
	
	
	
}
