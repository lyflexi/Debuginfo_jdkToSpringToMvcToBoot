package org.lyflexi.observerPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:47
 */

public class WeatherDataTest {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();//气象数据即被观察者
        WeatherDisplay weatherDisplay = new WeatherDisplay(weatherData);//天气展示即观察者
        weatherData.setMessurements(37.2f,80f,32.5f);
        weatherDisplay.display();//天气展示
    }
}

