package Model;

import java.util.ArrayList;
import static java.lang.Float.POSITIVE_INFINITY;
//import java.util.Comparator;

public class PlanetSystem {
    private ArrayList<Planet> planetList;
    private Star centerStar;
    private String name;
    String pictureUrl;

    public PlanetSystem(String name, Star centerStar, ArrayList<Planet> planetList,String pictureUrl) {
        this.name = name;
        this.centerStar = centerStar;
        this.planetList = planetList;
        this.pictureUrl = pictureUrl;
    }
    public PlanetSystem(){}

    public ArrayList<Planet> getPlanetList() {
        return planetList;
    }

    public void setPlanetList(ArrayList<Planet> planetList) {
        this.planetList = planetList;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Planet getPlanet(String planet) {
        for (Planet value : planetList) {
            if (planet.equals(value.getName())) {
                return value;
            }
        }
        return null;
    }



    public ArrayList<Planet> getPlanets() {
        return new ArrayList<Planet>(planetList);
    }

//this is what i used before the project was re-written
//        Planet largestMass = planetList.stream().max(Comparator.comparingDouble(Planet::getMass)).get();
//        Planet largestRadius = planetList.stream().max(Comparator.comparingDouble(Planet::getRadius)).get();
//        Planet smallestMass = planetList.stream().min(Comparator.comparingDouble(Planet::getMass)).get();
//        Planet smallestRadius = planetList.stream().min(Comparator.comparingDouble(Planet::getRadius)).get();


    public Planet biggestPlanet() {
        double comparator = 0;
        Planet biggest = null;
        for (int i = 0; i < planetList.size(); i++) {
            for (int j = 0; j < planetList.size(); j++) {
                if ((i != j) && (Math.abs(planetList.get(i).getRadius() - planetList.get(j).getRadius()) < 0.00000001)) {
                    return massCheck();
                }
            }
            if (planetList.get(i).getRadius() > comparator) {
                comparator = planetList.get(i).getRadius();
                biggest = planetList.get(i);
            }
        }
        return biggest;
    }

    public Planet massCheck() {  //originally had this as private as it's only used in this class but i thought i'd make it public in case someone wants to know what planet is the most massive
        double comparator = 0;
        Planet massivert = null;
        for (int i = 0; i < planetList.size(); i++) {
            for (int j = 0; j < planetList.size(); j++) {
                if ((i != j) && (Math.abs(planetList.get(i).getMass() - planetList.get(j).getMass()) < 0.00000001)) {
                    return planetList.get(i); //stupid that i can't return a string with the two planets in it declearing that two planets are exactly alike
                }//even though the likelihood of that happening is basically 0. but so is the likelihood of two planets having the exact same radius so this code doesn't actaully have any reason to exsist but im making it anyway
            }
            if (planetList.get(i).getMass() > comparator) {
                comparator = planetList.get(i).getMass();
                massivert = planetList.get(i);
            }
        }
        return massivert;
    }


    public Planet smallestPlanet() {

        double comparator = POSITIVE_INFINITY;
        Planet smallest = null;
        for (int i = 0; i < planetList.size(); i++) {
            for (int j = 0; j < planetList.size(); j++) {
                if ((i != j) && (Math.abs(planetList.get(i).getRadius() - planetList.get(j).getRadius()) < 0.00000001)) {
                    return smallMassCheck();
                }
            }
            if (planetList.get(i).getRadius() < comparator) {
                comparator = planetList.get(i).getRadius();
                smallest = planetList.get(i);
            }
        }
        return smallest;
    }


    public Planet smallMassCheck() {
        double comparator = POSITIVE_INFINITY;
        Planet massivert = null;
        for (int i = 0; i < planetList.size(); i++) {
            for (int j = 0; j < planetList.size(); j++) {
                if ((i != j) && (Math.abs(planetList.get(i).getMass() - planetList.get(j).getMass()) < 0.00000001)) {
                    return planetList.get(i); //stupid that i can't return a string with the two planets in it declearing that two planets are exactly alike
                }//even though the likelihood of that happening is basically 0. but so is the likelihood of two planets having the exact same radius so this code doesn't actaully have any reason to exsist but im making it anyway
            }
            if (planetList.get(i).getMass() < comparator) {
                comparator = planetList.get(i).getMass();
                massivert = planetList.get(i);
            }
        }
        return massivert;
    }


    @Override
    public String toString() {
        return "The star of the " + name + " is " + centerStar.getName() + " and the planets are " + planetList;
    }
}