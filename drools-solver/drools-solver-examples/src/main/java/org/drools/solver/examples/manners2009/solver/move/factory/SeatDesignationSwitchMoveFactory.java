package org.drools.solver.examples.manners2009.solver.move.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.drools.solver.core.move.Move;
import org.drools.solver.core.move.factory.CachedMoveFactory;
import org.drools.solver.core.solution.Solution;
import org.drools.solver.examples.manners2009.domain.Manners2009;
import org.drools.solver.examples.manners2009.domain.SeatDesignation;
import org.drools.solver.examples.manners2009.solver.move.SeatDesignationSwitchMove;

/**
 * @author Geoffrey De Smet
 */
public class SeatDesignationSwitchMoveFactory extends CachedMoveFactory {

    public List<Move> createCachedMoveList(Solution solution) {
        Manners2009 manners2009 = (Manners2009) solution;
        List<SeatDesignation> seatDesignationList = manners2009.getSeatDesignationList();
        List<Move> moveList = new ArrayList<Move>();
        for (ListIterator<SeatDesignation> leftIt = seatDesignationList.listIterator(); leftIt.hasNext();) {
            SeatDesignation leftSeatDesignation = leftIt.next();
            for (ListIterator<SeatDesignation> rightIt = seatDesignationList.listIterator(leftIt.nextIndex());
                    rightIt.hasNext();) {
                SeatDesignation rightSeatDesignation = rightIt.next();
                moveList.add(new SeatDesignationSwitchMove(leftSeatDesignation, rightSeatDesignation));
            }
        }
        return moveList;
    }

}