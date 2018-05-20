package Tree_Graphs;

import java.util.ArrayList;
import java.util.HashMap;

class Graph{
	
	private ArrayList<Project> nodes = new ArrayList<Project>();
	private HashMap<String, Project> map =  new HashMap<String, Project>();
	
	public Project getOrCreateNode(String name){
		if(!map.containsKey(name)){
			Project node = new Project(name);
			nodes.add(node);
			map.put(name, node);
		}
		
		return map.get(name);
	}
	public void addEgde(String startName, String endName){
		Project start = getOrCreateNode(startName);
		Project end = getOrCreateNode(endName);
		start.addNeighbor(end);
	}
	public ArrayList<Project> getNodes(){
		
		return nodes;
	}
}

class Project{
	
	private ArrayList<Project> children = new ArrayList<Project>();
	private HashMap<String, Project> map =  new HashMap<String, Project>();
	private String name;
	private int dependencies = 0;
	
	public Project(String n){ name = n; }
	
	public void addNeighbor(Project node){
		if(!map.containsKey(node.getName())){
			children.add(node);
			map.put(node.getName(), node);
			node.increamentDependecies();
			
		}
		
	}
	
	public String getName(){ return name;	}
	public void increamentDependecies(){ dependencies++;	}
	public void decreamentDependecies(){ dependencies--;	}
	public ArrayList<Project> getChildren(){return children;}
	public int getNumberOfDependencies(){ return dependencies;}
}

public class Build_Order {
	
	Project[] findbuildOrder(String[] projects, String[][] dependencies){
		Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}
	
	Graph buildGraph(String[] projects, String[][] dependencies){
		
		Graph graph =  new Graph();
		for(String project : projects){
			graph.getOrCreateNode(project);
			
		}
		for(String[] dependency: dependencies){
			String first = dependency[0];
			String second = dependency[1];
			graph.addEgde(first, second);
		}
		return graph;
	}
	Project[] orderProjects(ArrayList<Project> projects){
		
		Project[] order = new Project[projects.size()];
		int endOfList = addNondependent(order, projects, 0);
		
		int toBeProcessed = 0;
		while(toBeProcessed < order.length){
			Project current = order[toBeProcessed];
			if(current == null){
				return null;
			}
			ArrayList<Project> children = current.getChildren();
			for(Project child : children){
				child.decreamentDependecies();
			}
			endOfList  =  addNondependent(order, projects, endOfList);
			toBeProcessed++;
		}
		
		return order;
	}
	
	public int addNondependent(Project[] order, ArrayList<Project> projects, int offset){
		
		for(Project project: projects){
			if(project.getNumberOfDependencies() == 0){
				order[offset] = project;
				offset++;
			}
		}
		
		return offset;
	}
	

	public static void main(String arg[]){
		
		Build_Order bo = new Build_Order();
		String[] projects = {"a","b","c","d","e","f"};
		String[][] dependencies = {{"a","d"},{"b","d"},{"d","c"},{"f","b"},{"f","a"}};
		
		for(Project project: bo.findbuildOrder(projects, dependencies)){
			
			System.out.println(project.getName() +" ");
		}
		
	}
	
}
