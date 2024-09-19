package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class brightnessadjustmentapp {

    // Method to execute PowerShell commands from Java
    public static void adjustBrightness(int percentage) {
        try {
            // PowerShell command to set brightness
            String command = "powershell.exe (Get-WmiObject -Namespace root/wmi -Class WmiMonitorBrightnessMethods).WmiSetBrightness(1," + percentage + ")";

            // Execute the command
            Process process = Runtime.getRuntime().exec(command);

            // Reading the output from the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to finish
            process.waitFor();

            System.out.println("Brightness set to " + percentage + "%");
            System.out.println("@ Powered by Gowtham");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter brightness level (0 to 100): ");
            String input = reader.readLine();
            int brightnessLevel = Integer.parseInt(input);

            // Check if the input is within valid range
            if (brightnessLevel >= 0 && brightnessLevel <= 100) {
                adjustBrightness(brightnessLevel); // Adjust brightness based on user input
            } else {
                System.out.println("Invalid brightness level. Please enter a value between 0 and 100.");
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
