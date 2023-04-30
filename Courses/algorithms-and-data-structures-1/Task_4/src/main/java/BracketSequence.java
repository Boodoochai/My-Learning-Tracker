class BracketSequence {
    public static boolean isCorrect(String sequence) {
        Stack<Character> stack = new Stack<Character>();
        for (Character bracket : sequence.toCharArray()) {
            if (bracket == Character.valueOf('(')) {
                stack.push(bracket);
                continue;
            }

            if (stack.pop() == null) {
                return false;
            }
        }
        if (stack.size() != 0) {
            return false;
        }
        return true;
    }
}
