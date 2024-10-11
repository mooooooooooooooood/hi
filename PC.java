package a2_2201040061;

import java.util.Objects;

public class PC {
    private String model;
    private int year;
    private String manufacturer;
    private Set<String> comps;
    //constructor
    public PC(String model, int year, String manufacturer, Set<String> comps) throws Exception {
        if (!isValidModel(model)) throw new Exception("Invalid model!");
        this.model = model;

        if (!isValidYear(year)) throw new Exception("Invalid year!");
        this.year = year;

        if (!isValidManufacturer(manufacturer)) throw new Exception("Invalid manufacture!");
        this.manufacturer = manufacturer;
        
        this.comps = comps;
    }
    //getter && setter
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) throws Exception {
        if (!isValidModel(model)) throw new Exception("Invalid model!");
        this.model = model;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) throws Exception {
        if (!isValidYear(year)) throw new Exception("Invalid year!");
        this.year = year;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) throws Exception {
        if (!isValidManufacturer(manufacturer)) throw new Exception("Invalid manufacture!");
        this.manufacturer = manufacturer;
    }

    public Set<String> getComps() {
        return this.comps;
    }

    public void setComps(Set<String> comps) {
        this.comps = comps;
    }
    //validator
    public boolean isValidModel (String model) {
        return model != null && model.trim().length() <= 20 && !model.trim().isEmpty();
    }

    public boolean isValidYear(int year) {
        return year >= 1984;
    }

    public boolean isValidManufacturer (String manufacturer) {
        return manufacturer != null && manufacturer.trim().length() <= 15 && !manufacturer.trim().isEmpty();
    }

    @Override
    public String toString() {
        return "PC<" + this.getModel() + ", " + this.getYear() + ", " + this.getManufacturer() +
                ", "+ this.getComps() +
                '>';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PC pc = (PC) o;
        return year == pc.year && Objects.equals(model, pc.model) && Objects.equals(manufacturer, pc.manufacturer) && Objects.equals(comps, pc.comps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, year, manufacturer, comps);
    }
}