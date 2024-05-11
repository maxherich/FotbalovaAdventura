public class Player {
    private String name;
    private double energy;
    private double rating;
    private double coachsTrust;
    private double productivity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getProductivity() {
        return productivity;
    }

    public void setProductivity(double productivity) {
        this.productivity = productivity;
    }

    public double getCoachsTrust() {
        return coachsTrust;
    }

    public void setCoachsTrust(double coachsTrust) {
        this.coachsTrust = rating*(energy/100)*productivity;
    }
}
