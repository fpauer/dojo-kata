package FacebookInterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fernandopauer on 5/1/17.
 */
class BalancedParenthesisTest {

    BalancedParenthesis bp = new BalancedParenthesis();

    @Test
    void isBalanced() {
        assertTrue(bp.isBalanced("()"));
        assertTrue(bp.isBalanced("(())"));
        assertTrue(bp.isBalanced("()()()"));
        assertTrue(bp.isBalanced("((()))"));
        assertTrue(bp.isBalanced("()(())"));
    }

    @Test
    void isNOTBalanced() {
        assertFalse(bp.isBalanced(")()"));
        assertFalse(bp.isBalanced("()))"));
        assertFalse(bp.isBalanced("())()"));
        assertFalse(bp.isBalanced("(()))"));
        assertFalse(bp.isBalanced("()())"));
    }

    @Test
    void multipleBracketsIsBalanced() {
        assertTrue(bp.isBalanced("{}()"));
        assertTrue(bp.isBalanced("[{}]"));
        assertTrue(bp.isBalanced("(){}[]"));
        assertTrue(bp.isBalanced("{[()]}"));
        assertTrue(bp.isBalanced("[][{}]"));
    }

    @Test
    void multipleBracketsIsNOTBalanced() {
        assertFalse(bp.isBalanced("{)(}"));
        assertFalse(bp.isBalanced("[{]]"));
        assertFalse(bp.isBalanced("(}(}[]"));
        assertFalse(bp.isBalanced("([[}]}"));
        assertFalse(bp.isBalanced("[][{]"));
    }

}