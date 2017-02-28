

public class DynamicPricingOld {
	
	public double ktCalculator(int t,int st,double sbase){
		double result;
		double marginalUtility;
		double price;
		
		marginalUtility = 80; //u(t)
		price = 100;
		
		result = marginalUtility - DynamicValuationCalculator(t,sbase) + price;
		
		return result;		
	}


	public double DynamicValuationCalculator(int t,double sbase){
		
		double result;

		result = sbase;
		return result;
	}

	public double DynamicArrivalRateCalculator(int t,double vbase){
		
		double result;
	
		result = vbase;	
		return result;
	}
	
	public double BuyingProbability(int t,int st,double sbase){
		
		double result;
		double exponent;
		double m=1000; //value of myu
		
		exponent = Math.exp(ktCalculator(t,st,sbase)/m);
		result = (1/(exponent +1));
		
		return result;
		
	}
	
}
