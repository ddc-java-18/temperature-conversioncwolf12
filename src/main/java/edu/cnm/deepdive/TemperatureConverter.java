package edu.cnm.deepdive;

public class TemperatureConverter
{

  private static Mode mode = Mode.CF;

  public static void main(String[] args)
  {
      for (String arg : args)
      {
        try
        {
          Mode newMode = Mode.valueOf(arg.toUpperCase());
        }
        catch (IllegalArgumentException e)
        {
          double value = Double.parseDouble(arg);
          // TODO Convert using current mode.
        }
      }
  }

  private static double convert(double value)
    {
      // TODO: 5/20/2024 perform conversion with value and mode; return result.
      throw new UnsupportedOperationException();
    }
}
