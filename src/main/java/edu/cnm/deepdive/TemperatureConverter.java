package edu.cnm.deepdive;

import java.util.Scanner;

public class TemperatureConverter
{

  private static final int CELSIUS_FAHRENHEIT_OFFSET = 32;
  private static final double KELVIN_CELSIUS_OFFSET = 273.15;
  public static final double CELSIUS_FAHRENHEIT_SCALE_FACTOR = 1.8;
  private static Mode mmode = Mode.CF;

  public static void main(String[] args)
  {
    System.out.printf("Starting mode = %s%n", mmode);

    // while there is input
    // - check if input matches one of the modes;
    //    if so, change mode
    // otherwise check if input is a number
    //    if so, perform conversion
    // otherwise, halt.

    Scanner var_scanner = new Scanner(System.in);
    while (var_scanner.hasNext())
    {
      if (var_scanner.hasNext(Mode.PATTERN))
      {
        mmode = Mode.valueOf(var_scanner.next(Mode.PATTERN).toUpperCase());
        System.out.printf("Change mode to = %s%n", mmode);
      }
      else if (var_scanner.hasNextDouble())
        {
          double value = var_scanner.nextDouble();
          double convertedValue = convert(value);
          System.out.printf("Input = %.2f; output = %.2f%n", value, convertedValue);
        }
        else
          {
            // throw an error
            throw new IllegalArgumentException(String.format("Invalid input: %s%n", var_scanner.next()));
          }
    }


    for (String arg : args)
    {
      try
      {
        mmode = Mode.valueOf(arg.toUpperCase());
        System.out.printf("Change mode to = %s%n", mmode);
      }
      catch (IllegalArgumentException e)
      {
        double value = Double.parseDouble(arg);
        double convertedValue = convert(value);
        System.out.printf("Input = %.2f; output = %.2f%n", value, convertedValue);
        // TODO Display input and converted value.
      }
    }
  }

  private static double convert(double value)
  {
    //throw new UnsupportedOperationException();
    return switch (mmode)
    {
      case CF -> value * CELSIUS_FAHRENHEIT_SCALE_FACTOR + CELSIUS_FAHRENHEIT_OFFSET;
      case CK -> value + KELVIN_CELSIUS_OFFSET;
      case FC -> (value - CELSIUS_FAHRENHEIT_OFFSET) / CELSIUS_FAHRENHEIT_SCALE_FACTOR;
      case FK -> (value - CELSIUS_FAHRENHEIT_OFFSET) / CELSIUS_FAHRENHEIT_SCALE_FACTOR
          + KELVIN_CELSIUS_OFFSET;
      case KC -> value - KELVIN_CELSIUS_OFFSET;
      case KF -> (value - KELVIN_CELSIUS_OFFSET) * CELSIUS_FAHRENHEIT_SCALE_FACTOR
          + CELSIUS_FAHRENHEIT_OFFSET;
    };
  }
}
