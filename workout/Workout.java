package workout;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Workout {

    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;


    public Workout(String type, int exerciseCount) {

        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {

        if (this.exercises.size() < exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {

        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {

        return exercises.stream().filter(e -> e.getName().equals(name) && e.getMuscle().equals(muscle)).findFirst().orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream().reduce((e1, e2) -> e1.getBurnedCalories() > e2.getBurnedCalories() ? e1 : e2).orElse(null);
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public String getStatistics(){

        StringJoiner sj = new StringJoiner("\n");
        sj.add("Workout type: " + type);
        for (Exercise ex : this.exercises) {
            sj.add(ex.toString());
        }
        return sj.toString();
    }


}
