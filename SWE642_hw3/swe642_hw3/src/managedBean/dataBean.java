/**
 * The DataBean has two attributes to
hold the mean and standard deviation for mean and std deviation calculation
 */
package managedBean;
/**
 * 
 * @author rutujajadhav
 *
 */
public class dataBean {
private float mean;
private double sdtdev;
public float getMean() {
	return mean;
}
public void setMean(float mean) {
	this.mean = mean;
}
public double getSdtdev() {
	return sdtdev;
}
public void setSdtdev(double sdtdev) {
	this.sdtdev = sdtdev;
}
}
