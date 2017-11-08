/*
 * Function: use 2 Stacks to implement Queue
 * Note: Stacks(LIFO) VS Queues(FIFO)
 */

package stacksAndQueues;

import java.util.Stack;

public class TwoStacksForAQueue {

	public static void main(String[] args) {
		MyQueue<String> mq = new MyQueue<String>();
		mq.add("a");
		mq.add("b");
		mq.add("c");
		String rt = mq.peek();
		System.out.println(rt);
		mq.remove();
		rt = mq.peek();
		System.out.println(rt);
	}
	
}

class MyQueue<T>{
	Stack<T> stackNewest, stackOldest;
	MyQueue(){
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}
	int size(){
		return stackNewest.size() + stackOldest.size();
	}
	void add(T value){
	//add an item to the top of the stackNewest
	stackNewest.push(value);
	}
	void shiftStacks(){
		if(stackOldest.isEmpty()){
			while(!stackNewest.isEmpty()){
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	T peek(){
		shiftStacks();
		return stackOldest.peek();
	}
	T remove(){
		shiftStacks();
		return stackOldest.pop();
	}
}

