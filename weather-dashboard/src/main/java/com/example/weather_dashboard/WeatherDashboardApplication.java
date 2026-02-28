package com.example.weather_dashboard;

import com.example.weather_dashboard.models.WeatherData;
import com.example.weather_dashboard.service.WeatherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

@SpringBootApplication
public class WeatherDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherDashboardApplication.class, args);
	}

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner run(WeatherService weatherService) {
        return args -> {


            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\n==== Morning Routine Weather ====");
                System.out.println("1. Check St Louis");
                System.out.println("2. Check New York");
                System.out.println("3. Check Los Angeles");
                System.out.println("4. Enter custom city");
                System.out.println("5. Exit");
                System.out.print("Choose option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                String city = null;

                if (choice == 1) city = "St Louis";
                else if (choice == 2) city = "New York";
                else if (choice == 3) city = "Los Angeles";
                else if (choice == 4) {
                    System.out.print("Enter city name: ");
                    city = scanner.nextLine();
                }
                else if (choice == 5) {
                    System.out.println("Goodbye!");
                    break;
                }
                else {
                    System.out.println("Invalid choice.");
                    continue;
                }

                WeatherData forecast = weatherService.getWeatherData(city);

                if (forecast != null) {
                    System.out.println("\n---- Weather Summary ----");
                    System.out.println("City: " + forecast.getCity());
                    System.out.println("Temperature: " + forecast.getTemperature() + "°F");
                    System.out.println("Description: " + forecast.getDescription());
                    System.out.println("Humidity: " + forecast.getHumidity() + "%");
                    System.out.println("-------------------------");
                }
            }
        };
    }
}


