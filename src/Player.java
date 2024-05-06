public class Player {

    private double energy;
    private double rating;
    private double coachsTrust;
    private double productivity;

    public void setCoachsTrust(double coachsTrust) {
        this.coachsTrust = rating*(energy/100)*productivity;
    }
}
