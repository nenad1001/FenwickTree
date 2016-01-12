
public class FenwickTree {
	
	private int capacity;
	
	private int[] tree;
	
	FenwickTree(int capacity) {
		this.capacity = capacity;
		
		tree = new int[capacity + 1];
		
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int read(int index) throws Exception{ // range sum 0 to index
		if (index < 0)
			throw new Exception("Index too small!");
	    int res = 0;
	    for (int i = index; i > 0; i -= (i & -i)){
	        res += tree[index];
	    }
	    return res;
	}
	
	public int readBetween(int index1, int index2) throws Exception { // range sum from index1 to index2
		if (index1 > index2)
			throw new Exception("Wrong range!");
		return read(index2) - read(index1 - 1);
	}
	
	public void update(int index, int value) { // update value at index and all other indexes affected by it
		for (int i = index; i <= capacity; i += (i & -i))
		        tree[i] += value;
	}
	
	public int fetchAt(int index) { // fetch value at some index
		int res = tree[index];
		if (index > 0){ 
		    int tmp = index - (index & -index); 
		    index--; 
		    for (int i = index; index != tmp; i -= (i & -i)){ 
		        res -= tree[index];
		    }
		}
		return res;
}
	
	private int getBitmask() {
		int tmp = capacity;
		int res = 0;
		while (tmp > 0) {
			res++;
			tmp >>= 1;
		}
		
		return 1 << res;
	}
	
	//if in tree exists more than one index with a same
	// cumulative frequency return any of them
	public int find(int cum){
	    int index = 0, bitmask = getBitmask();
	
	    while ((bitmask != 0) && (index < capacity)){
	        int mid = index + bitmask; 
	        if (cum == tree[mid]) 
	            return mid;
	        else if (cum > tree[index]){ 
	            index = mid; 
	            cum -= tree[index]; 
	        }
	        bitmask >>= 1;
	    }
	    if (cum == 0) 
	        return index;
	    
	    return -1;
	}


}
