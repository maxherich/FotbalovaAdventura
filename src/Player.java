public class Player {
    private String name;
    private int energy;
    private int rating;
    private Team team;
    private int weekSalary;
    private int money;

    public Player(String name, int energy, int rating, int money) {
        this.name = name;
        this.energy = energy;
        this.rating = rating;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if (energy > 100){
            this.energy = 100;
        }else if (energy < 0){
            this.energy = 0;
        }else {
            this.energy = energy;
        }
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating < 0){
            this.rating = 0;
        }else {
            this.rating = rating;
        }
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setWeekSalary(Team team) {
        this.weekSalary = team.getSalary();
    }

    public void setMoney() {
        this.money = money + weekSalary;
    }
}