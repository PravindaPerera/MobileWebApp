package services;


public class phones {
    private int phone_id;
    private String brand;
    private String code;
    private String storage;
    private String display;
    private String battery;
    private String front_cam;
    private String rear_cam;
    private Double price;

    public int getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(int phone_id) {
        this.phone_id = phone_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getFront_cam() {
        return front_cam;
    }

    public void setFront_cam(String front_cam) {
        this.front_cam = front_cam;
    }

    public String getRear_cam() {
        return rear_cam;
    }

    public void setRear_cam(String rear_cam) {
        this.rear_cam = rear_cam;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
