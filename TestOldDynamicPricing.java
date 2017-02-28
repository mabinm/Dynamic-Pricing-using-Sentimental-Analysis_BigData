

public class TestOldDynamicPricing {
	
	private static int[] time = {1,2,3,4,5,6,7,8,9,10,11};
	private static double[] saverage = {0.04,0.06,0.01,0.03,0.06,0.08,-0.05,0.11,0.05,0.05,0.22};
	private static int[] st = {65,174,10,152,79,12,-77,332,136,156,6};
	private static double[] vaverage = {0.88,0.96,0.64,0.91,0.39,0.41,0.72,0.99,0.61,0.7,0.6};
	private static double[] dynamicValuationResult={0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	private static double[] dynamicArrivalRateResult={0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	private static double[] buyingProbabilityResult={0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	private static double dynamicPrice=0.0;
	private static int maxTime = 10;
	private static int n=10;
	private static double p = 160.0; //price of the product
	
	public double RevenueGenerator(int n,int t,int i){
		if (n == 0) return 0.0;
		if (t == maxTime) return 0.0;
		dynamicPrice = (dynamicValuationResult[i] * buyingProbabilityResult[i] *(p + RevenueGenerator(n-1,t+1,i+1))) +
				       (dynamicValuationResult[i] * (1 - buyingProbabilityResult[i]) * RevenueGenerator(n,t+1,i+1)) +
				       ((1- dynamicValuationResult[i]) * RevenueGenerator(n,t+1,i+1));
		return dynamicPrice;
	}

	public static void main(String[] args){

	DynamicPricingOld DP = new DynamicPricingOld();
	TestOldDynamicPricing NDP = new TestOldDynamicPricing();
	for(int i=0;i<10;i++)
		dynamicValuationResult[i] = DP.DynamicValuationCalculator(time[i],saverage[i]);
	
	for(int i=0;i<10;i++)
		dynamicArrivalRateResult[i] = DP.DynamicArrivalRateCalculator(time[i],vaverage[i]);
		
	for(int i=0;i<10;i++)
		buyingProbabilityResult[i] = DP.BuyingProbability(time[i],st[i],saverage[i]);

	System.out.println("Calculating Revenue Generator");
	NDP.RevenueGenerator(n,1,0);
	System.out.println(dynamicPrice);
	
	NDP.RevenueGenerator(n,2,0);
	System.out.println(dynamicPrice);
	
	NDP.RevenueGenerator(n,3,0);
	System.out.println(dynamicPrice);
	
	NDP.RevenueGenerator(n,4,0);
	System.out.println(dynamicPrice);
	
	NDP.RevenueGenerator(n,5,0);
	System.out.println(dynamicPrice);
	
	NDP.RevenueGenerator(n,6,0);
	System.out.println(dynamicPrice);
	
	NDP.RevenueGenerator(n,7,0);
	System.out.println(dynamicPrice);
	
	NDP.RevenueGenerator(n,8,0);
	System.out.println(dynamicPrice);
	
	NDP.RevenueGenerator(n,9,0);
	System.out.println(dynamicPrice);
	
	NDP.RevenueGenerator(n,10,0);
	System.out.println(dynamicPrice);

	
	}
}
