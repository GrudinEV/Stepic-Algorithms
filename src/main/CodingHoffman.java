package main;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

public class CodingHoffman {
	private static HashMap<String, Integer> charactersMap = new HashMap<>();
	private static HashMap<String, String> resultMap = new HashMap<>();
	private static PriorityQueue<Node> queue;
	
	private static Comparator<Node> priorityComparator = new Comparator<Node>() {
		@Override
		public int compare(Node n1, Node n2) {
			return n1.priority - n2.priority;
		}
	};

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String s = sc.nextLine();
//		sc.close();
		
		String s = "";
		for (int i = 0; i < 6500; i++) {
			s += String.valueOf((char) (Math.random() * 26 + 97));
		}
		
		createCharactersMap(s);
		
		queue = new PriorityQueue<Node>(priorityComparator);
		
		charactersMap.forEach((k, v) -> {
			Node node = new Node(k, v);
			queue.add(node);
		});
		
		while (queue.size() > 1) {
			Node node1 = queue.poll();
			Node node2 = queue.poll();
			node1.code = "0";
			node2.code = "1";
			Node parentNode = new Node(node1.value + node2.value, node1.priority + node2.priority);
			parentNode.leftChild = node1;
			parentNode.rightChild = node2;
			queue.add(parentNode);
		}
		Node root = queue.poll();
		if (charactersMap.size() > 1) {
			root.priority = 0;
		} else {
			root.code = "0";
		}
				
		System.out.println(charactersMap.size() + " " + lenStr(root));
		
//		TreeSet<Map.Entry<String, Integer>> set = new TreeSet<>(new MyComparator());
//		System.out.println(charactersMap.size());
//		for (Map.Entry<String, Integer> entry : charactersMap.entrySet()) {
//			set.add(entry);
//		}
//		System.out.println(set.size());
		
		for (Map.Entry<String, Integer> entry : charactersMap.entrySet()) {
			String code = createCode(entry.getKey(), root);
			System.out.println(entry.getKey() + ": " + code);
			resultMap.put(entry.getKey(), code);
		}
		System.out.println(resultMap.size());
		
		String character = new String();
		for (int i = 0; i < s.length(); i++) {
			character = String.valueOf(s.charAt(i));
			System.out.print(resultMap.get(character));
		}
	}
	
//	private static class MyComparator implements Comparator<Map.Entry<String, Integer>> {
//		@Override
//		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
//			if (o2.getValue() == o1.getValue()) {
//				return o1.getKey().compareTo(o2.getKey());
//			}
//			return o2.getValue() - o1.getValue();
//		}
//		
//	}
	
	private static int lenStr(Node root) {
		if (root.leftChild == null) {
			return root.priority;
		}
		return root.priority + lenStr(root.leftChild) + lenStr(root.rightChild);
	}

	private static class Node {
		String value;
		String code = "";
		int priority;
		Node leftChild = null;
		Node rightChild = null;
		
		Node(String value, int priority) {
			this.value = value;
			this.priority = priority;
		}
	}
	
	private static void createCharactersMap(String s) {
		String character = new String();
		for (int i = 0; i < s.length(); i++) {
				character = String.valueOf(s.charAt(i));
				if (!charactersMap.containsKey(character)) {
					charactersMap.put(character, 1);
				} else {
					int priority = charactersMap.get(character);
					priority++;
					charactersMap.put(character, priority);
				}
		}
	}
	
	private static String createCode(String character, Node node) {
		if (node.leftChild == null) {
			return node.code;
		}
		if (node.leftChild.value.contains(character)) {
			return node.code + createCode(character, node.leftChild);
		} else {
			return node.code + createCode(character, node.rightChild);
		}
	}
	
}
