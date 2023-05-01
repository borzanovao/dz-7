public enum Planets {
    Mercury(1, 0, 4879.4 / 2, null),
    Venus(2, 0.34, 12104 / 2, Planets.Mercury),
    Earth(3, 0.28, 12742 / 2, Planets.Venus),
    Mars(4, 0.37, 6779 / 2, Planets.Earth),
    Jupiter(5, 3.68, 139820 / 2, Planets.Mars),
    Saturn(6, 4.32, 116460 / 2, Planets.Jupiter),
    Uranus(7, 9.7, 50724 / 2, Planets.Saturn),
    Neptune(8, 10.88, 49244 / 2, Planets.Uranus);

    private final int numberFromSun;
    private final double distanceFromPreviousPlanetAU;
    private final double radius;
    private final Planets previousPlanet;
    private double distanceToSun;


    Planets(int numberFromSun, double distanceFromPreviousPlanetAU, double radius, Planets previousPlanet) {
        this.numberFromSun = numberFromSun;
        this.distanceFromPreviousPlanetAU = distanceFromPreviousPlanetAU;
        this.radius = radius;
        this.previousPlanet = previousPlanet;
        distanceToSun = distanceFromPreviousPlanetAU;
        while (previousPlanet != null) {
            distanceToSun += previousPlanet.distanceFromPreviousPlanetAU;
            previousPlanet = previousPlanet.previousPlanet;
        }

    }

    @Override
    public String toString() {
        return this.name() +"\n\tPlanet number:" + numberFromSun + " ,distance from previous planet AU - " + distanceFromPreviousPlanetAU + ", radius - " + radius + " ,distance to Sun - " + distanceToSun + ";";
    }

}
