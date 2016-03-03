package demo.testObjects;


public class Person implements Comparable<Person>{
	private String Id;
	private String name;

	
	/**
	 * @return the id
	 */
	public String getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		Id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Person(String Id, String Name){
		this.name = Name;
		this.Id = Id;
	}

	@Override
	public int compareTo(Person p) {
		// TODO : add comparator sorting logic
		
		return (Integer.parseInt(this.Id)) - (Integer.parseInt(p.getId()));
	}

}
