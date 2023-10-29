package simulator;

import coordinates.Coordinates;
import exceptions.InvalidAircraftException;
import flyable.AircraftFactory;
import exceptions.InvalidLineException;
import flyable.Flyable;
import simulation.Simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Simulator {
    private String filePath;
    private Integer simulationTimes;
    ArrayList<Flyable> flyables;

    public Simulator(String filePath) {
        this.filePath = filePath;
    }

    public void run() {
        try {
            LineNumberReader reader = new LineNumberReader(new FileReader(this.filePath));
            extractNbrSimulations(reader);
            extractAllAircraft(reader);
            runSimulations();
        } catch (IOException | InvalidLineException | InvalidAircraftException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    private void extractNbrSimulations(LineNumberReader reader) throws IOException, InvalidLineException {
        String nbrSimulationsLine = getNbrSimulationsLine(reader);
        this.simulationTimes = Integer.parseInt(nbrSimulationsLine.trim());
    }

    private static String getNbrSimulationsLine(LineNumberReader reader) throws IOException, InvalidLineException {
        String nbrSimulationsLine = reader.readLine();
        if (!isFirstLineValid(nbrSimulationsLine)) {
            throw new InvalidLineException("Invalid First line " + reader.getLineNumber());
        }
        return nbrSimulationsLine;
    }

    private static boolean isFirstLineValid(String nbrSimulationsLine) {
        return Pattern.matches("\\d+", nbrSimulationsLine);
    }

    private static void extractAllAircraft(LineNumberReader reader) throws IOException, InvalidLineException, InvalidAircraftException {
        String aircraftLine;
        while ((aircraftLine = reader.readLine()) != null) {
            if (isValidAircraftLine(aircraftLine, reader.getLineNumber())) {
                extractSingleAircraft(aircraftLine, reader.getLineNumber());
            } else {
                throw new InvalidLineException("Invalid line " + reader.getLineNumber());
            }
        }
    }

    private static boolean isValidAircraftLine(String line, int lineNb) {
        return true;
    }

    private static void extractSingleAircraft(String aircraftLine, int lineNumber) throws InvalidLineException, InvalidAircraftException {
        String aircraftType;
        String aircraftName;
        Coordinates aircraftCoordinates;
        try (Scanner scanner = new Scanner(aircraftLine)) {
            aircraftType = getAircraftType(lineNumber, scanner);
            aircraftName = getAircraftName(lineNumber, scanner);
            aircraftCoordinates = getAircraftCoordinates(lineNumber, scanner);
        }
        AircraftFactory aircraftFactory = AircraftFactory.getInstance();
        aircraftFactory.newAircraft(aircraftType, aircraftName, aircraftCoordinates);
    }

    private static Coordinates getAircraftCoordinates(int lineNumber, Scanner scanner) {
        ArrayList<Integer> coordinateNbs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (scanner.hasNextInt()) {
                coordinateNbs.add(scanner.nextInt());
            } else {
                throw new IllegalArgumentException("Invalid coordinate token in line" + lineNumber);
            }
        }
        return new Coordinates(coordinateNbs.get(0), coordinateNbs.get(1), coordinateNbs.get(2));
    }

    private static String getAircraftName(int lineNumber, Scanner scanner) throws InvalidLineException {
        String aircraftName;
        if (!scanner.hasNext("\\w+")) {
            throw new InvalidLineException("Invalid second token in line " + lineNumber);
        }
        aircraftName = scanner.next();
        return aircraftName;
    }

    private static String getAircraftType(int lineNumber, Scanner scanner) throws InvalidLineException {
        String aircraftType;
        if (!scanner.hasNext("\\w+")) {
            throw new InvalidLineException("Invalid first token in line " + lineNumber);
        }
        aircraftType = scanner.next();
        return aircraftType;
    }

    private void runSimulations() {
        Simulation simulation = new Simulation(flyables);
        for (int simulationId = 0; simulationId < simulationTimes; simulationId++) {
            simulation.run();
        }
    }


}