public interface CalculatorBase
{
	public void pressButton(char buttonValue);
	public void setDisplay(String value);
	public void setDisplay(double value);
	public void appendDisplay(char value);
	public double getDisplayValue();
	public String getDisplay();
}