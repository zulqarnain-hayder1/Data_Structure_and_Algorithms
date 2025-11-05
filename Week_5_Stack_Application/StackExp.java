import java.util.*;

class StackExp {

    static class Stk {
        char[] a;
        int top;
        int n;

        Stk(int s) {
            a = new char[s];
            top = -1;
            n = s;
        }

        void push(char c) {
            if (top == n - 1) {
                System.out.println("Stack Overflow!");
                return;
            }
            a[++top] = c;
            System.out.println(c + " pushed to stack.");
        }

        char pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow!");
                return '\0';
            }
            System.out.println(a[top] + " popped from stack.");
            return a[top--];
        }

        char peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return '\0';
            }
            System.out.println("Top element: " + a[top]);
            return a[top];
        }

        boolean isEmpty() {
            return top == -1;
        }

        void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return;
            }
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }

    static int prec(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        if (c == '^') return 3;
        return -1;
    }

    static String infixToPostfix(String exp) {
        StringBuilder r = new StringBuilder();
        Stk s = new Stk(exp.length());

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c))
                r.append(c);
            else if (c == '(')
                s.push(c);
            else if (c == ')') {
                while (!s.isEmpty() && s.peek() != '(')
                    r.append(' ').append(s.pop());
                s.pop();
            } else if ("+-*/^".indexOf(c) != -1) {
                r.append(' ');
                while (!s.isEmpty() && prec(c) <= prec(s.peek()))
                    r.append(s.pop()).append(' ');
                s.push(c);
            }
        }
        while (!s.isEmpty())
            r.append(' ').append(s.pop());
        return r.toString().trim();
    }

    static String infixToPrefix(String exp) {
        StringBuilder sb = new StringBuilder(exp).reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(')
                sb.setCharAt(i, ')');
            else if (sb.charAt(i) == ')')
                sb.setCharAt(i, '(');
        }
        String pre = infixToPostfix(sb.toString());
        String[] t = pre.split(" ");
        Collections.reverse(Arrays.asList(t));
        return String.join(" ", t);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stk stack = new Stk(5);
        int choice;

        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Stack Operations");
            System.out.println("2. Infix to Postfix Conversion");
            System.out.println("3. Infix to Prefix Conversion");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    int ch2;
                    do {
                        System.out.println("\n--- Stack Operations ---");
                        System.out.println("1. Push");
                        System.out.println("2. Pop");
                        System.out.println("3. Peek");
                        System.out.println("4. Check if Empty");
                        System.out.println("5. Display Stack");
                        System.out.println("6. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        ch2 = sc.nextInt();
                        sc.nextLine();

                        switch (ch2) {
                            case 1:
                                System.out.print("Enter element to push: ");
                                char c = sc.next().charAt(0);
                                stack.push(c);
                                break;
                            case 2:
                                stack.pop();
                                break;
                            case 3:
                                stack.peek();
                                break;
                            case 4:
                                System.out.println(stack.isEmpty() ? "Stack is empty." : "Stack is not empty.");
                                break;
                            case 5:
                                stack.display();
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Invalid choice!");
                        }
                    } while (ch2 != 6);
                    break;

                case 2:
                    System.out.print("Enter Infix Expression: ");
                    String infix1 = sc.nextLine().replaceAll("\\s+", "");
                    String post = infixToPostfix(infix1);
                    System.out.println("Postfix: " + post);
                    break;

                case 3:
                    System.out.print("Enter Infix Expression: ");
                    String infix2 = sc.nextLine().replaceAll("\\s+", "");
                    String pre = infixToPrefix(infix2);
                    System.out.println("Prefix: " + pre);
                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
