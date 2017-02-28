
/*
 * This program calculates the revenue generated at a time based on the dynamic pricing 
 * model present in the below paper
 * "A Pricing Mechanism Using Social Media and Web Data to Infer Dynamic
 * Consumer Valuations" By:Samuel D Johnson & Kang-Yu Ni - IEEE 2015 International
 * Conference on Big Data
 */

public class DynamicPricing {
	
    //Calculate the sigmoid value of a double tbasediff
    //java.lang.Math.exp(double a) returns Euler's number e raised to the power of a double value

	public double SigmoidCalculator(double tbasediff){
		double result;
		double exponent;
		
		exponent = Math.exp(-tbasediff);
		result = (1/(1+exponent));
		return result;	
	}
	
	public double ktCalculator(int t,int st,double sbase){
		double result;
		double marginalUtility;
		double price;
		
		marginalUtility = 80; //u(t)
		price = 100;
		
		result = marginalUtility - DynamicValuationCalculator(t,st,sbase) + price;
		
		return result;		
	}

	public double DynamicValuationCalculator(int t,int st,double sbase){
		
		double result;
		double abase;
		double cv;

		//Baseline valuation
		abase = 0.2;
		
		//value of cv such that result is between 0 and 1
		cv =0.13;
		
		result = abase + cv*((SigmoidCalculator(st - sbase)) - 0.5);
		return result;
	}
	
	//Baseline arrival rate is the arrival rate that would have been generated 
	//using the original strategy
	//value of vbase = average daily volume of tweets
	public double DynamicArrivalRateCalculator(int t, int vt,double vbase){
		
		double result;
		double lamdabase;
		double ca;
		
		//Baseline arrival rate
		lamdabase = 0.2;
		
		//value of ca such that result is between 0 and 1
		ca =0.135;

		result = lamdabase + ca*((SigmoidCalculator(vt - vbase)) - 0.5);	
		return result;
	}
	
	public double BuyingProbability(int t,int st,double sbase){
		
		double result;
		double exponent;
		double m=80; //value of myu
		
		exponent = Math.exp(ktCalculator(t,st,sbase)/m);
		result = (1/(exponent +1));
		
		return result;
		
	}
	
}
