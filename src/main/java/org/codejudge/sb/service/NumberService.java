package org.codejudge.sb.service;

import org.codejudge.sb.model.Numbers;
import org.codejudge.sb.model.Sum;
import org.springframework.stereotype.Service;

@Service
public class NumberService {

	public Sum addNumbers(Numbers numbers){
		int sum =numbers.getSum();
		return new Sum(sum);
	}
}
