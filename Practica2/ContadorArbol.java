package Practica2;
import java.util.*;

public class ContadorArbol {
	BinaryTree <Integer> data;
	
	
	
	
	
	public ContadorArbol(BinaryTree<Integer> data) {
		super();
		this.data = data;
	}
	
	

	public BinaryTree<Integer> getData() {
		return data;
	}



	public void setData(BinaryTree<Integer> data) {
		this.data = data;
	}



	private void recorridoPreOrden(BinaryTree<Integer> ab, List <Integer> l){
		if (ab.getData()!= null) {
			if ((ab.getData() % 2) == 0) {
				l.add(ab.getData());
			}
			if (ab.hasLeftChild())
				recorridoPreOrden(ab.getLeftChild(),l);
			if (ab.hasRightChild())
				recorridoPreOrden(ab.getRightChild(),l);
		}
	}
	
	public List<Integer> numerosParesPreOrden(){
		List <Integer> l = new LinkedList <Integer>();
		recorridoPreOrden (this.getData(), l);
		return l;
		
	}
	
	private void recorridoPostOrden(BinaryTree <Integer> ab, List <Integer> l){
		if (ab.getData()!= null) {
			if (ab.hasLeftChild())
				recorridoPostOrden(ab.getLeftChild(),l);
			if (ab.hasRightChild())
				recorridoPostOrden(ab.getRightChild(),l);
			if ((ab.getData() % 2) == 0) {
				l.add(ab.getData());
			}
		}
	}
	
	public List<Integer> numerosParesPostOrden(){
		List <Integer> l = new LinkedList <Integer>();
		recorridoPostOrden (this.getData(),l);
		return l;
	}
	
	private void recorridoInOrden(BinaryTree <Integer> ab, List <Integer> l){
		if (ab.getData()!= null) {
			if (ab.hasLeftChild())
				recorridoPostOrden(ab.getLeftChild(),l);
			
			if ((ab.getData() % 2) == 0) {
				l.add(ab.getData());
			}
			
			if (ab.hasRightChild())
				recorridoPostOrden(ab.getRightChild(),l);
			
		}
	}
	
	public List<Integer> numerosParesInOrden(){
		List <Integer> l = new ArrayList <Integer>();
		recorridoInOrden (this.getData(),l);
		return l;
	}

}
