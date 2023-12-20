package lab5;

import java.time.format.DateTimeFormatter;

public class WeatherInfo {

    private String uploadDate;

    private String directionOfWind;

    private byte speedOfWindKmH;
    private byte temperatureCelsius;
    private byte precipitation;
    private byte humidity;

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

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getDirectionOfWind() {
        return directionOfWind;
    }

    public void setDirectionOfWind(String directionOfWind) {
        this.directionOfWind = directionOfWind;
    }

    public byte getSpeedOfWindKmH() {
        return speedOfWindKmH;
    }

    public void setSpeedOfWindKmH(byte speedOfWind) {
        this.speedOfWindKmH = speedOfWind;
    }

    public byte getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public void setTemperatureCelsius(byte temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    public byte getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(byte precipitation) {
        this.precipitation = precipitation;
    }

    public byte getHumidity() {
        return humidity;
    }

    public void setHumidity(byte humidity) {
        this.humidity = humidity;
    }

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
