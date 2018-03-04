package swimmers;

public class Swimmer implements Comparable<Swimmer> {

    private int height;
    private int weight;
    private int age;

    public Swimmer() {
   	 this(0, 0, 0);
    }

    public Swimmer(int ht, int wt, int age) {
   	 this.setHeight(ht);
   	 this.setWeight(wt);
   	 this.setAge(age);
    }

    public boolean equals(Swimmer o) {
   	 return this.height == o.height && this.weight == o.weight && this.age == o.age;
    }

    @Override
    public int compareTo(Swimmer o) {
    
   	 if (o.getHeight() != this.getHeight()) {
   		 return (o.getHeight() > this.height) ? -1 : 1;
   	 }
   	  if (o.getWeight() != this.weight) {
   		 return (o.getWeight() > this.weight) ? -1 : 1;
   	 }
   	  if (o.getAge() != this.age) {
   		 return (o.getAge() > this.age) ? -1 : 1;
   	 }
   	 
   	 if (o.equals(this)) {
   		 return 0;
   	 }

   	 return 1;
    }
    
    
    @Override
    public Swimmer clone() {
   	 return new Swimmer(this.height, this.weight, this.age);
    }

    public int getHeight() {
   	 return height;
    }

    public void setHeight(int height) {
   	 this.height = height;
    }

    public int getWeight() {
   	 return weight;
    }

    public void setWeight(int weight) {
   	 this.weight = weight;
    }

    public int getAge() {
   	 return age;
    }

    public void setAge(int age) {
   	 this.age = age;
    }

    
    public String toString() {
   	 return "" + this.height + " " + this.weight + " " + this.age;
    }
    
    
}


