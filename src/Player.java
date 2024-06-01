public class Player {
    private String name;
    private int energy;
    private int rating;
    private Team team;
    private int weekSalary; // players weekly income
    private int money; // overall money player have

    public Player(String name, int energy, int rating, int money) {
        this.name = name;
        this.energy = energy;
        this.rating = rating;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { //regex for name
        if (name.matches("^[A-Z]{1}[a-z]+$")){
            this.name = name;
        }else {
            System.out.println("This name is not available");
        }
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) { // enrgy cant be more than 100 and less than 0
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

    public void setRating(int rating) { // rating cant be less than 0
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

    public int getWeekSalary() {
        return weekSalary;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}