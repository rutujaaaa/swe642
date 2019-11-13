/**
 * DataProcessor that provides a method to compute the Mean and Standard Deviation 
 * using the ten numbers entered in the Data field on the
 * Student Survey Form
 */
package managedBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author rutujajadhav
 *
 */
public class DataProcessor {
	public float calcMean(String dataValues){
        float mean = 0; 
        List<Float> floatList = new ArrayList<>();
        List<String> items = Arrays.asList(dataValues.split("\\s*,\\s*"));
        for(String s : items) 
        	floatList.add(Float.valueOf(s));
        if(!floatList.isEmpty()) {
            for (Float num : floatList) {
            mean += num;
            }
            
        }
        return mean / floatList.size();
    }
    
    public double calStdDev(String dataValues, Float mean){
        double stdDev = 0;
        double sum = 0;
        String numbers[] = dataValues.split(",");
        for (int i = 0; i < numbers.length; i++) 
            sum = Math.pow((Integer.parseInt(numbers[i]) - mean), 2);
        sum = sum / numbers.length;
        stdDev = Math.sqrt(sum);
        return stdDev;
	}
}
