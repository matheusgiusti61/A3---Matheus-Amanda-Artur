

import java.util.ArrayList;
import java.util.List;

public class ProcessGenerator {

    public static class Process {
        public String id;
        public int arrivalTime;
        public int executionTime;
        public int remainingTime;
        public int priority;

        public Process(String id, int arrivalTime,
                       int executionTime, int priority) {
            this.id = id;
            this.arrivalTime = arrivalTime;
            this.executionTime = executionTime;
            this.remainingTime = executionTime;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return id + " | chegada: " + arrivalTime
                + " | execução: " + executionTime
                + " | prioridade: " + priority;
        }
    }

    private int duration;
    private int minExecution;
    private int maxExecution;
    private int minPriority;
    private int maxPriority;
    private String profile;

    private long randomState;
    private int nextId = 1;
    private int nextArrival = 0;

    public ProcessGenerator(
            int duration,
            int minExecution,
            int maxExecution,
            int minPriority,
            int maxPriority,
            String profile,
            long seed) {

        this.duration = duration;
        this.minExecution = minExecution;
        this.maxExecution = maxExecution;
        this.minPriority = minPriority;
        this.maxPriority = maxPriority;
        this.profile = profile.toLowerCase();

        this.randomState = Math.abs(seed) % 2147483646L + 1;
    }

    // Gerador pseudoaleatório reproduzível
    private double random() {
        randomState = (randomState * 48271L) % 2147483647L;
        return (double) randomState / 2147483647L;
    }

    private int randomInt(int min, int max) {
        return min + (int) (random() * (max - min + 1));
    }

    // Define o intervalo conforme o perfil de demanda
    private int getArrivalInterval(int time) {

        int min;
        int max;

        switch (profile) {
            case "light":
                min = 5;
                max = 9;
                break;

            case "heavy":
                min = 1;
                max = 2;
                break;

            case "burst":
                if ((time / 20) % 2 == 0) {
                    min = 1;
                    max = 2;
                } else {
                    min = 5;
                    max = 8;
                }
                break;

            case "moderate":
            default:
                min = 2;
                max = 4;
                break;
        }

        return randomInt(min, max);
    }

    private Process createProcess(int arrivalTime) {

        return new Process(
            "P" + nextId++,
            arrivalTime,
            randomInt(minExecution, maxExecution),
            randomInt(minPriority, maxPriority)
        );
    }

    // Retorna os processos que chegaram até o instante informado
    public List<Process> generateAt(int currentTime) {

        List<Process> arrivals = new ArrayList<>();

        while (nextArrival <= currentTime
                && nextArrival < duration) {

            Process process = createProcess(nextArrival);

            arrivals.add(process);

            nextArrival += getArrivalInterval(nextArrival);
        }

        return arrivals;
    }
}

