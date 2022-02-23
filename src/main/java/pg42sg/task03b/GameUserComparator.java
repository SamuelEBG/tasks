package pg42sg.task03b;

import java.util.Comparator;

    // Implement the class GameUser, where it is possible
    // to create a GameUser with String Id and int points.
public class GameUserComparator implements Comparator<GameUser> {

    // Override the compare function to return positive number if
        // GameUser o1 has more points than B, or if they are equal
        // it returns the id with lexicographically the greatest value,
        // which means the highest binary number of the first digit
    @Override
    public int compare(GameUser a, GameUser b) {
            // If the first player has a greater score than player B, the
            // difference of the scores is returned, the sort-method
            // is given a >0 int returned and therefore swaps the indexes so that the
            // player with the greater score is pushed "forwards" ( towards the end of the index).
        if(a.getPoints() > b.getPoints()){
            return a.getPoints()-b.getPoints();
        } else if(a.getPoints() == b.getPoints()){  // If the players scores are equal, the player with the
            return a.getUserId().compareTo(b.getUserId());  // higher value of Strings is pushed forward.
        }
        return a.getPoints()-b.getPoints(); // If the a players score is lower than the b players score
                                            // this will return a negative number and thus nothing will change in the order.
    }

}
