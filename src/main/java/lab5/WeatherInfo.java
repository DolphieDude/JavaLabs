package lab5;

import java.time.format.DateTimeFormatter;

/**
 * The {@code WeatherInfo} class represents information about weather conditions at a specific point in time.
 * It includes data such as the date of upload, wind direction, wind speed, temperature, precipitation,
 * and humidity.
 *
 * @author Andrii Cherevatyi
 */
public class WeatherInfo {

    /**
     * The date and time when the weather information was uploaded.
     */
    private String uploadDate;

    /**
     * The direction of the wind at the time of measurement.
     */
    private String directionOfWind;

    /**
     * The speed of the wind in kilometers per hour.
     */
    private byte speedOfWindKmH;

    /**
     * The temperature in degrees Celsius.
     */
    private byte temperatureCelsius;

    /**
     * The percentage of precipitation at the time of measurement.
     */
    private byte precipitation;

    /**
     * The percentage of humidity at the time of measurement.
     */
    private byte humidity;

    /**
     * Constructs a WeatherInfo object with the specified weather parameters.
     *
     * @param directionOfWind   The direction of the wind.
     * @param speedOfWind       The speed of the wind in kilometers per hour.
     * @param temperatureCelsius The temperature in degrees Celsius.
     * @param precipitation     The percentage of precipitation.
     * @param humidity          The percentage of humidity.
     */
    public WeatherInfo(String directionOfWind, byte speedOfWind, byte temperatureCelsius, byte precipitation,
                       byte humidity) {
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.uploadDate = java.time.LocalDateTime.now().format(FORMATTER);

        this.directionOfWind = directionOfWind;
        this.speedOfWindKmH = speedOfWind;
        this.temperatureCelsius = temperatureCelsius;
        this.precipitation = precipitation;
        this.humidity = humidity;
    }

    /**
     * Gets the date and time when the weather information was uploaded.
     *
     * @return The date and time of upload.
     */
    public String getUploadDate() {
        return uploadDate;
    }

    /**
     * Sets the date and time when the weather information was uploaded.
     *
     * @param uploadDate The date and time of upload.
     */
    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    /**
     * Gets the direction of the wind.
     *
     * @return The direction of the wind.
     */
    public String getDirectionOfWind() {
        return directionOfWind;
    }

    /**
     * Sets the direction of the wind.
     *
     * @param directionOfWind The direction of the wind.
     */
    public void setDirectionOfWind(String directionOfWind) {
        this.directionOfWind = directionOfWind;
    }

    /**
     * Gets the speed of the wind in kilometers per hour.
     *
     * @return The speed of the wind.
     */
    public byte getSpeedOfWindKmH() {
        return speedOfWindKmH;
    }

    /**
     * Sets the speed of the wind in kilometers per hour.
     *
     * @param speedOfWind The speed of the wind.
     */
    public void setSpeedOfWindKmH(byte speedOfWind) {
        this.speedOfWindKmH = speedOfWind;
    }

    /**
     * Gets the temperature in degrees Celsius.
     *
     * @return The temperature.
     */
    public byte getTemperatureCelsius() {
        return temperatureCelsius;
    }

    /**
     * Sets the temperature in degrees Celsius.
     *
     * @param temperatureCelsius The temperature.
     */
    public void setTemperatureCelsius(byte temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    /**
     * Gets the percentage of precipitation.
     *
     * @return The percentage of precipitation.
     */
    public byte getPrecipitation() {
        return precipitation;
    }

    /**
     * Sets the percentage of precipitation.
     *
     * @param precipitation The percentage of precipitation.
     */
    public void setPrecipitation(byte precipitation) {
        this.precipitation = precipitation;
    }

    /**
     * Gets the percentage of humidity.
     *
     * @return The percentage of humidity.
     */
    public byte getHumidity() {
        return humidity;
    }

    /**
     * Sets the percentage of humidity.
     *
     * @param humidity The percentage of humidity.
     */
    public void setHumidity(byte humidity) {
        this.humidity = humidity;
    }

    /**
     * Returns a string representation of the WeatherInfo object.
     *
     * @return A string containing weather information.
     */
    @Override
    public String toString() {
        return "Weather Info for " + uploadDate + ":\n" +
                "Direction of wind=" + directionOfWind + "\n" +
                "Speed of wind=" + speedOfWindKmH + "km/h\n" +
                "Temperature=" + temperatureCelsius + "°C\n" +
                "Precipitation=" + precipitation + "%\n" +
                "Humidity=" + humidity + "%";
    }
}
