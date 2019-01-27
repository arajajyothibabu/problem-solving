package stacksqueues;

import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/largest-rectangle
 *
 * Look at the picture below which pretty much shows the cases you need to consider.
 *
 * image
 *
 * Basically, we're going to start with building 1,
 * then compute all of the areas of each rectangle and choose the maximum from that.
 * Notice that when we start with building 1,
 * we have no idea when the end of it's rectangle will be (represented by a dashed arrow going to the right).
 * The next thing you should notice is that if the next building goes up (higher than the previous),
 * all active areas will remain active (i.e. we still haven't found the end of the area).
 *
 * When building 5 is added, it definitely ends the previous building's area (or whatever area it was part of) and,
 * in this case, that's it.
 * Also notice that we need to extend building 5 back through building 4.
 * How do you know to stop at building 4?
 * Easy, the next active area (coming from building 3) has a height lower than building 5's,
 * so that area is still active (in other words it will go through building 5).
 *
 * Hopefully you're starting to see how a stack can be used here:
 * when the next building is taller than the previous, add it to the stack (to be processsed later).
 * When the next building is shorter:
 *  pop off stack until you find a starting area with a smaller height (than the current building)
 *  or you empty the stack (meaning it goes all the way back through the first building).
 *  Now push this building's height along with it's left position onto the stack.
 *
 * When you pop off the stack,
 *  this means you've found the right side of an area, so compute its area and see if it's the maximum.
 *  Also when you find the "left wall" for the current building (meaning you found a smaller building in the stack or went all the way back to the first building), you need to remember that position in addition to the height of the current building so that when the current building is eventually popped off of the stack, you can properly compute it's area. Notice how building 6 extends both backwards and forwards, such that when I get to building 8, I have to know that building 6's height extended all the way back through building 2.
 *
 */
public class LargestRectangle {

    static long largestRectangle(int[] h) {
        long maxArea = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{h[0], 0});
        for(int i = 1; i < h.length; i++){
            int index = i;
            if(h[i] < h[i - 1]){
                while (!stack.empty() && stack.peek()[0] > h[i]){
                    index = stack.peek()[1];
                    maxArea = Math.max(maxArea, stack.peek()[0] * (i - index));
                    stack.pop();
                }
            }
            stack.push(new int[]{h[i], index});
        }
        while(!stack.empty()){
            maxArea = Math.max(maxArea, stack.peek()[0] * (h.length - stack.peek()[1]));
            stack.pop();
        }
        return maxArea;
    }

}
