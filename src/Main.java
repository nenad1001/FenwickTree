
public class Main {

	public static void main(String[] args) throws Exception {
		

		FenwickTree fenwick = new FenwickTree(5);
		
		
		fenwick.update(2, 3);
		fenwick.update(5, 1);
		fenwick.update(1, 6);
		
		System.out.println(fenwick.read(4));

	}

}
