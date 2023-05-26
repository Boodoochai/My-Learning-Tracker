class ExpressionSolver {
    public static Integer solve(String _expression) {
        Stack<Integer> stack = new Stack<Integer>();
        String[] symbols = _expression.split(" ");
        for (String sym : symbols) {
            if (sym.matches("-?\\d+")) {
                stack.push(Integer.parseInt(sym));
            } else {
                Integer a = stack.pop();
                Integer b = stack.pop();
                switch (sym) {
                    case "=":
                        return a;
                    case "+":
                        stack.push(a + b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                }
            }
        }
        return null;
    }
}
