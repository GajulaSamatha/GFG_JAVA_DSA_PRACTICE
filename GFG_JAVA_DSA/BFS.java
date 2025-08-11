/**
 * BFS --> Breadth First Search
 * It is an searching algorithm used in the Graph or Tree data structures.
 * The process is exploring all the neighbour  nodes at the present depth prior to moving on to the nodes at 
 * the next depth level. Think of it like ripples expanding in a pond- we explore
 * everything at the current "ripple" before the next one spreads out.
 */
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
class BFS{
    public static void BFSTraversal(Scanner sc){
        Map<String, List<String>> graph = Map.of(
        "A", List.of("B", "C"),
        "B", List.of("A", "C", "D", "E"),
        "C", List.of("A", "B", "E"),
        "D", List.of("B", "E"),
        "E", List.of("B", "C", "D")
        );
       Queue<String> to_do = new LinkedList<>();
       Set<String> visited = new HashSet<>();
        System.out.println("Enter the Starting node: ");
        String current = sc.next();
        // Put the starting room on our to-do list
        to_do.add(current);
        // And mark it as checked
        visited.add(current);
        while(!to_do.isEmpty()){
            String curString  = to_do.remove();
            System.out.println("Current room = "+curString);
            for(String neighbor: graph.get(curString)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    to_do.add(neighbor);
                }
            }
        }
    }
     public static void DFSTraversal(Scanner sc){
        Map<String, List<String>> graph = Map.of(
        "A", List.of("B", "C"),
        "B", List.of("A", "C", "D", "E"),
        "C", List.of("A", "B", "E"),
        "D", List.of("B", "E"),
        "E", List.of("B", "C", "D")
        );
        Stack<String> to_do = new Stack<>();
        Set<String> visited = new HashSet<>();
        String current = sc.next();
        to_do.addElement(current);
        visited.add(current);
        while(!to_do.isEmpty()){
            String currString = to_do.pop();
            // The to_do.pop() command gives us the next room to check from our stack.
            // We need to save that room's name in a new variable, maybe we can call it currentRoom, right inside the while loop.
            System.out.println("our current room is :"+ currString);
            for(String neighbour: graph.get(currString )){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    to_do.push(neighbour);
                }
            }
        }
     } 
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        DFSTraversal(sc);
    }
}