package pg42sg.task10de;

public class Exercise {

    public String ExerciseQuestion(){
        return "Exercise [0-9]{1,2}:\nFile: Ex[0-9]{2,}.(java|txt)";
    }

    public String ExerciseBogdanQuestion(){
        return "@Bogdan: .*(()*((A|a)lgdat)|((A|a)lgorithms)|((A|a)lgorithm)|((P|p)g4200))+.*?";
    }
}
